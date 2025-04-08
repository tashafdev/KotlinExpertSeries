package s11_testing


/*
 * -----------------------------------------------------
 * ✅ Kotlin Testing Intro — Why Tests Matter
 * -----------------------------------------------------
 * Testing is critical for:
 * 🔹 Confidence in code changes
 * 🔹 Catching regressions early
 * 🔹 Refactoring safely
 * 🔹 Documenting expected behavior
 *
 * Kotlin makes testing clean, expressive, and powerful.
 */

/*
 * 📌 Section 1 — What is Testing?
 * - Verifying that code behaves as expected
 * - Done using assertions and test runners
 * - Unit, integration, UI, and instrumentation tests
 */

/*
 * 📌 Section 2 — Types of Tests
 */
fun section2_typesOfTestsOverview() {
    println(
        """
        🔍 Types of Tests:
        -------------------------
        ✅ Unit Test         - Smallest unit of logic
        ✅ Integration Test  - Components working together
        ✅ Instrumentation   - On-device, UI, Espresso
        ✅ Snapshot Test     - Visual UI check (optional)
        ✅ End-to-End (E2E)  - Simulate real user flow
        """.trimIndent()
    )
}

/*
 * 📌 Section 3 — Basic Test Anatomy (JUnit-style)
 * - Setup (Arrange)
 * - Execution (Act)
 * - Assertion (Assert)
 */
fun section3_basicTestExample() {
    val result = 2 + 2
    check(result == 4) { "Expected 4, got $result" }
    println("✅ Basic assertion passed")
}

/*
 * 📌 Section 4 — Good Test Practices
 */
fun section4_goodTestPractices() {
    println(
        """
        🧼 Good Practices:
        -------------------------
        • Use clear test names: `shouldReturnCorrectSum()`
        • Keep tests isolated
        • Avoid real dependencies → use mocks
        • Test both success & failure paths
        • Keep them fast (unit tests < 1s)
        """.trimIndent()
    )
}

/*
 * 🧠 What You Will Learn:
 * - Why testing is important in real projects
 * - Types of tests and where they fit
 * - Simple structure of a clean test
 */

/*
 * 🚀 Quick Summary:
 * ✅ Test = Confidence
 * ✅ Fewer bugs + safer refactoring
 * ✅ Kotlin makes tests clean and expressive

 * 💡 Real-World Use Cases:
 * - Verify business logic (e.g. price calculation)
 * - Validate form inputs or API models
 * - Prevent crashes in user-critical paths

 * 🧼 Clean Code Insight:
 * Your code is not done until it’s test-covered 💼🔒
 */
