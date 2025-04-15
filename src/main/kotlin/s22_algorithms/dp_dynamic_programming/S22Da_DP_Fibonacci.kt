package s22_algorithms.dp_dynamic_programming

/*
 * -----------------------------------------------------
 * 📚 Lecture: DP Fibonacci (S22Da_DP_Fibonacci.kt)
 * -----------------------------------------------------
 * Fibonacci Numbers:
 * - Sequence: F(0)=0, F(1)=1, F(n)=F(n−1)+F(n−2)
 * - Naive recursion has exponential time O(2ⁿ).
 * - Dynamic Programming optimizes with:
 *     • Top‑down memoization (cache results) → O(n)
 *     • Bottom‑up iteration → O(n)
 *
 * This lecture covers:
 * 1️⃣ Naive recursive implementation
 * 2️⃣ Top‑down memoized implementation
 * 3️⃣ Bottom‑up iterative implementation
 * 4️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Naive recursive Fibonacci (exponential time)
fun fibNaive(n: Int): Long {
    require(n >= 0) { "n must be non‑negative" }
    return if (n < 2) n.toLong() else fibNaive(n - 1) + fibNaive(n - 2)
}

// 2️⃣ Top‑down memoized Fibonacci (cache intermediate results)
fun fibMemo(n: Int, memo: LongArray = LongArray(n + 1) { -1L }): Long {
    require(n >= 0) { "n must be non‑negative" }
    if (n < 2) return n.toLong()
    if (memo[n] != -1L) return memo[n]
    memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo)
    return memo[n]
}

// 3️⃣ Bottom‑up iterative Fibonacci (tabulation)
fun fibBottomUp(n: Int): Long {
    require(n >= 0) { "n must be non‑negative" }
    if (n < 2) return n.toLong()
    var prev = 0L
    var curr = 1L
    for (i in 2..n) {
        val next = prev + curr
        prev = curr
        curr = next
    }
    return curr
}

// 4️⃣ Demo in main()
fun main() {
    println("\n✅ DP Fibonacci Demo")

    val n = 20
    println("fibNaive($n)       = ${fibNaive(10)}  // use small n for naive")
    println("fibMemo($n)        = ${fibMemo(n)}")
    println("fibBottomUp($n)    = ${fibBottomUp(n)}")
}

/*
 * 🔍 Android Use Cases:
 * - **Retry Backoff:** Fibonacci‑based delays for network retry strategies.
 * - **Golden Ratio Layouts:** Compute view dimensions approximating golden ratio (F(n+1)/F(n)).
 * - **Animation Timing:** Sequence animation delays for natural pacing in reveal or transition effects.
 * - **Game Scoring:** Calculate combo or level multipliers following Fibonacci growth.
 * - **Paging Offsets:** Generate offsets for infinite scroll or carousel steps.

 * 🔟 Summary:
 * ✅ Naive recursion is simple but exponential.
 * ✅ Memoization caches overlapping subproblems → linear time.
 * ✅ Bottom‑up tabulation uses constant space and linear time.
 * ✅ DP transforms exponential recursion into efficient linear solutions.
 */
