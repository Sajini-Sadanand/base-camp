package fish

fun main(args: Array<String>) {
    swim()   // uses default speed
    swim("slow")   // positional argument
    swim(speed = "turtle-like")   // named parameter
}

/**
 * Note: Arguments don't have to use the parameter names; you can just pass the arguments in the defined order.
 * But with default values, this can get a little confusing,
 * so it is best practice, to put parameters without defaults first, and the ones with defaults after.
 */

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

