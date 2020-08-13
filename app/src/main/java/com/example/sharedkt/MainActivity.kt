package com.example.sharedkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // 앱이 처음 실행될 떄 한번 수행하는 곳 (초기화)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ToDO: 저장된 데이터를 로드
        loadData() //edit text 저장되어있던 값을 setText
    }

    private fun loadData() {
        val pref = getSharedPreferences("pref", 0)
        et_hello.setText(pref.getString("name", "")) // 1번째 인자에서는 저장할 당시의 키 값을 적어줌, 2번째에는 키 값에 데이터가 존재하지 않을 경우 대체 값을 적어줍니다.
    }

    private fun saveData() {
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit() // 수정모드
        edit.putString("name", et_hello.text.toString()) // 1번째 인자에는 키 값을, 2번쨰 인자에는 실제 담아줄 값
        edit.apply() // 값을 저장 완료
    }

    override fun onDestroy() { // 앱이 종료되는 시점이 다가올 떄 호출
        super.onDestroy()

        saveData() // edit text 값을 저장
    }

}