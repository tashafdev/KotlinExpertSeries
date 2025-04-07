package kotlin.s4_functions

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 4E: Recursion Examples (Optional)
    📦 Package: kotlin.s4_functions
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What is recursion?
    - Classic recursive problems: factorial, Fibonacci, sum of digits
    - How recursion works behind the scenes
    - Stack overflow risks
    - Tail recursion optimization
    - Best practices

    ---------------------------------------------------------------------------
    🔁 What is Recursion?
    ----------------------------------------------------------------------------
    - A function that calls **itself** to solve a smaller instance of the problem.
    - Must have a **base case** to terminate recursion.

    Example:
        fun countDown(n: Int) {
            if (n <= 0) return
            println(n)
            countDown(n - 1)
        }

    ---------------------------------------------------------------------------
    ✅ Classic Recursive Problems
    ----------------------------------------------------------------------------
    1. Factorial:
        fun factorial(n: Int): Int {
            return if (n == 1) 1 else n * factorial(n - 1)
        }

    2. Fibonacci:
        fun fib(n: Int): Int {
            return if (n <= 1) n else fib(n - 1) + fib(n - 2)
        }

    3. Sum of Digits:
        fun sumDigits(n: Int): Int {
            return if (n == 0) 0 else (n % 10) + sumDigits(n / 10)
        }

    ---------------------------------------------------------------------------
    ✅ Tail Recursion
    ----------------------------------------------------------------------------
    - Kotlin supports tail call optimization using `tailrec` modifier.
    - Reduces stack size by converting recursion to a loop internally.

    Example:
        tailrec fun tailSum(n: Int, acc: Int = 0): Int {
            return if (n == 0) acc else tailSum(n - 1, acc + n)
        }

    ---------------------------------------------------------------------------
    ⚠️ Recursion vs Iteration
    ----------------------------------------------------------------------------
    - Iteration is often more efficient in Kotlin due to no guaranteed TCO.
    - Use recursion for simplicity, but not for very deep stacks (unless tailrec).

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Always define a clear base case
    - Prefer tailrec for deep recursive calls
    - Test with edge cases and large inputs
    ---------------------------------------------------------------------------
*/


fun main() {
    println("→ Factorial of 5: ${factorial(5)}") // 120
    println("→ 6th Fibonacci: ${fib(6)}") // 8
    println("→ Sum of digits (456): ${sumDigits(456)}") // 15

    println("\n→ Tailrec sum from 5 to 0: ${tailSum(5)}") // 15

    println("\n→ Countdown:")
    countDown(3)
}

// 🔁 Factorial
fun factorial(n: Int): Int {
    return if (n == 1) 1 else n * factorial(n - 1)
}

// 🔁 Fibonacci (basic version)
fun fib(n: Int): Int {
    return if (n <= 1) n else fib(n - 1) + fib(n - 2)
}

// 🔁 Sum of digits
fun sumDigits(n: Int): Int {
    return if (n == 0) 0 else (n % 10) + sumDigits(n / 10)
}

// ✅ Tail-recursive sum
tailrec fun tailSum(n: Int, acc: Int = 0): Int {
    return if (n == 0) acc else tailSum(n - 1, acc + n)
}

// 🔁 Countdown (simple)
fun countDown(n: Int) {
    if (n <= 0) return
    println(n)
    countDown(n - 1)
}
