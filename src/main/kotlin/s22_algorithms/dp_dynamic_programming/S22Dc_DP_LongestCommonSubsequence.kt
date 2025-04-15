package s22_algorithms.dp_dynamic_programming

/*
 * -----------------------------------------------------
 * 📚 Lecture: Longest Common Subsequence (S22Dc_DP_LongestCommonSubsequence.kt)
 * -----------------------------------------------------
 * Problem:
 * - Given two sequences, find the length of their longest subsequence
 *   that appears in both (not necessarily contiguous).
 *
 * Characteristics:
 * - Time Complexity: O(m·n), where m = length of first string, n = length of second.
 * - Space Complexity: O(m·n) for the DP table (can optimize to O(min(m,n))).
 *
 * This lecture covers:
 * 1️⃣ Definition & DP formulation
 * 2️⃣ 2D bottom‑up DP implementation
 * 3️⃣ Reconstructing one LCS string
 * 4️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Compute DP table for LCS lengths
/**
 * Builds a (m+1)x(n+1) table where dp[i][j] is the length of LCS
 * of str1[0..i-1] and str2[0..j-1].
 */
fun lcsLength(str1: String, str2: String): Array<IntArray> {
    val m = str1.length
    val n = str2.length
    val dp = Array(m + 1) { IntArray(n + 1) }

    for (i in 1..m) {
        for (j in 1..n) {
            dp[i][j] = if (str1[i - 1] == str2[j - 1]) {
                dp[i - 1][j - 1] + 1
            } else {
                maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    return dp
}

// 2️⃣ Reconstruct one LCS from the DP table
/**
 * Walks backwards from dp[m][n] to build one LCS string.
 */
fun buildLcs(dp: Array<IntArray>, str1: String, str2: String): String {
    val sb = StringBuilder()
    var i = str1.length
    var j = str2.length

    while (i > 0 && j > 0) {
        when {
            str1[i - 1] == str2[j - 1] -> {
                sb.append(str1[i - 1])
                i--; j--
            }
            dp[i - 1][j] > dp[i][j - 1] -> i--
            else                         -> j--
        }
    }
    return sb.reverse().toString()
}

// 3️⃣ Demo in main()
fun main() {
    println("\n✅ LCS (Longest Common Subsequence) Demo")

    val s1 = "AGGTAB"
    val s2 = "GXTXAYB"
    println("String1: $s1")
    println("String2: $s2")

    // Compute DP table
    val dp = lcsLength(s1, s2)
    val length = dp[s1.length][s2.length]
    println("LCS length: $length")  // Expected 4 ("GTAB")

    // Reconstruct one LCS
    val lcs = buildLcs(dp, s1, s2)
    println("One LCS: \"$lcs\"")
}

/*
 * 🔍 Android Use Cases:
 * - **Text Diffing:** Highlight changes between two text versions (e.g., code diffs, document editors).
 * - **Autocomplete Merging:** Find common patterns between user input and dictionary entries.
 * - **File Synchronization:** Determine unchanged subsequences for efficient syncing.
 * - **Gesture Matching:** Compare recorded gesture sequences to templates for recognition.
 * - **Playlist Recommendations:** Match user’s listening sequence against curated playlists for overlaps.
 *
 * 🔟 Summary:
 * ✅ LCS uses a 2D DP table of size (m+1)x(n+1).
 * ✅ dp[i][j] = dp[i-1][j-1]+1 if chars match, else max(dp[i-1][j], dp[i][j-1]).
 * ✅ Reconstruction walks backwards to build one subsequence.
 * ✅ Runs in O(m·n) time—suitable for moderate-length strings in Android apps.
 */
