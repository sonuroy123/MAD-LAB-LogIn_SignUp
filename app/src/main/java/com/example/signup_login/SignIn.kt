package com.example.signup_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIn : AppCompatActivity() {

    lateinit var userName : EditText
    lateinit var Passsword : EditText
    lateinit var btnSignIn : Button
    lateinit var userInfo : UserInfo
    var count=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        userName = findViewById(R.id.edtUserS)
        Passsword = findViewById(R.id.edtpasswordS)
        btnSignIn = findViewById(R.id.btnSignIn)

        title = "SIGNIN ACTIVITY"

        userInfo = intent.getSerializableExtra("serializable") as UserInfo

        val user : String = userInfo.getName().toString()
        val pass : String = userInfo.getPassword().toString()


        btnSignIn.setOnClickListener {
            if(userName.text.toString()==user && pass==Passsword.text.toString()) {
                val intent = Intent(this@SignIn,LogIn::class.java)
                startActivity(intent)
                Toast.makeText(this@SignIn,"Successful Login",Toast.LENGTH_LONG).show()
            } else {
                count++
                if(count>2){
                    btnSignIn.isEnabled=false
                    Toast.makeText(this@SignIn,"Failed Login Attempts",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this@SignIn,"Login Failed",Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}