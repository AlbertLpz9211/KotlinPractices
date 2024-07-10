package com.example.applicacionestudio.imccalculator

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.applicacionestudio.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class ImcCalculatorActivity : AppCompatActivity() {
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeigth: Int = 60
    private var currAge: Int = 24
    private var currHeight: Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeigth: TextView
    private lateinit var rsHeigth: RangeSlider
    private lateinit var btnAddWeigth: FloatingActionButton
    private lateinit var btnSubstracWeigth: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var btnSubstracAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private  lateinit var tvWeight: TextView
    private lateinit var btnCalculate: Button

    companion object{
        const val IMC_KEY= "IMC_RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        setGenderColor()
        initUI()


    }


    private fun initComponents() {
        viewFemale = findViewById(R.id.viewFemale)
        viewMale = findViewById(R.id.viewMale)
        tvHeigth = findViewById(R.id.tvHeigth)
        rsHeigth = findViewById(R.id.rsHeigth)
        btnAddWeigth = findViewById(R.id.btnAddWeigth)
        btnSubstracWeigth = findViewById(R.id.btnSubstracWeigth)
        btnAddAge = findViewById(R.id.btnAddAge)
        btnSubstracAge = findViewById(R.id.btnSubstracAge)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeigth.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currHeight = df.format(value).toInt()
            tvHeigth.text = "$currHeight cm"
        }
        btnAddWeigth.setOnClickListener {
            currentWeigth += 1
            setWeigth()
        }
        btnSubstracWeigth.setOnClickListener {
            currentWeigth -= 1
            setWeigth()
        }
        btnAddAge.setOnClickListener {
            currAge += 1
            setAge()
        }
        btnSubstracAge.setOnClickListener {
            currAge -=1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result= calculateImc()
            navigateToResult(result)
        }

    }

    private fun navigateToResult(result: Double) {

        val intent = Intent(this, ResultImcactivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }


    private fun calculateImc(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeigth/(currHeight.toDouble()/100 * currHeight.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun setAge(){
        tvAge.text = currAge.toString()
    }


    private fun setWeigth(){
        tvWeight.text = currentWeigth.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }


    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setWeigth()
        setAge()
        setHeigth()
    }

    private fun setHeigth() {
        tvHeigth.text = currHeight.toString()
    }

}