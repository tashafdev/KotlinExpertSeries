package s22_algorithms.dp_dynamic_programming

/*
 * -----------------------------------------------------
 * 📚 Lecture: 0/1 Knapsack (S22Db_DP_Knapsack.kt)
 * -----------------------------------------------------
 * Problem:
 * - Given n items with weights and values, and a capacity W,
 *   select a subset of items to maximize total value without
 *   exceeding the capacity.
 *
 * Variants:
 * - 0/1 Knapsack: each item can be taken at most once.
 *
 * Time Complexity:
 * - Recursive: O(2ⁿ)
 * - DP (2D): O(n·W)
 * - DP (1D optimized): O(n·W)
 *
 * Space Complexity:
 * - Recursive: O(n) recursion stack
 * - DP (2D): O(n·W)
 * - DP (1D): O(W)
 *
 * This lecture covers:
 * 1️⃣ Naive recursive solution
 * 2️⃣ Bottom‑up DP with 2D table
 * 3️⃣ Space‑optimized DP with 1D array
 * 4️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Naive recursive solution (exponential time)
fun knapsackRecursive(
    weights: IntArray,
    values: IntArray,
    capacity: Int,
    n: Int
): Int {
    // Base case: no items or no capacity
    if (n == 0 || capacity == 0) return 0

    // If weight of last item is more than capacity, skip it
    return if (weights[n - 1] > capacity) {
        knapsackRecursive(weights, values, capacity, n - 1)
    } else {
        // Return max of: include the item vs exclude it
        val include = values[n - 1] + knapsackRecursive(weights, values, capacity - weights[n - 1], n - 1)
        val exclude = knapsackRecursive(weights, values, capacity, n - 1)
        maxOf(include, exclude)
    }
}

// 2️⃣ Bottom‑up DP using a 2D table
fun knapsackDP(
    weights: IntArray,
    values: IntArray,
    capacity: Int
): Int {
    val n = weights.size
    // dp[i][w] = max value using first i items with capacity w
    val dp = Array(n + 1) { IntArray(capacity + 1) }

    for (i in 1..n) {
        for (w in 0..capacity) {
            dp[i][w] = if (weights[i - 1] <= w) {
                maxOf(
                    values[i - 1] + dp[i - 1][w - weights[i - 1]],
                    dp[i - 1][w]
                )
            } else {
                dp[i - 1][w]
            }
        }
    }
    return dp[n][capacity]
}

// 3️⃣ Space‑optimized DP using a 1D array
fun knapsackDPOptimized(
    weights: IntArray,
    values: IntArray,
    capacity: Int
): Int {
    val n = weights.size
    val dp = IntArray(capacity + 1)
    // Iterate items
    for (i in 0 until n) {
        // Traverse capacities in reverse to avoid reuse of same item
        for (w in capacity downTo weights[i]) {
            dp[w] = maxOf(dp[w], values[i] + dp[w - weights[i]])
        }
    }
    return dp[capacity]
}

// 4️⃣ Demo in main()
fun main() {
    println("\n✅ 0/1 Knapsack Demo")

    val weights = intArrayOf(2, 3, 4, 5)
    val values  = intArrayOf(3, 4, 5, 6)
    val capacity = 5
    val n = weights.size

    println("Naive recursive result: ${knapsackRecursive(weights, values, capacity, n)}")
    println("DP (2D) result:           ${knapsackDP(weights, values, capacity)}")
    println("DP (1D optimized) result: ${knapsackDPOptimized(weights, values, capacity)}")
}

/*
 * 🔍 Android Use Cases:
 * - **Image Cache Selection:** Choose which images to cache under memory/storage limit to maximize UI quality.
 * - **Download Manager:** Select files to prefetch for offline use given data cap constraints.
 * - **Game Inventory:** Pick items to carry (weapons, potions) under weight limits to maximize power/utility.
 * - **Feature Toggle Bundles:** Bundle feature modules within APK size limits to maximize functionality.
 * - **Battery‑Aware Task Scheduling:** Schedule background jobs under energy budget to maximize work done.
 *
 * 🔟 Summary:
 * ✅ Recursive approach is simple but exponential.
 * ✅ DP transforms it to polynomial time O(n·W).
 * ✅ 1D DP reduces space to O(W) while maintaining time complexity.
 * ✅ Ideal for any bounded‑capacity optimization in Android apps.
 */
