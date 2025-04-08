package s10_functional_programming



/*
 * -----------------------------------------------------
 * ✅ Lecture: Lambdas and Higher-Order Functions
 * -----------------------------------------------------
 * Lambdas are anonymous functions.
 * Higher-Order Functions (HOFs) take functions as parameters or return them.
 *
 * These are **foundational to functional programming in Kotlin**.
 */

/*
 * 📌 Section 1 — Lambda with parameters
 */
fun section1_LambdaWithParams() {
    val greet: (String) -> String = { name -> "Hello, $name 👋" }
    println(greet("Tashy")) // Hello, Tashy 👋
}

/*
 * 📌 Section 2 — Lambda with no parameters
 */
fun section2_LambdaWithoutParams() {
    val sayHi = { println("Hi there! 👋") }
    sayHi()
}

/*
 * 📌 Section 3 — Higher-Order Function taking a lambda as argument
 */
fun section3_HigherOrderFunction() {
    fun operate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

    val sum = operate(5, 3) { x, y -> x + y }
    println("Sum: $sum") // 8

    val diff = operate(10, 4) { x, y -> x - y }
    println("Difference: $diff") // 6
}

/*
 * 📌 Section 4 — Function returning a lambda (closure)
 */
fun section4_ReturningLambda() {
    fun multiplier(factor: Int): (Int) -> Int {
        return { number -> number * factor }
    }

    val double = multiplier(2)
    println("Double 7 = ${double(7)}") // 14
}

/*
 * 🧠 What You Will Learn:
 * - What is a lambda
 * - Syntax of declaring and using lambdas
 * - How to write Higher-Order Functions
 * - Why they're useful for clean, abstract code
 */

/*
 * 🚀 Quick Summary:
 * ✅ Lambdas = anonymous functions (no need to declare)
 * ✅ HOFs = pass logic as parameters
 * ✅ Boosts reusability, readability, and abstraction
 */

/*
 * 📘 Key Takeaways:
 * - Use lambdas to simplify logic (like onClick, filters, maps)
 * - HOFs are the building blocks of functional APIs and DSLs
 * - Lambdas can be stored, passed, and returned — just like data
 */

/*
 * 💡 Real-World Use Cases:
 * - Button click listeners in Android
 * - Stream/collection operations (`map`, `filter`)
 * - Custom functional APIs
 * - Functional chaining and DSL building
 */

/*
 * 🧠 Bonus Tip:
 * You can use `it` as the implicit name for a single lambda parameter:
 *     list.filter { it > 10 }
 *
 * 🧼 Clean Code Insight:
 * Keep lambdas short and meaningful.
 * If it's longer than 3–5 lines, extract it into a named function.
 */

