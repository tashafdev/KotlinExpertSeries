package s12_advanced_topics


/*
 * -----------------------------------------------------
 * ✅ Kotlin Advanced — Building DSLs (Domain Specific Languages)
 * -----------------------------------------------------
 * DSL = A readable, expressive syntax tailored to a specific domain.
 * Kotlin is PERFECT for building internal DSLs due to:
 * 🔹 Lambdas with receiver
 * 🔹 Extension functions
 * 🔹 Operator overloading
 */

/*
 * 📌 Section 1 — Basic DSL Example
 */
class HtmlTag(val name: String) {
    private val children = mutableListOf<HtmlTag>()

    fun tag(name: String, block: HtmlTag.() -> Unit) {
        val child = HtmlTag(name).apply(block)
        children.add(child)
    }

    fun render(indent: String = ""): String {
        val inner = children.joinToString("\n") { it.render("$indent  ") }
        return "$indent<$name>\n$inner\n$indent</$name>"
    }
}

fun html(block: HtmlTag.() -> Unit): HtmlTag {
    return HtmlTag("html").apply(block)
}

fun s12e_buildMiniHtmlDsl() {
    val result = html {
        tag("head") {
            tag("title") {}
        }
        tag("body") {
            tag("h1") {}
            tag("p") {}
        }
    }
    println(result.render())
}

/*
 * 📌 Section 2 — Kotlin Libraries that Use DSLs
 */
fun s12e_realWorldDslExamples() {
    println(
        """
        🔍 Kotlin DSLs in the wild:

        ✅ Jetpack Compose
        ✅ kotlinx.html
        ✅ Gradle Kotlin DSL (build.gradle.kts)
        ✅ SQLDelight / Exposed
        ✅ Anko (legacy)
        ✅ Arrow Meta (FP DSLs)

        DSL = readable, declarative, and safe APIs.
        """.trimIndent()
    )
}

/*
 * 🧠 What You Will Learn:
 * - How DSLs make code expressive and declarative
 * - How to build DSLs using lambdas with receivers
 * - Real-world DSL patterns in Compose and Gradle

 * 🚀 Quick Summary:
 * ✅ DSLs = Custom Kotlin syntax for specific tasks
 * ✅ Use lambdas with receiver, `apply`, and extensions
 * ✅ Avoid overcomplicating – prioritize clarity

 * 💡 Real-World Use Cases:
 * - UI frameworks (Jetpack Compose)
 * - HTML builders
 * - Gradle, build scripts
 * - SQL or configuration DSLs

 * 🧼 Clean Code Insight:
 * DSLs can turn cluttered APIs into beautiful code.
 * Use them where **readability > reusability**.
 */
