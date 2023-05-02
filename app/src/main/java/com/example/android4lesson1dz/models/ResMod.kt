package com.example.android4lesson1dz.models

import com.google.gson.annotations.SerializedName

data class ResMod(
    @SerializedName("data")
    val data : DataItem
)