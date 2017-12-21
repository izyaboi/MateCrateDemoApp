package com.example.lancelotmatecrate.matecratedemoapp.matecrate

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.example.lancelotmatecrate.matecratedemoapp.model.Animal



/**
 * Created by lancelotmatecrate on 20.12.17.
 */
class MateCrateViewModel(val animal: Animal) : BaseObservable() {

    @Bindable
    fun getName() = animal.name


    @Bindable
    fun getHungar() = animal.hungerIndex.toString()

    @Bindable
    fun getImageUrl() = animal.imageUrl
}