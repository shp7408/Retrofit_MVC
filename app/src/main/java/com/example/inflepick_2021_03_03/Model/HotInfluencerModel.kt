package com.example.inflepick_2021_03_03.Model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class HotInfluencerModel {
    @SerializedName("total_influencer")
    @Expose
    var totalInfluencer: Int? = null

    @SerializedName("influencer_list")
    @Expose
    var influencerList: List<InfluencerList>? = null

}

class InfluencerList {
    @SerializedName("influencer_idx")
    @Expose
    var influencerIdx: Int? = null

    @SerializedName("profile_image_path")
    @Expose
    var profileImagePath: String? = null

    @SerializedName("nickname")
    @Expose
    var nickname: String? = null

    @SerializedName("category_name")
    @Expose
    var categoryName: List<String>? = null

    @SerializedName("month_subscriber_count")
    @Expose
    var monthSubscriberCount: String? = null

    @SerializedName("subscriber_count")
    @Expose
    var subscriberCount: String? = null

}