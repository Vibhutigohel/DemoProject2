package com.example.demoproject

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModelHome : ViewModel() {

    var search: String? = null

    var authListenerHome: AuthListenerHome? = null
    var token: String = ""

    fun onSearchButtonClick(view: View) {
        // when button click first we will call interface method on started here
        authListenerHome?.onStarted()

        // check data validation
        if (search.isNullOrEmpty()) {
//if serach is empty
            authListenerHome?.onFailure("Please enter something to search.")

            // here return mean after execute the code it will be stop future execution
            return
        } else {
            // if Success call authlistener method
            //authListener?.onSuccess()
            // !! this operator will sure it is not null

            val searchResponse = UserRepository().searchBusinessListByFilter(
                token, "22.7443088", "75.9058399", 1
            )
            authListenerHome?.onSuccess(searchResponse)

        }
    }


}