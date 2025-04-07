package kotlin.s4_functions

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 4D: Inline Functions (Intro)
    📦 Package: kotlin.s4_functions
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What are inline functions?
    - Why and when to use them
    - How they optimize performance
    - `noinline` and `crossinline`
    - Use cases: timing, filtering, benchmarking
    - Best practices

    ---------------------------------------------------------------------------
    ⚡ What is an Inline Function?
    ----------------------------------------------------------------------------
    - Kotlin allows functions marked as `inline` to have their **body inlined** at call site.
    - Useful in **higher-order functions** to avoid the cost of lambda object allocation.

    ✅ Example:
        inline fun logExecution(block: () -> Unit) {
            println(\"Start\")
            block()
            println(\"End\")
        }

    ---------------------------------------------------------------------------
    🔁 Benefits of Inline
    ----------------------------------------------------------------------------
    - Reduces function call overhead (especially with lambdas)
    - Eliminates anonymous object creation
    - Enables use of `return` from lambda directly
    - Makes code faster at runtime (but slightly larger bytecode)

    ---------------------------------------------------------------------------
    🚫 noinline – prevent inlining of specific lambdas
    ----------------------------------------------------------------------------
    - Use `noinline` when only **some** lambdas need inlining.

    Example:
        inline fun process(action: () -> Unit, noinline onCancel: () -> Unit)

    ---------------------------------------------------------------------------
    ⛔ crossinline – prevent non-local returns
    ----------------------------------------------------------------------------
    - Use `crossinline` when lambda **should not use `return`**.

    Example:
        inline fun runSafe(crossinline block: () -> Unit)

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use `inline` only with small, frequently used lambdas
    - Avoid overusing in large functions (can increase bytecode size)
    - Prefer inline for DSLs, performance-critical paths, and scoped functions
    ---------------------------------------------------------------------------
*/


fun main() {
    println("→ Inline timing demo:")
    runTimed1 {
        println("Doing work...")
        Thread.sleep(250)
    }

    println("\n→ Inline with lambda:")
    withLogging {
        println("This runs with pre/post logs")
    }

    println("\n→ crossinline demo:")
    runBlocking {
        println("Still can't return from here directly")
    }
}

// ⚡ Inline function example
inline fun runTimed1(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    println("Took ${end - start}ms")
}

// ⚙️ Inline with logging wrapper
inline fun withLogging(action: () -> Unit) {
    println(">> START")
    action()
    println(">> END")
}

// ⛔ Inline with crossinline (non-local return not allowed)
inline fun runBlocking(crossinline block: () -> Unit) {
    val thread = Thread {
        block() // return here not allowed due to crossinline
    }
    thread.start()
    thread.join()
}
