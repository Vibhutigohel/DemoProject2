package com.example.demoproject

import androidx.lifecycle.LiveData

interface AuthListenerHome {

    //this methis is use when api call start
    fun onStarted()
    // this method is use for when api call Success
    fun onSuccess(searchResponse: LiveData<String>)
    // this method is use for when api call fails
    fun onFailure(message:String)
}