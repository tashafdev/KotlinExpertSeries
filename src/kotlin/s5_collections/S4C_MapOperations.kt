package kotlin.s5_collections

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 5C: Map Operations
    📦 Package: kotlin.s5_collections
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - Creating immutable & mutable maps
    - Adding, updating, and removing entries
    - Accessing keys and values
    - Map iteration
    - Transformations: filter, mapValues, mapKeys
    - Grouping into maps
    - Best practices

    ---------------------------------------------------------------------------
    🗂️ What is a Map?
    ----------------------------------------------------------------------------
    - A collection of key-value pairs.
    - Keys are unique, values can be duplicates.
    - Two types:
        - `mapOf(...)` (immutable)
        - `mutableMapOf(...)` (mutable)

    ---------------------------------------------------------------------------
    📘 Basic Operations
    ----------------------------------------------------------------------------
    ✅ Create:
        val codes = mapOf(\"IN\" to \"India\", \"AE\" to \"UAE\")

    ✅ Access:
        codes[\"IN\"] → \"India\"

    ✅ Add/Update:
        val mutable = mutableMapOf(\"A\" to 1)
        mutable[\"B\"] = 2  // Add
        mutable[\"A\"] = 99 // Update

    ✅ Remove:
        mutable.remove(\"B\")

    ✅ Keys/Values:
        map.keys → Set
        map.values → Collection

    ---------------------------------------------------------------------------
    🔄 Iteration
    ----------------------------------------------------------------------------
    for ((key, value) in map) {
        println(\"$key → $value\")
    }

    ---------------------------------------------------------------------------
    🔁 Map Transformations
    ----------------------------------------------------------------------------
    ✅ mapValues:
        val updated = scores.mapValues { it.value + 10 }

    ✅ mapKeys:
        val upperKeys = scores.mapKeys { it.key.uppercase() }

    ✅ filter:
        val passed = scores.filter { it.value > 50 }

    ✅ groupBy:
        val names = listOf(\"Ali\", \"Tina\", \"Tom\")
        names.groupBy { it.first() }

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Prefer immutable `mapOf` unless mutation is needed
    - Use transformations like `mapValues`, `filter` instead of manual loops
    - For lookup-heavy structures, use maps instead of lists
    ---------------------------------------------------------------------------
*/


fun main() {
    // ✅ Immutable Map
    val countryCodes = mapOf("IN" to "India", "AE" to "UAE", "US" to "USA")
    println("Country Codes: $countryCodes")
    println("IN = ${countryCodes["IN"]}")

    // ✅ Mutable Map
    val scores = mutableMapOf("Tashy" to 95, "Dev" to 80)
    scores["AI"] = 88
    scores["Dev"] = 90 // update
    println("Scores Map: $scores")

    // ✅ Removing
    scores.remove("AI")
    println("After remove: $scores")

    // ✅ Keys and values
    println("Keys: ${scores.keys}")
    println("Values: ${scores.values}")

    // ✅ Iteration
    println("Map Entries:")
    for ((user, score) in scores) {
        println("$user → $score")
    }

    // ✅ Filtering
    val topScorers = scores.filter { it.value > 85 }
    println("Top Scorers: $topScorers")

    // ✅ Transform values
    val bonusScores = scores.mapValues { it.value + 5 }
    println("Bonus Scores: $bonusScores")

    // ✅ Transform keys
    val upperNames = scores.mapKeys { it.key.uppercase() }
    println("Uppercase Keys: $upperNames")

    // ✅ Group by logic
    val people = listOf("Tina", "Ali", "Tim", "Daisy")
    val groupedByFirstLetter = people.groupBy { it.first() }
    println("Grouped Names: $groupedByFirstLetter")
}
