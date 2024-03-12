package com.example.uhrzeitklasse

class Time {
    private var totalSeconds: Int = 0

    // Default-Konstruktor
    constructor() {
        setTime(0, 0, 0)
    }

    // Konstruktor mit Stunden, Minuten und Sekunden
    constructor(hours: Int, minutes: Int, seconds: Int) {
        setTime(hours, minutes, seconds)
    }

    // Methoden zum Setzen der Zeit
    fun setTime(hours: Int, minutes: Int, seconds: Int) {
        totalSeconds = hours * 3600 + minutes * 60 + seconds
    }

    // Methoden zum Lesen der Zeit
    fun getHours(): Int {
        return totalSeconds / 3600
    }

    fun getMinutes(): Int {
        return (totalSeconds % 3600) / 60
    }

    fun getSeconds(): Int {
        return totalSeconds % 60
    }

    // Methoden zum Rechnen mit Uhrzeiten
    fun add(seconds: Int) {
        totalSeconds += seconds
    }

    fun subtract(other: Time): Time {
        val resultSeconds = this.totalSeconds - other.totalSeconds
        val resultTime = Time()
        resultTime.totalSeconds = resultSeconds
        return resultTime
    }

    // Methode zur Darstellung der Zeit als String
    override fun toString(): String {
        val hours = String.format("%02d", getHours())
        val minutes = String.format("%02d", getMinutes())
        val seconds = String.format("%02d", getSeconds())
        return "$hours:$minutes:$seconds"
    }
}

fun main() {
    val t1 = Time()
    val t2 = Time(3, 20, 45)
    val t3 = Time(1, 20, 45)
    val subtract = t2.subtract(t3)
    println(subtract.toString()) // Ausgabe -> 02:00:00
}
