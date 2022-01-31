package kr.hs.emirim.w2015.c87

import com.google.gson.annotations.SerializedName

data class UserModel (
    // 키값과 변수명이 동일하지않을때 어노테이션 붙이기
    @SerializedName("first_name")   // json데이터의 키값 명시
    var firstName :String,
    @SerializedName("last_name")
    var lastName : String,

)