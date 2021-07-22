package com.example.demoproject

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    // define variable initial value is null that why ? use as null safety operator
    var email: String? = null
    var password: String? = null
    var countrycode: String? = null

    // call auth listener interface for use as callback to activity
    var authListener: AuthListener? = null

    // function for if user click on login button
    fun onSignupClick(view: View) {

        val context  = view.context

        val intent = Intent(context,SignUpActivity::class.java)
        context.startActivity(intent)

    }

    fun onLoginButtonClick(view: View) {
        // when button click first we will call interface method on started here
        authListener?.onStarted()

        // check data validation
        if (email.isNullOrEmpty() || password.isNullOrEmpty() /*|| countrycode.isNullOrEmpty()*/) {
            // is user use wrong username of password/ set field in empty then call onFilure method from aithlostener
            authListener?.onFailure("Invalid Username or Password or contry code")
            // here return mean after execute the code it will be stop future execution
            return
        } else {
            // if Success call authlistener method
            //authListener?.onSuccess()
            // !! this operator will sure it is not null
            val loginResponseFromUserRepository = UserRepository().userLogin(
                email!!, password!!, "hdj0", "android",
                "91"
            )
            // here i pass roginResponseFromUserRepository here but i will have to add perameter oninterface so just press alt+enter to add it quickly
            authListener?.onSuccess(loginResponseFromUserRepository)

        }
    }
}