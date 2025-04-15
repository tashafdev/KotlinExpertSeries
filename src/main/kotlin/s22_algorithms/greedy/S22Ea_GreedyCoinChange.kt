package s22_algorithms.greedy

/*
 * -----------------------------------------------------
 * 📚 Lecture: Greedy Coin Change (S22Ea_GreedyCoinChange.kt)
 * -----------------------------------------------------
 * Problem:
 * - Given a set of coin denominations and a target amount,
 *   determine the minimum number of coins needed to make that amount.
 * - Greedy strategy: always pick the largest denomination <= remaining amount.
 * - Works optimally for canonical coin systems (e.g., most real-world currencies).
 *
 * Characteristics:
 * - Time Complexity: O(n + k) where n = number of denominations, k = number of coins used
 * - Space Complexity: O(1) auxiliary (plus output list)
 *
 * This lecture covers:
 * 1️⃣ Greedy algorithm explanation
 * 2️⃣ Kotlin implementation returning chosen coins
 * 3️⃣ Demo in main()
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Greedy Coin Change implementation
/**
 * Returns a list of coins that sum to the target amount using the greedy approach.
 * @param coins  Sorted array of coin denominations in descending order
 * @param amount Target amount to make
 * @return List of coins used (largest first)
 */
fun greedyCoinChange(coins: IntArray, amount: Int): List<Int> {
    var remaining = amount
    val result = mutableListOf<Int>()
    for (coin in coins) {
        while (remaining >= coin) {
            remaining -= coin
            result += coin
        }
        if (remaining == 0) break
    }
    return if (remaining == 0) result else emptyList() // empty if no solution
}

// 2️⃣ Demo in main()
fun main() {
    println("\n✅ Greedy Coin Change Demo")
    val denominations = intArrayOf(25, 10, 5, 1)  // US quarters, dimes, nickels, pennies
    val amount = 63
    val change = greedyCoinChange(denominations, amount)
    if (change.isNotEmpty()) {
        println("Amount: $$amount → Coins: $change")
        println("Total coins used: ${change.size}")
    } else {
        println("No solution for amount: $amount with given denominations")
    }
}

/*
 * 🔍 Android Use Cases:
 * - Cashier & POS Apps:
 *    Compute change for transactions in retail or vending machine apps.
 * - Budgeting Tools:
 *    Break down expense amounts into currency denominations for display.
 * - In-App Rewards:
 *    Allocate points or credits in fixed-size bundles (e.g., badges, coins).
 * - Resource Allocation:
 *    Divide storage quotas or memory pools into standard block sizes.
 * - Quick Estimations:
 *    Provide instant coin suggestions for user input in finance apps.
 *
 * 🔟 Summary:
 * ✅ Greedy picks largest coin first—fast and simple.
 * ✅ Optimal only for canonical coin systems.
 * ✅ Runs in linear time relative to denominations and coins used.
 * ✅ Use dynamic programming if denominations are non-canonical.
 */