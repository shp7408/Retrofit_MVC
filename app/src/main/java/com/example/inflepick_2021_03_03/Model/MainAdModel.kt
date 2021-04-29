package com.example.inflepick_2021_03_03.Model

// 메인화면에서 광고 부분. 아직 데이터 없음
data class mainAdModel (
    var total_add: Int, //받아오려는 아이템 전체 개수

    var adDTOs : ArrayList<adDTO> //아이템을 리스트로 받아옴
    )

data class adDTO(
    var Id: Int,

    var image: Int
)

