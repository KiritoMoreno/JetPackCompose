package com.example.mynewcompose.instagram.Login.domain

import com.example.mynewcompose.instagram.Login.data.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user:String, password:String):Boolean{
        return repository.doLogin(user, password)
    }
}