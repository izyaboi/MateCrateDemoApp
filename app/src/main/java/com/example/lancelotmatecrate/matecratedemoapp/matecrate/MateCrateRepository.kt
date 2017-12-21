package com.example.lancelotmatecrate.matecratedemoapp.matecrate

import com.example.lancelotmatecrate.matecratedemoapp.model.Animal
import com.example.lancelotmatecrate.matecratedemoapp.model.Animals
import io.reactivex.Flowable
import io.reactivex.Scheduler

/**
 * Created by lancelotmatecrate on 20.12.17.
 */
class MateCrateRepository(val mateCrateController: MateCrateController, val observeOn: Scheduler, val subscribeOn: Scheduler) : BaseRepository {


    override fun getAnimals() : Flowable<Animals> = mateCrateController.getAnimals()
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
}