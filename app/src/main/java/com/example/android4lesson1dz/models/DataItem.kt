package com.example.android4lesson1dz.models

import com.example.android4lesson1dz.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("links")
    val links: Links,
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    override val id: String,
    @SerializedName("type")
    val type: String
): IBaseDiffModel