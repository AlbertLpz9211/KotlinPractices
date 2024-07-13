package com.example.applicacionestudio.todo

sealed class TaskCategory(var isSelected: Boolean = true) {
    data object Personal : TaskCategory()
    data object Bussiness : TaskCategory()
    data object Other : TaskCategory()
}

