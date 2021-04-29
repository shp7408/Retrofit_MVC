package com.example.inflepick_2021_03_03.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// 메인엑티비티 - 홈프래그먼트 에서 hot아이템 부분 뷰페이져에 넣을 데이터 클래스

class HotItemModel {
    @SerializedName("total_product")
    @Expose
    var totalProduct: Int? = null

    @SerializedName("product_list")
    @Expose
    var productList: List<ProductList>? = null

}

class ProductList {
    @SerializedName("product_idx")
    @Expose
    var productIdx: Int? = null

    @SerializedName("product_image_path")
    @Expose
    var productImagePath: String? = null

    @SerializedName("brand")
    @Expose
    var brand: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("product_category")
    @Expose
    var productCategory: String? = null

    @SerializedName("statistics")
    @Expose
    var statistics: Statistics? = null

}

class Statistics {
    @SerializedName("mention_count")
    @Expose
    var mentionCount: Int? = null

    @SerializedName("posts_count")
    @Expose
    var postsCount: Int? = null

    @SerializedName("hashtag_count")
    @Expose
    var hashtagCount: Int? = null

    @SerializedName("blog_count")
    @Expose
    var blogCount: Int? = null

}
