package s22_algorithms.recursion_backtracking

/*
 * -----------------------------------------------------
 * 📚 Lecture: Recursion Basics (S22Ca_RecursionBasics.kt)
 * -----------------------------------------------------
 * Recursion:
 * - A function calling itself to solve a smaller instance of the same problem.
 * - Key parts:
 *   • Base Case: Terminates recursion (prevents infinite calls).
 *   • Recursive Case: Function calls itself with modified arguments.
 *
 * When to use recursion:
 * - Problems that can be broken into similar subproblems.
 * - Tree or graph traversals, combinatorial generation, divide‑and‑conquer algorithms.
 *
 * This lecture covers:
 * 1️⃣ Factorial (simple recursion)
 * 2️⃣ Fibonacci (naive vs memoized)
 * 3️⃣ Demo in main()
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Factorial: n! = n × (n−1)!
fun factorial(n: Int): Long {
    require(n >= 0) { "n must be non‑negative" }
    return if (n <= 1) 1L            // Base case: 0! = 1, 1! = 1
    else n * factorial(n - 1)       // Recursive case
}

// 2️⃣ Fibonacci (naive): F(n) = F(n−1) + F(n−2)
fun fibonacciNaive(n: Int): Long {
    require(n >= 0) { "n must be non‑negative" }
    return when (n) {
        0 -> 0L                      // Base cases
        1 -> 1L
        else -> fibonacciNaive(n - 1) + fibonacciNaive(n - 2)
    }
}

// 2️⃣ Fibonacci (memoized) for efficiency
fun fibonacciMemo(n: Int, memo: LongArray = LongArray(n + 1) { -1L }): Long {
    require(n >= 0) { "n must be non‑negative" }
    if (n <= 1) return n.toLong()    // Base cases
    if (memo[n] != -1L) return memo[n]
    memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo)
    return memo[n]
}

// 3️⃣ Demo in main()
fun main() {
    println("\n✅ Recursion Basics Demo")

    // Factorial
    val factInput = 5
    println("factorial($factInput) = ${factorial(factInput)}") // 120

    // Fibonacci naive
    val fibInput = 6
    println("fibonacciNaive($fibInput) = ${fibonacciNaive(fibInput)}") // 8

    // Fibonacci memoized
    val fibLarge = 40
    println("fibonacciMemo($fibLarge) = ${fibonacciMemo(fibLarge)}") // fast, no exponential delay
}

/*
 * 🔍 Android Use Cases:
 * - **View Hierarchy Traversal:** Recursively walk nested ViewGroups to find or modify Views.
 * - **File/Directory Scanning:** Traverse filesystem for media pickers or file explorers.
 * - **JSON/XML Parsing:** Process nested JSON or XML nodes into data models.
 * - **UI Backstack Processing:** Recursively handle nested Fragment or Activity stacks.
 * - **Combinatorial Layouts:** Generate combinations of style/theme attributes for dynamic theming.
 *
 * 🔟 Summary:
 * ✅ Always define a clear base case to stop recursion.
 * ✅ Recursive solutions map naturally to hierarchical data.
 * ✅ Watch out for performance—use memoization or convert to iterative when needed.
 * ✅ Recursion depth is limited by stack size; deep recursion may need tail‑recursion or iterative rewrite.
 */
