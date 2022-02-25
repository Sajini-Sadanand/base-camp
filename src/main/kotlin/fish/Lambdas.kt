package fish

/**
 * Here's what the code says:

Make a variable called waterFilter.
waterFilter can be any function that takes an Int and returns an Int.
Assign a lambda to waterFilter.
The lambda returns the value of the argument dirty divided by 2.
 */
fun main(args:Array<String>){
//    print(waterFilter(dirtyLevel))
    println("Passing lambda waterFilter")
    println(updateDirty(dirtyLevel, waterFilter))
    println("Passing trailing lambda.")
    var dirtyLevel = 19
    dirtyLevel = updateDirty(dirtyLevel) { dirty -> dirty
        + 23}
    println(dirtyLevel)
    println("Passing function reference of increaseDirty")
    println(updateDirty(dirtyLevel,::increaseDirty))
}

/**
 * Note: Kotlin prefers that any parameter that takes a function is the last parameter.
 * When working with higher-order functions, Kotlin has a special syntax, called the last parameter call syntax,
 * which lets you make the code even more concise. In this case, you can pass a lambda for the function parameter,
 * but you don't need to put the lambda inside the parentheses.
 *
 * According to Kotlin convention, if the last parameter of a function is a function,
 * then a lambda expression passed as the corresponding argument can be placed outside the parentheses:
 *
 * val product = items.fold(1) { acc, e -> acc * e }
 *
 * Such syntax is also known as trailing lambda.
 */
const val dirtyLevel = 20
val waterFilter:(Int)->Int = {dirty->dirty/2}

/**
 * The function you pass doesn't have to be a lambda; it can be a regular named function instead.
 * To specify the argument as a regular function, use the :: operator.
 * This way Kotlin knows that you are passing the function reference as an argument,
 * not trying to call the function.
 */
fun increaseDirty(start:Int) = start+1

/**
 * The real power of lambdas is using them to create higher-order functions,
 * where the argument to one function is another function.
 */
/**
 * The body of the code calls the function that was passed as the second argument,
 * and passes the first argument along to it.
 */
fun updateDirty(dirty:Int,operation:(Int)->Int):Int{
    return operation(dirty)
}