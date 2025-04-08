package s10_functional_programming


/*
 * -----------------------------------------------------
 * ✅ Lecture: Inline Functions – Advanced Concepts
 * -----------------------------------------------------
 * Kotlin lets you mark functions as `inline` to improve performance
 * when passing lambdas or function references.
 *
 * This reduces memory allocations and call overhead,
 * especially in performance-critical or DSL-style code.
 */

/*
 * 📌 Section 1 — Basic inline function
 */
inline fun section1_BasicInlineExample(action: () -> Unit) {
    println("🔃 Before inline block")
    action()
    println("✅ After inline block")
}

fun section1_RunInlineFunction() {
    section1_BasicInlineExample {
        println("💡 Inside lambda block")
    }
}

/*
 * 📌 Section 2 — `crossinline` to prevent non-local returns
 */
inline fun section2_WithCrossinline(crossinline onExecute: () -> Unit) {
    val runnable = Runnable {
        println("🚀 Runnable started")
        onExecute()
    }
    runnable.run()
}

fun section2_RunCrossinlineExample() {
    section2_WithCrossinline {
        println("⚠️ Cannot return from here due to crossinline")
        // return // ❌ Not allowed — compile error
    }
}

/*
 * 📌 Section 3 — `noinline` to disable inlining for specific lambda parameters
 */
inline fun section3_MixedInlineExample(inlineLambda: () -> Unit, noinline normalLambda: () -> Unit) {
    println("🏁 Start")
    inlineLambda()
    normalLambda()
}

fun section3_RunNoinlineExample() {
    val delayed = {
        println("🕒 This lambda is passed around (noinline)")
    }

    section3_MixedInlineExample(
        inlineLambda = { println("⚡ Inlined lambda runs now") },
        normalLambda = delayed
    )
}

/*
 * 🧠 What You Will Learn:
 * - How inline functions work under the hood
 * - Difference between `inline`, `crossinline`, and `noinline`
 * - When to use inline for performance or DSL building
 */

/*
 * 🚀 Quick Summary:
 * ✅ `inline` – inlines both function and lambda
 * ✅ `crossinline` – prevents return from lambda
 * ✅ `noinline` – keeps lambda as a reference (not inlined)
 */

/*
 * 📘 Key Takeaways:
 * - Inline functions reduce overhead from lambda objects
 * - Use `crossinline` to pass lambdas into other contexts (e.g. threads)
 * - Use `noinline` when passing a lambda to another function or storing it
 */

/*
 * 💡 Real-World Use Cases:
 * - Building DSLs (e.g. Jetpack Compose, Anko)
 * - Performance-sensitive utility functions
 * - Functional chaining without runtime overhead

 * 🧼 Clean Code Insight:
 * Don’t mark everything as `inline` — only where performance matters.
 * Avoid unnecessary inlining in large functions or with many lambdas.
 */
