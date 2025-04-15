package s22_algorithms.recursion_backtracking

/*
 * -----------------------------------------------------
 * 📚 Lecture: Backtracking N‑Queens (S22Cb_BacktrackingNQueens.kt)
 * -----------------------------------------------------
 * N‑Queens Problem:
 * - Place N queens on an N×N chessboard so that no two queens attack each other.
 * - Queens attack along rows, columns, and both diagonals.
 *
 * Key Concepts:
 * - Backtracking: Try a placement, recurse to next row, backtrack on conflict.
 * - State Tracking:
 *    • cols[col] = true if a queen occupies column `col`.
 *    • diag1[row+col] = true for “\” diagonals.
 *    • diag2[row-col + (n-1)] = true for “/” diagonals.
 *
 * Time Complexity: Exponential, roughly O(N!) in worst case
 * Space Complexity: O(N²) for storing solutions and recursion stack
 *
 * This lecture covers:
 * 1️⃣ Board representation & safety checks
 * 2️⃣ Recursive backtracking function
 * 3️⃣ Building solution strings
 * 4️⃣ Demo in main()
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Solve N‑Queens and return all distinct board configurations
fun solveNQueens(n: Int): List<List<String>> {
    val results = mutableListOf<List<String>>()
    val board = Array(n) { CharArray(n) { '.' } }
    val cols = BooleanArray(n)
    val diag1 = BooleanArray(2 * n - 1) // row+col
    val diag2 = BooleanArray(2 * n - 1) // row-col+(n-1)

    fun backtrack(row: Int) {
        if (row == n) {
            // Found valid placement, convert board to List<String>
            results += board.map { String(it) }
            return
        }
        for (col in 0 until n) {
            val d1 = row + col
            val d2 = row - col + (n - 1)
            // Check if placing at (row, col) is safe
            if (cols[col] || diag1[d1] || diag2[d2]) continue

            // Place queen
            board[row][col] = 'Q'
            cols[col] = true; diag1[d1] = true; diag2[d2] = true

            // Recurse to next row
            backtrack(row + 1)

            // Backtrack: remove queen
            board[row][col] = '.'
            cols[col] = false; diag1[d1] = false; diag2[d2] = false
        }
    }

    backtrack(0)
    return results
}

// 2️⃣ Demo in main()
fun main() {
    println("\n✅ N‑Queens Demo")
    val n = 4
    val solutions = solveNQueens(n)
    println("Total solutions for N=$n: ${solutions.size}")
    solutions.forEachIndexed { idx, board ->
        println("\nSolution ${idx + 1}:")
        board.forEach { println(it) }
    }
}

/*
 * 🔍 Android Use Cases:
 * - **UI Constraint Solving:** Place dynamic UI widgets without overlap (e.g., drag‑and‑drop editors).
 * - **Puzzle & Game Logic:** Implement chess puzzles or placement games in educational apps.
 * - **Dynamic Layout Arrangement:** Arrange dashboard tiles or cards under placement constraints.
 * - **Resource Scheduling:** Assign tasks to time slots/resources avoiding conflicts.
 * - **Form Dependency Resolution:** Enable/disable form fields based on multiple constraint rules.
 *
 * 🔟 Summary:
 * ✅ Backtracking systematically explores and abandons invalid states.
 * ✅ State arrays (cols, diag1, diag2) enable O(1) safety checks.
 * ✅ Good for constraint‑satisfaction problems beyond chess (UI, scheduling).
 * ✅ Exponential time—practical for small N (N ≤ 12) in real apps.
 */
