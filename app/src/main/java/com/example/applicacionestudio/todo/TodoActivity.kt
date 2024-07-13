package com.example.applicacionestudio.todo

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicacionestudio.R
import com.example.applicacionestudio.sintaxis.mutablelist
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {
    private val categories = listOf(
        TaskCategory.Bussiness,
        TaskCategory.Personal,
        TaskCategory.Other
    )

    private val tasks = mutableListOf(
        Task("Prueba Bussissnes", TaskCategory.Bussiness),
        Task("prueba personal", TaskCategory.Personal),

        )
    private lateinit var rvTodoCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rvTodoTask: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)
        initComponents()
        initUI()
        initListeners()

    }

    private fun initListeners() {
        fabAddTask.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currTask = etTask.text.toString()
            if (currTask.isNotEmpty()) {
                val selectedIdTack = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedIdTack)
                val currCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_business) -> TaskCategory.Bussiness
                    getString(R.string.todo_personal) -> TaskCategory.Personal
                    else -> {
                        TaskCategory.Other
                    }
                }
                tasks.add(Task(etTask.text.toString(), currCategory))
                dialog.hide()
            }
        }
        updateTask()
        dialog.show()
    }

    private fun initComponents() {
        rvTodoTask = findViewById(R.id.rvTodoTask)
        rvTodoCategories = findViewById(R.id.rvTodoCategories)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)  {position->updateCategories(position)}
        rvTodoCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTodoCategories.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks) {position -> onItemSelected(position)}
        rvTodoTask.layoutManager = LinearLayoutManager(this)
        rvTodoTask.adapter = taskAdapter
    }
    private fun onItemSelected(position: Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTask()
    }
    private fun updateCategories(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTask()
    }
    private fun updateTask() {
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTaks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.tasks = newTaks
        taskAdapter.notifyDataSetChanged()
    }
}