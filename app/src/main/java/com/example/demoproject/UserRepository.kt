package com.example.demoproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun userLogin(
        mobileNumber: String,
        password: String,
        deviceId: String,
        deviceType: String,
        countryCode: String
    ): LiveData<String> {
        val loginResponse = MutableLiveData<String>()

        MyApi().userLogin(mobileNumber, password, deviceId, deviceType, countryCode)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                    loginResponse.value = t.message
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {

                    if (response.isSuccessful) {
                        loginResponse.value = response.body()?.string()
                    } else {
                        loginResponse.value = response.errorBody()?.string()

                    }
                }
            })

        return loginResponse
    }

    fun searchBusinessListByFilter(
        token: String,
        latitude: String,
        longitude: String,
        pageNo: Int
    ): LiveData<String> {
        val searchResponse = MutableLiveData<String>()

        val bearer = "Bearer $token"
        MyApi().searchBusinessListByFilter(
            bearer,
            token,
            "",
            "",
            latitude,
            longitude,
            pageNo,
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        ).enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                searchResponse.value = t.message
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                if (response.isSuccessful) {
                    searchResponse.value = response.body()?.string()
                } else {
                    searchResponse.value = response.errorBody()?.string()

                }
            }
        })

        return searchResponse
    }
}