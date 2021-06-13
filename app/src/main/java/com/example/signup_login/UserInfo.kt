package com.example.signup_login

import java.io.Serializable

class UserInfo : Serializable {
    private lateinit var Username: String
    private lateinit var Password: String
    fun getName(): String {
        return Username
    }
    @JvmName("setName1")
    fun setName(name: String?) {
        this.Username = name!!
    }
    fun getPassword(): String {
        return Password
    }
    @JvmName("setPhone1")
    fun setPassword(Password: String?) {
        this.Password = Password!!
    }
}