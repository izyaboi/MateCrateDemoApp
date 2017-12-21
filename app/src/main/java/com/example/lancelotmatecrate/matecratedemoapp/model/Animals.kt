package com.example.lancelotmatecrate.matecratedemoapp.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose



/**
 * Created by admin on 20.12.2017.
 */
data class Animals (

    @SerializedName("animals")
    @Expose
    var animals: List<Animal>? = null

)