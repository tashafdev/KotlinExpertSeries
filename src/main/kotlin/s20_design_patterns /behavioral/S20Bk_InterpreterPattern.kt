
/**
 * -----------------------------------------------------
 * ✅ Lecture: Interpreter Pattern (Behavioral)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * The Interpreter Pattern defines a grammar for a language and provides an interpreter
 * to evaluate sentences in that language.
 *
 * 📦 Use Case:
 * - Parsing expressions
 * - Scripting or rule engines
 * - Command or input language processing
 *
 * 🧠 Why use it?
 * - Encapsulates parsing logic cleanly
 * - Enables reusable and testable interpreters for expression languages
 *
 * -----------------------------------------------------
 * 🧪 Example: Simple Math Expression Interpreter
 * -----------------------------------------------------
 */

interface Expression {
    fun interpret(): Int
}

class NumberExpression(private val number: Int) : Expression {
    override fun interpret(): Int = number
}

class AddExpression(private val left: Expression, private val right: Expression) : Expression {
    override fun interpret(): Int = left.interpret() + right.interpret()
}

class SubtractExpression(private val left: Expression, private val right: Expression) : Expression {
    override fun interpret(): Int = left.interpret() - right.interpret()
}

fun main() {
    // Equivalent to: (5 + 3) - 2
    val expression = SubtractExpression(
        AddExpression(NumberExpression(5), NumberExpression(3)),
        NumberExpression(2)
    )

    println("🧮 Result: ${expression.interpret()}") // 6
}


/*
 * -----------------------------------------------------
 * 📱 Interpreter Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ Input Validation DSLs:
 *    - Building expression trees for dynamic form validation logic.
 *    - Example: `AND`, `OR`, `NOT` rules combined using interpreter pattern.

 * ✅ Search Query Parsing:
 *    - Converting user-friendly search filters into query objects or SQL/Room filters.

 * ✅ Command Processors:
 *    - Parsing commands in chat bots, shell-like UIs, or terminal apps.

 * ✅ Expression Evaluation:
 *    - Used in custom scripting engines (e.g., calculator apps, quiz apps with logic).

 * ✅ Rule Engines / Business Workflows:
 *    - Use interpreter to evaluate business rules on runtime data (e.g., reward eligibility, promo checks).

 * 🔹 Use this pattern when:
 *    - You want to interpret or evaluate a **custom grammar or syntax tree**.
 *    - You’re building **expressive, rule-based, or scriptable components**.
 */
