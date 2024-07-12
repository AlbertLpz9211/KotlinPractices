package com.example.applicacionestudio.todo

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.applicacionestudio.R

class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val  tvTodoCategoryName: TextView = view.findViewById(R.id.tvTodoCategoryName)
    private val  divider: View = view.findViewById(R.id.divider)

    fun render(taskCategory: TaskCategory){
        tvTodoCategoryName.text= "EJEMPLO"

        when(taskCategory){
            TaskCategory.Bussiness -> {
                tvTodoCategoryName.text="Negocios"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_business_category))
            }
            TaskCategory.Other -> {
                tvTodoCategoryName.text="Otros"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.todo_other_category))
            }
            TaskCategory.Personal -> {
                tvTodoCategoryName.text="Personal"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.todo_personal_category))
            }
        }
    }
}