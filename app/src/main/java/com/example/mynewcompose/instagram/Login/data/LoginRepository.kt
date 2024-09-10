package com.example.mynewcompose.instagram.Login.data

import com.example.mynewcompose.instagram.Login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginService){

    suspend fun doLogin(user:String,password:String):Boolean{
        // we can also perfom checks here
        return api.doLogin(user, password)
    }

}