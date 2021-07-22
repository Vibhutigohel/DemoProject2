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
import com.example.demoproject.*
import com.example.demoproject.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity(), AuthListener {

    var sharedPreference: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        // Now we have to call viewmodel here with viewmodel class name in get method
        var viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        // Now we set this view model to our binding viewmodel
        binding.viewmodel = viewModel
        // set authlister to our view model
        viewModel.authListener = this
        sharedPreference = getSharedPreferences("DEMOPROJECT", Context.MODE_PRIVATE)

        if (sharedPreference!!.getBoolean("isLoggedIn", false)) {
            finish()
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStarted() {

        progressBar.show()
    }

    override fun onSuccess(loginResponseFromUserRepository: LiveData<String>) {
        progressBar.hide()
        loginResponseFromUserRepository.observe(this@MainActivity, Observer {
            try {
                val jsonObject = JSONObject(it)
                val json = jsonObject.get("response")

                val token = (json as JSONObject).getString("token")

                var editor = sharedPreference!!.edit()
                editor.putString("Token", token)
                editor.putBoolean("isLoggedIn", true)
                editor.commit()

                intent = Intent(this, HomeActivity::class.java)
                finish()
                startActivity(intent)

            } catch (err: JSONException) {
                Log.d("Error", err.toString())
            }
        })
    }

    override fun onFailure(message: String) {
        progressBar.hide()
        toast(message)
    }

}