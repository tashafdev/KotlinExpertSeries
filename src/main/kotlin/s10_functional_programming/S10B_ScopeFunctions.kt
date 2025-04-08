package s10_functional_programming


/*
 * -----------------------------------------------------
 * ✅ Lecture: Scope Functions in Kotlin
 * -----------------------------------------------------
 * Scope functions let you execute code **within the context of an object**.
 *
 * Kotlin provides 5 main scope functions:
 * 🔹 let
 * 🔹 run
 * 🔹 with
 * 🔹 apply
 * 🔹 also
 *
 * These improve readability and help reduce repetitive variable usage.
 */

/*
 * 📌 Section 1 — Using `let` for null-safety and transformations
 */
fun section1_UsingLet() {
    val name: String? = "Tashy"
    name?.let {
        println("👋 Hello from let: $it")
    }

    val length = name?.let { it.length } ?: 0
    println("📏 Name length: $length")
}

/*
 * 📌 Section 2 — Using `run` for returning results from a block
 */
fun section2_UsingRun() {
    val result = "Hello Kotlin".run {
        println("🚀 Running block with: $this")
        length * 2
    }
    println("🔁 Result from run: $result")
}

/*
 * 📌 Section 3 — Using `with` when you already have the object
 */
fun section3_UsingWith() {
    val list = mutableListOf("a", "b", "c")
    val result = with(list) {
        println("🔹 Size = $size")
        add("d")
        joinToString(" | ")
    }
    println("🧾 Final list: $result")
}

/*
 * 📌 Section 4 — Using `apply` to configure objects
 */
fun section4_UsingApply() {
    data class User(var name: String = "", var age: Int = 0)

    val user = User().apply {
        name = "Tashy"
        age = 28
    }
    println("🙋 User created: $user")
}

/*
 * 📌 Section 5 — Using `also` for side-effects like logging
 */
fun section5_UsingAlso() {
    val numbers = mutableListOf(1, 2, 3)
        .also { println("📝 Original list: $it") }
        .also { it.add(4) }
        .also { println("✅ Modified list: $it") }
}

/*
 * 🧠 What You Will Learn:
 * - When and why to use each scope function
 * - Difference in object reference inside lambda (`this` vs `it`)
 * - Use-cases: null safety, configuration, logging, chaining
 */

/*
 * 🚀 Quick Summary:
 * ✅ `let` – for null-checks & transformations (uses `it`)
 * ✅ `run` – execute block & return result (uses `this`)
 * ✅ `with` – like `run` but as a normal function (uses `this`)
 * ✅ `apply` – object configuration (returns receiver, uses `this`)
 * ✅ `also` – side-effects like logging (returns receiver, uses `it`)
 */

/*
 * 📘 Key Takeaways:
 * - Choose based on readability and purpose
 * - `apply` is great for builders/configuration
 * - `let` helps with optional chaining
 * - Use `also` to avoid breaking chains when logging or debugging
 */

/*
 * 💡 Real-World Use Cases:
 * - Building objects in a clean way (e.g. in ViewModels)
 * - Avoiding null-check boilerplate
 * - Logging during collection processing
 */

/*
 * 🧼 Clean Code Insight:
 * Use scope functions for intent clarity.
 * Don't overuse all of them—stick to what enhances readability.
 */
