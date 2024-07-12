package com.example.applicacionestudio.todo

sealed class TaskCategory {
    object Personal : TaskCategory()
    object Bussiness : TaskCategory()
    object Other : TaskCategory()
}

