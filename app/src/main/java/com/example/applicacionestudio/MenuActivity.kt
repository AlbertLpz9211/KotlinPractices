package com.example.applicacionestudio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.applicacionestudio.appjsonconsumer.SuperHeroListActivity
import com.example.applicacionestudio.firstapp.FirstAppActivity
import com.example.applicacionestudio.imccalculator.ImcCalculatorActivity
import com.example.applicacionestudio.todo.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnSaludapp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMC = findViewById<Button>(R.id.btnIMC)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        val btnSuperHero = findViewById<Button>(R.id.btnSuperHero)
        btnSaludapp.setOnClickListener {
            navigateToSaludapp()
        }
        btnIMC.setOnClickListener{
            navigateToImcAPP()
        }
        btnTODO.setOnClickListener {
            navigateToTdoApp()
        }
        btnSuperHero.setOnClickListener {
            navigateToSuperHero()
        }
    }

    private fun navigateToSuperHero() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTdoApp() {
        val intent = Intent(this, TodoActivity::class.java )
        startActivity(intent)
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