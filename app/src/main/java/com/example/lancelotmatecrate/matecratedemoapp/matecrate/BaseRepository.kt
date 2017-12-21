package com.example.lancelotmatecrate.matecratedemoapp.matecrate


import com.example.lancelotmatecrate.matecratedemoapp.model.Animals
import io.reactivex.Flowable

/**
 * Created by lancelotmatecrate on 20.12.17.
 */
interface BaseRepository {

    fun getAnimals(): Flowable<Animals>
}