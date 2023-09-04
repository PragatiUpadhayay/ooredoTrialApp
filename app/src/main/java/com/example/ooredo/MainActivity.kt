package com.example.ooredo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

        private lateinit var logBtn : Button
        private lateinit var userName : TextInputEditText
        private lateinit var password : TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get ID
        userName=findViewById(R.id.tfUser)
        password=findViewById(R.id.tfPass)
        logBtn=findViewById(R.id.but)

        userName.addTextChangedListener(loginTextWatcher)
        userName.addTextChangedListener(loginTextWatcher)

        logBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity,ScondAc::class.java))

        }


    }
    private val loginTextWatcher = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val user_name = userName.text.toString()
            val user_pass = password.text.toString()

            logBtn.isEnabled = user_name.isNotEmpty() && user_pass.isNotEmpty()

        }

        override fun afterTextChanged(s: Editable?) {


        }

    }

}