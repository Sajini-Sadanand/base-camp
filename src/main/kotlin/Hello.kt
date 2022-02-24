fun main(args: Array<String>) {
    println("Hello, ${args[0]}")
//    Hello, Kotlin
    fishIsSafe()
    checkTemperature()
    checkOutput()
    /*Note: Loops are exceptions to "everything has a value."
    There's no sensible value for 'for loops' or 'while loops',
    so they do not have values. If you try to assign a loop's value to something,
    the compiler gives an error.*/
}

fun fishIsSafe() {
    val temperature = 10
    val message = "The water temperature is ${if (temperature > 50) "too warm" else "OK"}."
    println(message)
//    The water temperature is OK.
}

fun checkTemperature() {
    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)
//    false
}

fun checkOutput() {
    // Will assign kotlin.Unit
    val isUnit = println("This is an expression")
//    This is an expression
    println(isUnit)
//    kotlin.Unit
}