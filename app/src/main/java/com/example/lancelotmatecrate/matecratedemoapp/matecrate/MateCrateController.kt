package com.example.lancelotmatecrate.matecratedemoapp.matecrate

import com.example.lancelotmatecrate.matecratedemoapp.model.Animals
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Created by lancelotmatecrate on 20.12.17.
 */
class MateCrateController(val mateCrateApi: MateCrateApi) {

    fun getAnimals(): Flowable<Animals> {
        return mateCrateApi.getAnimals()
    }


    interface MateCrateApi {

        @GET("animals")
        @Headers("Content-Type: application/json")
        fun getAnimals() : Flowable<Animals>

    }
}