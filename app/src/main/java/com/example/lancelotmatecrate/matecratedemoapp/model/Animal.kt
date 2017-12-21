package com.example.lancelotmatecrate.matecratedemoapp.model
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose




/**
 * Created by admin on 20.12.2017.
 */

data class Animal (

	@SerializedName("id")
	@Expose
	var id: Int? = null,
	@SerializedName("name")
	@Expose
	var name: String? = null,
	@SerializedName("imageUrl")
	@Expose
	var imageUrl: String? = null,
	@SerializedName("hunger_index")
	@Expose
	var hungerIndex: Int? = null

)