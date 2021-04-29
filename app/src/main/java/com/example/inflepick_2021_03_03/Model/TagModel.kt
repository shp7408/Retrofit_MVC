package com.example.inflepick_2021_03_03.Model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class TagModel {
    @SerializedName("hot_keyword")
    @Expose
    var hotKeyword: List<String>? = null

}