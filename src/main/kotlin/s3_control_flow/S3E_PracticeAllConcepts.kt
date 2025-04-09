package s3_control_flow


/**
 * S3E_PracticeAllConcepts.kt
 * Problem: Build a basic quiz app with scoring, using control flow concepts:
 * - if/when expressions
 * - loops
 * - break, continue, return
 */

fun main() {
    println("🎓 Welcome to Kotlin Quiz App!")

    var score = 0

    val questions = listOf(
        "What is the capital of France?" to "Paris",
        "What is 5 * 3?" to "15",
        "Which language are we learning?" to "Kotlin"
    )

    for ((index, question) in questions.withIndex()) {
        println("Q${index + 1}: ${question.first}")
        val answer = readLine()

        if (answer.isNullOrBlank()) {
            println("⛔ Skipping empty answer...")
            continue
        }

        if (answer.trim().equals(question.second, ignoreCase = true)) {
            println("✅ Correct!")
            score++
        } else {
            println("❌ Wrong! The correct answer is ${question.second}")
        }

        if (index == 1 && score == 0) {
            println("💡 Tip: Try a bit harder!")
        }

        if (index == 2 && score == 0) {
            println("❌ Ending quiz early. No correct answers.")
            break
        }
    }

    // Use `when` to evaluate final score
    val result = when (score) {
        3 -> "🎉 Perfect Score!"
        2 -> "👏 Good Job!"
        1 -> "🙂 Needs Improvement"
        else -> "😢 Try again next time"
    }

    println("Final Score: $score/3 → $result")
}
