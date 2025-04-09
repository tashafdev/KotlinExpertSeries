package s11_testing


//import org.junit.Assert.*
//import org.junit.Test
//
///*
// * -----------------------------------------------------
// * ✅ JUnit Basics in Kotlin
// * -----------------------------------------------------
// * JUnit is the default unit testing framework for Kotlin on the JVM.
// * With annotations like `@Test`, `@Before`, `@After`, you control setup and logic testing easily.
// */
//
///*
// * 📌 Section 1 — Basic Test Function
// */
//class Calculator {
//    fun add(a: Int, b: Int): Int = a + b
//    fun divide(a: Int, b: Int): Int = a / b
//}
//
//class CalculatorTest {
//
//    private val calc = Calculator()
//
//    @Test
//    fun s11b_addition_isCorrect() {
//        val result = calc.add(2, 3)
//        assertEquals("Should return 5", 5, result)
//    }
//
//    @Test
//    fun s11b_division_byZero_shouldThrow() {
//        try {
//            calc.divide(10, 0)
//            fail("Expected ArithmeticException")
//        } catch (e: ArithmeticException) {
//            // Success
//            println("✅ Division by zero threw expected error")
//        }
//    }
//}
//
///*
// * 📌 Section 2 — Common JUnit Assertions
// */
//fun section2_junitAssertionExamples() {
//    assertEquals(4, 2 + 2)
//    assertNotEquals(5, 3 + 3)
//    assertTrue("Kotlin".startsWith("K"))
//    assertFalse(10 < 5)
//    assertNull(null)
//    assertNotNull("something")
//}
//
///*
// * 📌 Section 3 — Lifecycle Hooks
// */
//class LifecycleExampleTest {
//
//    @org.junit.Before
//    fun setup() {
//        println("⚙️ Before each test")
//    }
//
//    @org.junit.After
//    fun teardown() {
//        println("🧹 After each test")
//    }
//
//    @Test
//    fun s11b_sampleTest() {
//        println("🔍 Test logic here")
//        assertTrue(true)
//    }
//}
//
///*
// * 🧠 What You Will Learn:
// * - How to write tests using JUnit 4
// * - Key assertions and when to use them
// * - Setup and teardown logic for test prep/cleanup
// */
//
///*
// * 🚀 Quick Summary:
// * ✅ `@Test` to mark test functions
// * ✅ `assertEquals`, `assertTrue`, `fail()` for validations
// * ✅ `@Before`, `@After` for setup/teardown
//
// * 💡 Real-World Use Cases:
// * - Validate business logic (math, models, flow)
// * - Handle edge cases (null, empty input, exceptions)
// * - Control dependencies via setup
//
// * 🧼 Clean Code Insight:
// * Test like you refactor — with purpose, coverage, and clarity.
// */
