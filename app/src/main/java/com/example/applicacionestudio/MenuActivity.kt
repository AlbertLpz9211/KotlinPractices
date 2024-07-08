package com.example.applicacionestudio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.applicacionestudio.firstapp.FirstAppActivity
import com.example.applicacionestudio.imccalculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnSaludapp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMC = findViewById<Button>(R.id.btnIMC)
        btnSaludapp.setOnClickListener {
            navigateToSaludapp()
        }
        btnIMC.setOnClickListener{
            navigateToImcAPP()
        }
    }

    private fun navigateToImcAPP() {
        val intent = Intent (this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludapp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

}