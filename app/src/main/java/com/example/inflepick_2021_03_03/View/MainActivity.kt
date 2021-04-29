package com.example.inflepick_2021_03_03.View

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.inflepick_2021_03_03.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.luseen.spacenavigation.SpaceNavigationView
import kotlinx.android.synthetic.main.activity_main.*


private const val TAG = "메인 화면"

private lateinit var spaceNavigationView: SpaceNavigationView
private var currentNavController: LiveData<NavController>? = null

/* 바텀 네비 깃헙
* https://github.com/armcha/Space-Navigation-View
* */

class MainActivity : AppCompatActivity() {

//    lateinit var fragmentHome: FragmentHome
//    lateinit var fragmentSearch: FragmentSearch
//    lateinit var fragmentMyProfile: FragmentMyProfile

//    lateinit var menu_bottom_navi : BottomNavigationView

    private val fragmentHome by lazy { FragmentHome() }
    private val fragmentSearch by lazy { FragmentSearch() }
    private val fragmentMyProfile by lazy { FragmentMyProfile() }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(TAG, "=== onCreate ===")

        initNavigationBar()


/*
        //FragmentManager 를 사용해서 가장 먼저 띄울 프래그먼트 지정하기
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame, FragmentHome()) //인자1 : 프레임레이아웃 id / 인자2 : 프래그먼트홈
            .commit()



        val spaceNavigationView =
            findViewById<View>(R.id.menu_bottom_navi) as SpaceNavigationView
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState)
        spaceNavigationView.addSpaceItem(SpaceItem("검색", R.drawable.ic_baseline_search_24))
        spaceNavigationView.addSpaceItem(SpaceItem("마이페이지", R.drawable.ic_baseline_person_24))


//        // 첨 화면 등장할때 네비 버튼 제어
        spaceNavigationView.setCentreButtonSelectable(true)
        spaceNavigationView.setCentreButtonSelected()

        spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this, R.color.white_color))
        //spaceNavigationView.setCentreButtonRippleColor(ContextCompat.getColor(this, R.color.white_color));
//        spaceNavigationView.showIconOnly();



        spaceNavigationView.setSpaceOnClickListener(object : SpaceOnClickListener {
            override fun onCentreButtonClick() {
                Log.d(TAG, "=== 바텀네비 - 홈버튼 클릭 ===")

                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frame, FragmentHome())
                    .commit()
                //spaceNavigationView.setCentreButtonRippleColor(ContextCompat.getColor(this@MainActivity, R.color.main_color))


            }

            override fun onItemClick(itemIndex: Int, itemName: String) {
                Log.d(TAG, "=== 바텀네비 - onItemClick 정보 === $itemIndex $itemName")

                spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this@MainActivity,R.color.white_color))
                Log.d(TAG, "=== 바텀네비 - 가운데 버튼 흰색으로! === ")


                if(itemIndex == 0){
                    Log.d(TAG, "=== 바텀네비 - 검색 버튼 클릭 === $itemIndex $itemName")

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, FragmentSearch())
                        .commit()

                    spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this@MainActivity, R.color.white_color))



                }else{
                    Log.d(TAG, "=== 바텀네비 - 마이페이지 버튼 클릭 === $itemIndex $itemName")

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, FragmentMyProfile())
                        .commit()

                    spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this@MainActivity, R.color.white_color))


                }

            }

            */
/* 라이브러리에서 기본으로 제공하는 메서드임. 왜 있는지는 모르겠지만. 일단 위에 아이템 셀렉트랑 동일하게 진행해야 함 *//*

            override fun onItemReselected(itemIndex: Int, itemName: String) {
                Log.d(TAG, "=== 바텀네비 - 마이페이지버튼 클릭 === $itemIndex $itemName")

                if(itemIndex == 0){
                    Log.d(TAG, "=== 바텀네비 - 검색 버튼 재 클릭 === $itemIndex $itemName")
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, FragmentSearch())
                        .commit()

                    spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this@MainActivity, R.color.white_color))


                }else{
                    Log.d(TAG, "=== 바텀네비 - 마이페이지 버튼 재 클릭 === $itemIndex $itemName")
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame, FragmentMyProfile())
                        .commit()

                    spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this@MainActivity, R.color.white_color))


                }


            }
        })

*/



    }

    private fun initNavigationBar() {
        menu_bottom_navi.run {
            setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.navigation_home -> {
                        changeFragment(fragmentHome)
                    }
                    R.id.navigation_search -> {
                        changeFragment(fragmentSearch)
                    } R.id.navigation_profile -> {
                    changeFragment(fragmentMyProfile)
                }
                }
                true
            }
            selectedItemId = R.id.navigation_home }
    }
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager .beginTransaction() .replace(R.id.fl_container, fragment) .commit()
    }


}