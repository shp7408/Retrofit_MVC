package com.example.inflepick_2021_03_03.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/mobile/home/hot_posts")
    fun getHotContent(
        /* 파라미터 2개인 경우 */
        @Query("select_date")
        select_date: String
        ,@Query("request_count")
        request_count: Int
    ): Call<HotContentModel>


    @GET("/mobile/home/hot_mention_product")
    fun getHotItem(
        /* 파라미터 2개인 경우 */
        @Query("select_date")
        select_date: String
        ,@Query("request_count")
        request_count: Int
    ): Call<HotItemModel>

    @GET("/mobile/home/hot_influencer")
    fun getHotIfluencer(
        /* 파라미터 2개인 경우 */
        @Query("select_date")
        select_date: String
        ,@Query("request_count")
        request_count: Int
    ): Call<HotInfluencerModel>

    @GET("/mobile/home/hot_keyword")
    fun getTag(
        /* 파라미터 1개인 경우 */
        @Query("request_count")
        request_count: Int
    ): Call<TagModel>
}