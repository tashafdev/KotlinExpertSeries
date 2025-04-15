package s22_algorithms.recursion_backtracking

/*
 * -----------------------------------------------------
 * 📚 Lecture: Subset & Permutation Generation (S22Cc_SubsetAndPermutationGen.kt)
 * -----------------------------------------------------
 * This lecture shows how to generate:
 * 1. All subsets (the power set) of a list.
 * 2. All permutations of a list.
 *
 * Concepts:
 * - Recursion with backtracking.
 * - Building up a partial result and exploring choices.
 * - Backtracking by undoing the last choice.
 *
 * Time Complexity:
 * - Subsets: O(2ⁿ) subsets for n elements.
 * - Permutations: O(n!) permutations for n elements.
 *
 * This lecture covers:
 * 1️⃣ Subset generation
 * 2️⃣ Permutation generation
 * 3️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Generate all subsets (power set) of a list
fun <T> generateSubsets(input: List<T>): List<List<T>> {
    val results = mutableListOf<List<T>>()
    fun backtrack(start: Int, current: MutableList<T>) {
        // Add a copy of current subset
        results += current.toList()
        // Try adding each remaining element
        for (i in start until input.size) {
            current += input[i]
            backtrack(i + 1, current)
            current.removeAt(current.lastIndex) // backtrack
        }
    }
    backtrack(0, mutableListOf())
    return results
}

// 2️⃣ Generate all permutations of a list
fun <T> generatePermutations(input: List<T>): List<List<T>> {
    val results = mutableListOf<List<T>>()
    val used = BooleanArray(input.size)
    fun backtrack(current: MutableList<T>) {
        if (current.size == input.size) {
            results += current.toList()
            return
        }
        for (i in input.indices) {
            if (used[i]) continue
            used[i] = true
            current += input[i]
            backtrack(current)
            current.removeAt(current.lastIndex) // backtrack
            used[i] = false
        }
    }
    backtrack(mutableListOf())
    return results
}

// 3️⃣ Demo in main()
fun main() {
    println("\n✅ Subset & Permutation Generation Demo")

    val nums = listOf(1, 2, 3)
    val subsets = generateSubsets(nums)
    println("\nAll subsets of $nums:")
    subsets.forEach { println(it) }

    val perms = generatePermutations(nums)
    println("\nAll permutations of $nums:")
    perms.forEach { println(it) }
}

/*
 * 🔍 Android Use Cases:
 * - Feature Flag Combinations:
 *    Generate all subsets of feature toggles for A/B testing build variants.
 * - UI Theme Variants:
 *    Produce combinations of color/font settings to preview in design tools.
 * - Form Field Testing:
 *    Create subsets of optional input fields to validate form handling.
 * - Animation Sequence Permutations:
 *    Try different orders of UI animations to find the most engaging flow.
 * - Layout Variation Generation:
 *    Permute child view orders in dynamic layouts for usability testing.
 *
 * 🔟 Summary:
 * ✅ Subset generation explores inclusion/exclusion of each element (2ⁿ results).
 * ✅ Permutation generation orders all elements (n! results).
 * ✅ Backtracking pattern: choose, recurse, undo choice.
 * ✅ Useful for combinatorial testing, dynamic UI configurations, and more.
 */
