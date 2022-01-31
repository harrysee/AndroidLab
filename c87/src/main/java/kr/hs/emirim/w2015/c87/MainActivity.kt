package kr.hs.emirim.w2015.c87

import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    // retrofit 객체 준비
    val retrofit : Retrofit
        get() = Retrofit.Builder()  
            .baseUrl("https://reqres.in/") // 개발자들 사이에 유명한 테스트용으로 쓰는 오픈 api url
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val networkService = retrofit.create(INetworkService::class.java) // 인터페이스 등록
        // 객체함수 콜하기
        val call = networkService.doGetUserList("1")  // 함수 실행시켜 콜객체 반환

        call.enqueue(object : Callback<UserListModel>{
            override fun onResponse(call: Call<UserListModel>, response: Response<UserListModel>) {
                // 서버에서 정상적으로 데이터 받았을때
                val userList = response.body()
                val mutableList = mutableListOf<Map<String, String>>()
                userList?.data?.forEach{
                    val map = mapOf("firstName" to it.firstName, "lastName" to it.lastName)
                    // 데이터를 구성하기 위한 리스트를 맵리스트로 받음
                    mutableList.add(map)
                }
                val adapter = SimpleAdapter( // 뷰에 뿌릴 데이터 준비
                    this@MainActivity,
                    mutableList,
                    android.R.layout.simple_expandable_list_item_2,
                    arrayOf("firstName", "lastName"),
                    intArrayOf(android.R.id.text1, android.R.id.text2)
                )
                listView.adapter = adapter
            }

            override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                //서버 데이터 가져오기 실패 시
                call.cancel() // 간단하게 처리
            }
        })

    }
}