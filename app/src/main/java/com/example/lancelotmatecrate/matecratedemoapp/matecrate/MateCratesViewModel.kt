package com.example.lancelotmatecrate.matecratedemoapp.matecrate

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import com.example.lancelotmatecrate.matecratedemoapp.BR
import com.example.lancelotmatecrate.matecratedemoapp.model.Animal
import com.example.lancelotmatecrate.matecratedemoapp.model.Animals
import io.reactivex.Flowable

/**
 * Created by lancelotmatecrate on 20.12.17.
 */
class MateCratesViewModel(val baseRepository: BaseRepository) : BaseObservable() {

    var isLoading = false
    var animals: Animals? = null


    fun loadAnimals(onAnimalsLoaded: () -> Unit) = subscribeWithProgress(baseRepository.getAnimals(), onAnimalsLoaded)


    private fun subscribeWithProgress(flowable: Flowable<Animals>, onSuccess: () -> Unit) =
            flowable.doOnSubscribe { setProgress(true) }
                    .doOnError { setProgress(false) }
                    .subscribe({
                        animals = it
                        setProgress(false)
                        onSuccess()
                    }, { onError(it) })

    private fun onError(error: Throwable) {
        Log.e("ERROR", "we had a problem", error)
    }

    private fun setProgress(showProgess: Boolean) {
        this.isLoading = showProgess
        notifyPropertyChanged(BR.progressVisible)
    }

    @Bindable
    fun isProgressVisible() = isLoading

    fun getMateCrateViewModel(position: Int) = MateCrateViewModel(animals?.animals!![position])
    fun getNumberOfAnimals() = animals?.animals!!.size

}