package com.example.inflepick_2021_03_03.Model

import kotlinx.serialization.Serializable

/*
//hot 컨텐츠
@Serializable
data class contentList (
    var hotContentList : List<contentList>? = null
)


//hot 컨텐츠
@Serializable
data class hotContentList (
    var hotContentList : List<contentList>? = null
)
*/

/*



//===TEST=======================================================================================
@Serializable
data class TestDTO (
    var test: String
)

@Serializable
data class LoginDTO (
    var ID: String,
    var passwd: String
)



@Serializable
data class influencer_list (
    var influencer_idx: Int,
    var profile_image_path: String,
    var nickname: String,
    var subscriber_count: String,
    var favourite_status: Int,
    var total_posts: Int,
    var posts_list : List<posts_list>? = null,
    var total_channel : Int,
    var channel_link : List<channel_link>? =null
)

@Serializable
data class product_list (
    var product_idx: Int,
    var product_image_path: String,
    var name: String,
    var brand: String,
    var mention_count: Int,
    var favourite_status: Int,
    //var advertise_status: Int, //0: 광고 아님 1: 광고
    var product_advertise_status: Int   //0: 광고 아님 1: 광고 //둘중하나는 삭제
)

@Serializable
data class posts_list (
    var posts_idx: Int,
    var platform: String, //y: 유튜브 i:인스타그램 tt: 틱톡 f: 페이스북 tw: 트위터
    //var posts_image_path: String, //홈프래그(핫컨텐츠)
    var thumbnail_image_path: String, //인플프래그
    var title : String, //콘텐츠(영상 등) 제목
    var favourite_status: Int,  //0: 북마크 미등록 1: 북마크 등록된 게시물
    var posts_advertise_status: Int,

    //인플디테일에서추가
    var upload_date : String,
    var views : String,
    var likes : String,
    var total_product : Int,
    var product_list : List<product_list>? = null,

    //상품디테일에서 추가
    var influencer_idx : Int ,
    var influencer_name: String ,
    var profile_image_path : String,
    var posts_tag : List<String>,
    //var advertise_status : Boolean, //0: 광고 아님 1: 광고
    var valuation : Int //1: 긍정 2: 보통 3: 부정
    ,var valuation_tag : List<String>

    )

@Serializable
data class channel_link (
    var channel_idx: Int,
    var platform: String,
    var channel_url: String
)

@Serializable
data class category (
    var category_idx: Int,
    var name: String,
    var image_path: String
)

//===Home_Fragment=====start==========================================
//hot 인플루언서
@Serializable
data class hotInfluencerList (
    var influencer_list : List<influencer_list>? = null
)

//hot 언급 상품
@Serializable
data class hotProductList (
    var product_list : List<product_list>? = null
)

//hot 컨텐츠
@Serializable
data class hotContentList (
    var posts_list : List<posts_list>? = null
)
//===Home_Fragment=====finish=========================================

//===Product_Fragment=====start==========================================
//인플루언서 언급 TOP3 조회
@Serializable
data class topMentionList (
    var total_product : Int,
    var product_list : List<product_list>? = null
)

//조회많은 상품 조회
@Serializable
data class bestViewsList (
    var total_product :Int,
    var is_next_page : Boolean,
    var last_page_num : Int,
    var product_list : List<product_list>? = null
)

//최신상품 조회
@Serializable
data class newProductList (
    var total_product :Int,
    var is_next_page : Boolean,
    var last_page_num : Int,
    var product_list : List<product_list>? = null
)
//===Product_Fragment=====finish=========================================


//====InfluencerFragment======================================================================================
//카테고리
@Serializable
data class categoryList (
    var category : List<category>? = null
)

//인플루언서
@Serializable
data class influencerList (
    var is_next_page : Boolean,
    var last_page_num : Int,
    var influencer_list : List<influencer_list>? = null
)


//====Influencer Detail Fragment======================================================================================
//인플루언서 콘텐츠 리스트
@Serializable
data class influencerContentsList (
    var is_next_page : Boolean,
    var last_page_num : Int,
    var total_posts : Int,
    var posts_list: List<posts_list>? = null
)

//인플루언서 관련검색 리스트
@Serializable
data class influencerSearchPostList(
    var is_next_page : Boolean,
    var last_page_num : Int,
    var total_posts : Int,
    var posts_list: List<posts_list>? = null
)


//====Product Detail Fragment======================================================================================
//상품을 언급한 게시물 리스트
@Serializable
data class mentionPostsList (
    var total_posts : Int,
    var is_next_page : Boolean,
    var last_page_num : Int,
    var posts_list: List<posts_list>? = null
)

//hot 언급 상품
@Serializable
data class hotContentsList (
    var contentsList : List<hotContentList>? = null
)*/
