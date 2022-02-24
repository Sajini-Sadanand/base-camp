package fish

import java.util.*

private val MONDAY = "Monday"
private val TUESDAY = "Tuesday"
private val WEDNESDAY = "Wednesday"
private val THURSDAY = "Thursday"
private val FRIDAY = "Friday"
private val SATURDAY = "Saturday"
private val SUNDAY = "Sunday"

fun main(args:Array<String>){
    feedTheFish()
    main()
}

fun main(){
    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    // eager, creates a new list
    val eager = decorations.filter { it[0] == 'p' }
    println("eager:$eager")
    /**
     * When you return the filter results as a Sequence, the filtered variable won't hold a new list—it'll hold a
     * Sequence of the list elements and knowledge of the filter to apply to those elements.
     * Whenever you access elements of the Sequence, the filter is applied, and the result is returned to you.
     */
    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered:$filtered")
    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")

    val lazyMap2 = decorations.asSequence().filter {
        it[0] == 'p'
    }.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")

    val lazyMap = decorations.asSequence().map {
        println("access:$it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")
}

fun feedTheFish(){
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eats $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty >30
fun isSunday(day: String) = day == SUNDAY

/**
 * Note: A function used as a default value is evaluated at runtime,
 * so do not put an expensive operation like a file read or a large memory allocation in the function.
 * The operation is executed every time your function is called, which may slow down your program.
 */
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun fishFood (day : String) : String {
    return when (day) {
        MONDAY -> "flakes"
        TUESDAY -> "pellets"
        WEDNESDAY -> "redworms"
        THURSDAY -> "granules"
        FRIDAY -> "mosquitoes"
        SUNDAY -> "plankton"
        else -> "nothing"
    }
}

fun randomDay():String{
    val week = arrayOf(
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY,
        FRIDAY, SATURDAY, SUNDAY
    )
    return week[Random().nextInt(week.size)]
}