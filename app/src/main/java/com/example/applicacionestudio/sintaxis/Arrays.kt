package com.example.applicacionestudio.sintaxis

fun main() {
    var name:String = "ALberto"

    val weekDays= arrayOf("Lunes", "Martes", "Miercoles", "Jeves", "Viernes", "Sabado", "Domingo")
    weekDays[0]="holiwis"
     //println(weekDays[0])
    //println(weekDays.size >= 8)

    //bucles para arays

    for(position in weekDays.indices){
        println(weekDays[position])
    }

    for((position, value) in weekDays.withIndex()){
        println("La posicion $position contiene: $value")
    }

    for(weekDay in weekDays){
        println("ahora es $weekDay")
    }
}