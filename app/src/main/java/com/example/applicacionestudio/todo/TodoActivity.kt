package com.example.applicacionestudio.todo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicacionestudio.R

class TodoActivity : AppCompatActivity() {
    private val  categories = listOf(
        TaskCategory.Bussiness,
        TaskCategory.Personal,
        TaskCategory.Other
    )
    private lateinit var rvTodoCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rvTodoTask: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)
        initComponents()
        initUI()

    }

    private fun initComponents() {
        rvTodoTask = findViewById(R.id.rvTodoTask)
        rvTodoCategories = findViewById(R.id.rvTodoCategories)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvTodoCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTodoCategories.adapter = categoriesAdapter
    }
}