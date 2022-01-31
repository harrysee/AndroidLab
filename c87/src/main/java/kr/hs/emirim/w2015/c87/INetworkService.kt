package kr.hs.emirim.w2015.c87

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface INetworkService {
    // page : String 이 매개변수만 선언하면 네트워크시에 전혀 이용하지않음
    // 1. 이걸 서버에 넘기라는 어노테이션을 줘야함 - 쿼리
    // 2. 이 함수를 호출했을때 서버와 네트웤하라는 어노테이션 -GET,POST & url
    @GET("api/users")
    fun doGetUserList(@Query("page") page : String) : Call<UserListModel>
}