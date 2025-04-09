package s1_basics


/**
 * S1E_Comments.kt
 * This file demonstrates how to use comments in Kotlin:
 * - Single-line comments
 * - Multi-line comments
 * - KDoc (for documentation)
 */

fun main() {
    // 🔹 This is a single-line comment.
    println("Hello from Kotlin!") // You can add inline comments too.

    /*
     🔸 This is a multi-line comment.
     It can span across several lines.
     Useful for disabling blocks of code or writing detailed notes.
    */

    println("This line is after multi-line comment block.")

    // 🔸 Practice Tip:
    // Use single-line comments to explain logic above the code.
    // Use multi-line comments to describe a feature or module idea.

    // 🔸 Bonus: KDoc (used for documentation)
    // Use `/** ... */` before functions, classes, properties to generate documentation.
    showKDocExample()
}

/**
 * This function demonstrates the use of KDoc.
 * @author Tashy
 * @since Kotlin Basics
 */
fun showKDocExample() {
    println("KDoc example in action.")
}
