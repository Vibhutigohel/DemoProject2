package com.example.demoproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.demoproject.databinding.ActivityHomeBinding
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject

class HomeActivity : AppCompatActivity(), AuthListenerHome {

    var sharedPreference: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreference = getSharedPreferences("DEMOPROJECT", Context.MODE_PRIVATE)

        val binding: ActivityHomeBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_home)
        // Now we have to call viewmodel here with viewmodel class name in get method
        val viewModel = ViewModelProviders.of(this).get(AuthViewModelHome::class.java)
        // Now we set this view model to our binding viewmodel
        binding.viewmodel = viewModel
        // set authlister to our view model
        viewModel.authListenerHome = this
        viewModel.token = sharedPreference!!.getString("Token", "")!!
    }

    override fun onStarted() {

    }

    override fun onSuccess(searchResponse: LiveData<String>) {
        toast("Api call success")
        searchResponse.observe(this@HomeActivity, Observer {
            try {
                val jsonObject = JSONObject(it)
                val json = jsonObject.get("response")

                val status = (json as JSONObject).getString("status")

                if (status != "200") {
                    finish()
                    intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    val obj: SearchModel = Gson().fromJson(it, SearchModel::class.java)


                }
            } catch (err: JSONException) {
                Log.d("Error", err.toString())
            }
        })

    }

    override fun onFailure(message: String) {
        toast(message)
    }
}