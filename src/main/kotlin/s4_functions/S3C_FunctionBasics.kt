package s4_functions

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 4A: Function Basics, Lambdas & Higher-Order
    📆 Package: kotlin.s4_functions
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - Defining and calling functions
    - Return types and `Unit`
    - Function overloading
    - Single-expression functions
    - Default & named arguments
    - Lambda expressions
    - Higher-order functions
    - Anonymous & inline functions
    - Best practices
    - All types of functions with examples

    ---------------------------------------------------------------------------
    🫠 Types of Functions in Kotlin
    ----------------------------------------------------------------------------
    1. Named Function (Regular)
        fun greet(name: String): String {
            return "Hello, $name!"
        }

    2. Single-Expression Function
        fun square(x: Int) = x * x

    3. Unit Function (No Return)
        fun log(message: String) {
            println("LOG: $message")
        }

    4. Function with Default Parameters
        fun greetUser(name: String = "Guest") {
            println("Welcome, $name!")
        }

    5. Named Arguments
        fun calculatePrice(base: Int, tax: Int, discount: Int) {
            println("Final: ${base + tax - discount}")
        }
        // Usage: calculatePrice(discount = 5, base = 100, tax = 20)

    6. Overloaded Function
        fun show(msg: String) = println("Text: $msg")
        fun show(id: Int) = println("ID: $id")

    7. Lambda Expression
        val greet = { name: String -> "Hi, $name!" }
        println(greet("Tashy"))

    8. Higher-Order Function
        fun operate(a: Int, b: Int, op: (Int, Int) -> Int): Int {
            return op(a, b)
        }
        val result = operate(3, 4) { x, y -> x + y }
        println("Sum: $result")

    9. Inline Function
        inline fun runTimed(block: () -> Unit) {
            val start = System.currentTimeMillis()
            block()
            val end = System.currentTimeMillis()
            println("Took ${end - start}ms")
        }
        runTimed {
            println("Running some task...")
        }

    10. Anonymous Function
        val isEven = fun(num: Int): Boolean {
            return num % 2 == 0
        }
        println("Is 4 even? ${isEven(4)}")

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Prefer single-expression syntax for short functions
    - Name lambdas meaningfully in higher-order calls
    - Use function types clearly: `(Type) -> ReturnType`
    - Avoid unnecessary overloads if default arguments can be used
    - Use inline wisely to optimize higher-order function performance
    ---------------------------------------------------------------------------
*/

fun main() {
    println("→ Named Function:")
    println(greet("Tashy"))

    println("\n→ Unit Function:")
    log("App started")

    println("\n→ Default Parameters:")
    greetUser()
    greetUser("DevTashy")

    println("\n→ Named Arguments:")
    calculatePrice(discount = 5, base = 100, tax = 20)

    println("\n→ Overloaded Functions:")
    show("Welcome")
    show(101)

    println("\n→ Single-Expression Function:")
    println("4² = ${square(4)}")

    println("\n→ Lambda Expression:")
    val greetLambda = { name: String -> "Hi, $name!" }
    println(greetLambda("Tashy"))

    println("\n→ Higher-Order Function:")
    val result1 = operate(6, 3) { a, b -> a + b }
    val result2 = operate(6, 3, multiply)
    println("Sum: $result1, Product: $result2")

    println("\n→ Anonymous Function:")
    val isEven = fun(x: Int): Boolean = x % 2 == 0
    println("Is 10 even? ${isEven(10)}")

    println("\n→ Inline Function:")
    runTimed {
        println("Simulating load...")
        Thread.sleep(300)
    }
}

// Named
fun greet(name: String): String = "Hello, $name!"

// Unit
fun log(msg: String) {
    println("LOG: $msg")
}

// Default
fun greetUser(name: String = "Guest") {
    println("Hello, $name!")
}

// Named args usage
fun calculatePrice(base: Int, tax: Int, discount: Int) {
    println("Final Price = ${base + tax - discount}")
}

// Overloaded
fun show(text: String) = println("TEXT: $text")
fun show(id: Int) = println("ID: $id")

// Single-expression
fun square(n: Int) = n * n

// Higher-order
fun operate(a: Int, b: Int, op: (Int, Int) -> Int): Int = op(a, b)

// Reusable named lambda
val multiply: (Int, Int) -> Int = { x, y -> x * y }

// Inline
inline fun runTimed(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    println("Elapsed: ${end - start}ms")
}
