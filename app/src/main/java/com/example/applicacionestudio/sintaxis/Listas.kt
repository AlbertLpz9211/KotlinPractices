package com.example.applicacionestudio.sintaxis

fun main() {
    mutablelist()
}

fun inmutableList(){
    val readOnly:List<String> = listOf("Lunes", "Martes", "Miercoles", "Jeves", "Viernes", "Sabado", "Domingo")
    println(readOnly.size)
    println(readOnly)
    println(readOnly[0])
    println(readOnly.last())
    val example = readOnly.filter { it.contains("a") }
    println(example)

    readOnly.forEach{ it ->
     println(it)
    }
}

fun mutablelist(){
    var mutableList:MutableList<String> = mutableListOf("Lunes", "Martes", "Miercoles", "Jeves", "Viernes", "Sabado", "Domingo")
    println(mutableList)
    mutableList.add("DayBetho")
    println(mutableList.last())



}