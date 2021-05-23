package com.example.todokotlin.presentation.views

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.todokotlin.R
import com.example.todokotlin.data.model.ApiResponse
import com.example.todokotlin.data.network.ApiService
import com.example.todokotlin.data.network.ServiceBuilder
import com.example.todokotlin.domain.EmailUtils
import com.example.todokotlin.domain.GlobalConstants
import com.example.todokotlin.domain.PasswordUtils
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        main_button_sign_in.setOnClickListener {
            (activity as MainActivity).navigateMainToSignin()
        }

        main_button_login.setOnClickListener {
            val mail: String = main_email.text.toString()
            val password: String = main_password.text.toString()
            if (EmailUtils.isEmailValid(mail) && PasswordUtils.isPasswordValid(password)) {
                callLoginApi(mail, password)
                (activity as MainActivity).navigateMainToTodoList()
            } else {
                Toast.makeText(activity, "Les informations de connexion sont incorrectes", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun callLoginApi(mail: String, password: String) {
        val request = ServiceBuilder.buildService(ApiService::class.java)
        val call = request.login(mail, password)

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(
                    call: Call<ApiResponse>,
                    response: Response<ApiResponse>
            ) {
                if (response.isSuccessful) {
                    val sharedPref = activity?.getSharedPreferences(GlobalConstants.SHARED_PREF_KEY, Context.MODE_PRIVATE)
                    sharedPref?.edit()?.putString(GlobalConstants.KEY_FIRSTNAME, response.body()?.prenom)?.apply()
                    sharedPref?.edit()?.putString(GlobalConstants.KEY_LASTNAME, response.body()?.nom)?.apply()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(activity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}