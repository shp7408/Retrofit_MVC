package com.example.inflepick_2021_03_03.View

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.inflepick_2021_03_03.Adapter.*
import com.example.inflepick_2021_03_03.Model.*
import com.example.inflepick_2021_03_03.R
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val TAG = "홈프래그먼트"



private var Product_List = mutableListOf<ProductList>() //홈프래그먼트의 HOT 아이템
private var adDTOs = mutableListOf<adDTO>() //광고 or 이벤트


class FragmentHome  : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        var transaction : FragmentTransaction = getSupportFragmentManager().beginTransaction()
        Log.e(TAG, "=== onCreate() ===")

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "=== onViewCreated() ===")

        // TODO: 2021-03-09 아이템 슬라이드 관련해서 생명주기 중  onViewCreated에 왜 넣어야 하는지 모르겠음




        /* === 광고 or 이벤트 */
        view_pager_ad.adapter = ViewPagerADAdapter(adDTOs)
        view_pager_ad.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        /* 광고 사진 아래쪽에 개수 및 현재 아이템 알려주는 부분 */
        indicator2.setViewPager(view_pager_ad)
        Log.d(TAG, "=== indicator2에 view_pager_ad set 하기 ===")



//        Thread(object : Runnable {
//            var value = 0
//            var running = false
//            override fun run() {
//                Log.d(TAG, "=== Thread 자동으로 움직이기 ===$running")
//
//
//                running = true
//                while (running) {
//                    value += 1
//                    Log.d(TAG, "=== Thread 자동으로 움직이기 value : ===$value")
//
//                    view_pager_ad.apply {
//                        beginFakeDrag()
//                        fakeDragBy(-10f)
//                        endFakeDrag()
//                    }
//
//                    try {
//                        Thread.sleep(3000)
//
//                    } catch (e: Exception) {
//                    }
//
//                }
//            }
//        }).start()


    }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e(TAG, "=== onCreateView() ===")
        val view = inflater.inflate(R.layout.fragment_home, null)

//        postToList()
//        Log.d(TAG, "=== postToList() ===")
        loadData()

        return view
    }




    /* 레트로핏으로 서버통신하는 부분 */
    private fun loadData() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.influencerpick.tk")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //dd

        val api = retrofit.create(ApiService::class.java)



        api.getHotItem("m",5).enqueue(object :Callback<HotItemModel>{
            override fun onFailure(call: Call<HotItemModel>, t: Throwable) {
                Log.e(TAG, "=== getHotItem onFailure === ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<HotItemModel>, response: Response<HotItemModel>) {
                if (response.body() != null) {

                    val result: String = response.body().toString()
                    Log.d(TAG, "=== getHotItem loadData() 성공 isSuccessful!!!!!!!!!!! === body : $result}")
                    Log.d(TAG, "=== getHotItem loadData() 성공 isSuccessful!!!!!!!!!!! === body code : ${response.code()}")


                    val product_List : List<ProductList>? = response.body()!!.productList
                    Log.d(TAG, "=== getHotItem loadData() 성공 isSuccessful!!!!!!!!!!! === product_List : $product_List")

                    Product_List = product_List as MutableList<ProductList>

                    /* === 아이템 슬라이드 참고 url https://www.youtube.com/watch?v=xlonlt5fAzg */
                    view_pager2.adapter = HotItemAdapter(Product_List)
                    Log.d(TAG, "=== view_pager2.adapter 선언===")

                    view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                    Log.d(TAG, "=== view_pager2.orientation 선언 ===")

                    indicator.setViewPager(view_pager2)
                    Log.d(TAG, "=== indicator에 view_pager2 set 하기 ===")

//
                } else {
                    Log.e(TAG, "=== getHotItem loadData() 널 코드 === : ${response.code()}")
                }
            }

        })

        //hotItemAdapter.setOnClickListener(this)


        //광고 or 이벤트에 반복문으로 데이터 넣음
        for (j in 1..3) {
            Log.d(TAG, "=== postToList() 반복문 === j : $j")
            var adDTO =
                adDTO(j, R.color.grey2)

            adDTOs.add(adDTO)
            Log.d(TAG, "=== addToList2 adDTOs ===${adDTOs}" )
        }



        api.getHotContent("m",5).enqueue(object : Callback<HotContentModel> {
            override fun onFailure(call: Call<HotContentModel>, t: Throwable) {
                Log.e(TAG, "=== getHotContent onFailure === ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<HotContentModel>, response: Response<HotContentModel>) {
                if (response.body() != null) {

                    val result: String = response.body().toString()
                    Log.d(TAG, "=== loadData() 성공 isSuccessful!!!!!!!!!!! === body : $result}")
                    Log.d(TAG, "=== loadData() 성공 isSuccessful!!!!!!!!!!! === body code : ${response.code()}")


                    val post_List : List<PostsList>? = response.body()!!.postsList
                    Log.d(TAG, "=== loadData() 성공 isSuccessful!!!!!!!!!!! === post_List : $post_List")


                    /* 리사이클러 뷰에 넣는 부분 */
                    hotContentRecyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL, false)
                        adapter = HotContentAdapter(post_List as ArrayList<PostsList>)

                        //adapter = hotContentAdapter
                    }

                    //클릭리스너 등록
//                    hotContentAdapter.setItemClickListener( object : HotContentAdapter.ItemClickListener{
//                        override fun onClick(view: View, position: Int) {
//                            Log.d(TAG, "${position}번 리스트 선택")
//                        }
//                    })
                    //hotContentAdapter.notifyDataSetChanged()

                } else {
                    Log.e(TAG, "=== loadData() 널 코드 === : ${response.code()}")
                }
            }

        })

        //hotContentAdapter.setOnClickListener(this)

        api.getHotIfluencer("m",5).enqueue(object : Callback<HotInfluencerModel> {
            override fun onFailure(call: Call<HotInfluencerModel>, t: Throwable) {
                Log.e(TAG, "=== getHotContent onFailure === ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<HotInfluencerModel>, response: Response<HotInfluencerModel>) {
                if (response.body() != null) {

                    val result: String = response.body().toString()
                    Log.d(TAG, "=== loadData() 성공 isSuccessful!!!!!!!!!!! === body : $result}")
                    Log.d(TAG, "=== loadData() 성공 isSuccessful!!!!!!!!!!! === body code : ${response.code()}")


                    val influencer_List : List<InfluencerList>? = response.body()!!.influencerList
                    Log.d(TAG, "=== loadData() 성공 isSuccessful!!!!!!!!!!! === influencer_List : $influencer_List")


                    /* 리사이클러 뷰에 넣는 부분 */
                    hotInfluencerRecyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL, false)
                        adapter = HotInfluencerAdapter(influencer_List as ArrayList<InfluencerList>)

                    }



                } else {
                    Log.e(TAG, "=== loadData() 널 코드 === : ${response.code()}")
                }
            }

        })



        api.getTag(20).enqueue(object : Callback<TagModel> {
            override fun onFailure(call: Call<TagModel>, t: Throwable) {
                Log.e(TAG, "=== getTag onFailure === ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<TagModel>, response: Response<TagModel>) {
                if (response.body() != null) {

                    val result: String = response.body().toString()
                    Log.d(TAG, "=== getTag === body : $result}")
                    Log.d(TAG, "=== getTag === body code : ${response.code()}")


                    val tag_List : List<String>? = response.body()!!.hotKeyword
                    Log.d(TAG, "=== getTag === tag_List : $tag_List")
                    Log.d(TAG, "=== getTag === tag_List.size : ${tag_List!!.size}")


                    /* 리사이클러 뷰에 넣는 부분 */
                    commandTagRecyclerView.apply {
                        setHasFixedSize(true)

                        //그리드 뷰로 바꿔야 함함
                       layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL, false)
                        adapter = TagAdapter(tag_List as ArrayList<String>)

                    }



                } else {
                    Log.e(TAG, "=== getTag === : ${response.code()}")
                }
            }

        })



    }



}