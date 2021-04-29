package com.example.inflepick_2021_03_03.Model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
//

/* http://www.jsonschema2pojo.org/ -> pojo 생성하는 사이트 임
json 구조를 데이터 클래스와 일치시키기 위함*/

class HotContentModel {
    @SerializedName("total_posts")
    @Expose
    var totalPosts: Int? = null

    @SerializedName("posts_list")
    @Expose
    var postsList: List<PostsList>? = null

}

class PostsList {
    @SerializedName("posts_idx")
    @Expose
    var postsIdx: Int? = null

    @SerializedName("platform")
    @Expose
    var platform: String? = null

    @SerializedName("thumbnail_image_path")
    @Expose
    var thumbnailImagePath: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

}
