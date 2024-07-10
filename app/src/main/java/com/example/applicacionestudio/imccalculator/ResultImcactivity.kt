package com.example.applicacionestudio.imccalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applicacionestudio.R
import com.example.applicacionestudio.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultImcactivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvImc: TextView
    private lateinit var tvDescription: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponents()
        initUI(result)
    }

    private fun initUI(result: Double) {
        tvImc.text = result.toString()
        when (result) {
            in 0.00..18.50 -> {
                //bajo peso
                tvResult.text = getString(R.string.low_weigth)
                tvDescription.text = getString(R.string.low_weigth_description)
            }

            in 0.00..18.50 -> {
                //peso normal
                tvResult.text = getString(R.string.normal_weigth)
                tvDescription.text = getString(R.string.normal_weigth_description)
            }

            in 0.00..18.50 -> {
                //sobrepeso
                tvResult.text = getString(R.string.overweigth)
                tvDescription.text = getString(R.string.over_weigth_description)
            }

            in 0.00..18.50 -> {
                //obesidad
                tvResult.text = getString(R.string.obese)
                tvDescription.text = getString(R.string.obese_description)
            }

            else -> {
                //error
                tvResult.text = getString(R.string.error)
                tvImc.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        tvImc = findViewById(R.id.tvImc)
    }
}