package com.example.signup_login

import android.content.Intent
import android.media.MediaRouter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    lateinit var password : EditText
    lateinit var userNAme : EditText
    lateinit var btnSignUp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        password = findViewById(R.id.edtpassword)
        userNAme = findViewById(R.id.edtUser)
        btnSignUp = findViewById(R.id.btnSignUp)

        title = "SIGNUP ACTIVITY"

        btnSignUp.setOnClickListener {
            val pass = password.text.toString()

            when {
                pass.isEmpty() -> Toast.makeText(this@MainActivity,"Password Can't be Empty",Toast.LENGTH_LONG).show()

                validate(pass) -> {
                    sendUserData(userNAme.text.toString(),password.text.toString())
                }
                else -> {
                    Toast.makeText(this@MainActivity,"Invalid Password",Toast.LENGTH_LONG).show()
                }
            }
        }

    }
    private fun validate(pass : String): Boolean {

        val matcher: Matcher

        val passwordREGEX = Pattern.compile("^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$");

        matcher = passwordREGEX.matcher(pass)

        return matcher.matches()

    }

    private fun sendUserData(UserName : String, Passwod : String){
        val userInfo = UserInfo()

        userInfo.setName(UserName)
        userInfo.setPassword(Passwod)

        val intent = Intent(this@MainActivity,SignIn::class.java)
        val b=Bundle()
        b.putSerializable("serializable",userInfo)
        intent.putExtras(b)
        startActivity(intent)

    }
}