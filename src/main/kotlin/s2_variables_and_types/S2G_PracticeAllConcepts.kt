package s2_variables_and_types


/**
 * S2G_PracticeAllConcepts.kt
 * Practice problem: Calculate weekly earnings of a freelancer with optional bonus.
 * Uses val/var, numeric types, string handling, null safety, type inference, and smart casts.
 */

fun main() {
    println("💼 Freelancer Weekly Earning Calculator")

    // STEP 1: Declare constants and variables
    val hourlyRate = 50.0              // val (immutable)
    var hoursWorked = 40               // var (mutable)
    val bonusNote: String? = "100"     // nullable input (simulate user entry)

    // STEP 2: Calculate base pay
    val baseEarning = hourlyRate * hoursWorked

    // STEP 3: Convert bonus (nullable string) to Double with safety
    val bonus: Double = try {
        bonusNote?.toDouble() ?: 0.0
    } catch (e: NumberFormatException) {
        0.0
    }

    // STEP 4: Final earnings
    val totalEarning = baseEarning + bonus

    // STEP 5: Print result with string interpolation
    println("🧾 You worked $hoursWorked hours at $$hourlyRate/hr")
    println("✅ Bonus included: $${bonus}")
    println("💰 Total Earnings: $${"%.2f".format(totalEarning)}")
}
