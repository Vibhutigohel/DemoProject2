package com.example.demoproject

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyApi {

    @FormUrlEncoded
    @PUT("Login")
    fun userLogin(
        // @Field value in "" should be same as api object name
        @Field("mobileNumber") mobileNumber: String,
        @Field("password") password: String,
        @Field("deviceId") deviceId: String,
        @Field("deviceType") deviceType: String,
        @Field("countryCode") countryCode: String
    ): Call<ResponseBody>

    @FormUrlEncoded
    @PUT("searchBusinessListByFilter")
    fun searchBusinessListByFilter(
        // @Field value in "" should be same as api object name
        @Header("Authorization") Authorization: String,
        @Field("token") token: String,
        @Field("searchBy") searchBy: String,
        @Field("searchKey") searchKey: String,
        @Field("latitude") latitude: String,
        @Field("longitude") longitude: String,
        @Field("pageNo") pageNo: Int,
        @Field("status") status: String,
        @Field("necessities") necessities: String,
        @Field("moods") moods: String,
        @Field("luxury") luxury: String,
        @Field("types") types: String,
        @Field("liqourTypeId") liqourTypeId: String,
        @Field("paymentMethod") paymentMethod: String
    ): Call<ResponseBody>


    // this below fuctions used for retrofit calling functions
    companion object {
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .baseUrl("http://maikhanegateway-env.eba-scsjqaqe.ap-south-1.elasticbeanstalk.com/consumer/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }

}