package com.example.inflepick_2021_03_03.View

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.inflepick_2021_03_03.R

/*
* 앱 클릭 시, 바로 보이는 화면
*
* 해당 화면에서 일어나는 일
* 1. 쉐어드에 자동 로그인 정보 있는지 체크
* -- 있으면, 해당 데이터 서버에 보내서, 맞는지 체크
*           -- 맞으면, 메인으로 이동
*           -- 틀리면, 다이얼로그 "회원 정보가 변경되었습니다. 다시 로그인해주세요."
*                       소셜 로그인 화면으로 이동
* -- 없으면, 소셜로그인화면으로 이동
*
* */

private const val TAG = "스플래쉬"
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d(TAG, "=== onCreate ===")

        val DURATION:Long = 1000

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }, DURATION)

    }
}