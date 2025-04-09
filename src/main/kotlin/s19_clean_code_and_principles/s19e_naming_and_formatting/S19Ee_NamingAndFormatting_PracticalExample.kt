package s19_clean_code_and_principles.s19e_naming_and_formatting


/**
 * S19Ee_NamingAndFormatting_PracticalExample.kt
 * Example showing bad vs good naming and formatting in Kotlin.
 */

fun runS19Ee_NamingAndFormattingPractice() {
    println("❌ Bad Version Output:")
    S19Ee_BadExample().d1("Tashy")

    println("\n✅ Good Version Output:")
    S19Ee_GoodExample().greetUser("Tashy")
}

// ❌ BAD EXAMPLE: poor naming, formatting, and structure
class S19Ee_BadExample {
    fun d1(n: String){
        println("hi "+n+"!!!") }
}

// ✅ GOOD EXAMPLE: readable, clean, well-named
class S19Ee_GoodExample {
    fun greetUser(name: String) {
        println("Hi, $name!")
    }
}
