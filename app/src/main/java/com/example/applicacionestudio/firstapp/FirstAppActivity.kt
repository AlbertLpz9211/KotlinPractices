package com.example.applicacionestudio.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applicacionestudio.R


class FirstAppActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_app)
            val btnStart= findViewById<AppCompatButton>(R.id.btnAction)
            val edtext = findViewById<AppCompatEditText>(R.id.etNombre)

         btnStart.setOnClickListener{
             val name = edtext.text.toString()
             if(name.isNotEmpty()){
                 Log.i("btnSStart", "Lo que contiene $name")
                 val intent = Intent(this, ResultActivity::class.java)
                 intent.putExtra("EXTRA_NAME", name)
                 startActivity(intent)
             }

         }
        }
    }
