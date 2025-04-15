package s21_data_structures.hashing


/*
 * -----------------------------------------------------
 * ✅ Lecture: HashSet and Collision Concept (S21Cb_HashSetAndCollision.kt)
 * -----------------------------------------------------
 * A HashSet is a collection of unique elements.
 * Internally, it uses a HashMap where the value is just a dummy object.
 * Collisions occur when two different objects produce the same hash bucket.
 */

fun main() {
    println("\n✅ HashSet & Collision Concept Demo")

    // 1️⃣ Create a HashSet
    val names = hashSetOf("Alice", "Bob", "Charlie")
    println("Initial HashSet: $names")

    // 2️⃣ Attempting to add duplicates
    names.add("Bob")
    names.add("Alice")
    println("After attempting duplicates: $names") // No change

    // 3️⃣ Adding new unique elements
    names.add("David")
    println("After adding David: $names")

    // 4️⃣ How HashSet handles uniqueness
    println("\n✔️ HashSet uses hashCode() + equals() to ensure uniqueness")
    println("✔️ Collisions are handled internally using chaining or probing")

    // 5️⃣ Visual example of collision
    println("\nSimulated Collision Example")
    val badHashSet = HashSet<BadHash>()
    badHashSet.add(BadHash("One"))
    badHashSet.add(BadHash("Two"))
    badHashSet.add(BadHash("Three"))
    println("BadHashSet size (should be 3): ${badHashSet.size}")

    for (element in badHashSet) println(element.data)
}

// 6️⃣ Class with deliberately bad hashCode (simulating collisions)
class BadHash(val data: String) {
    override fun hashCode(): Int = 42
    override fun equals(other: Any?): Boolean =
        other is BadHash && other.data == this.data
}

/*
 * 🔍 Real-World Use Cases:
 * - Maintaining unique tags, user IDs, or visited states
 * - Fast membership tests (e.g., visited nodes in graphs)
 * - Data deduplication
 *
 * 🔟 Summary:
 * ✅ HashSet ensures unique values via hashCode + equals
 * ✅ Internally backed by a HashMap with dummy values
 * ✅ Collisions are possible but resolved internally
 * ✅ Poor hashCode implementations reduce performance
 */


/*
 * -----------------------------------------------------
 * 📱 HashSet in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ Unique User IDs in Chat:
 *    - Track which users have joined a group or read a message without duplicates.
 *
 * ✅ Permission Checks:
 *    - Maintain a set of granted runtime permissions to avoid repeated requests.
 *
 * ✅ Visited Screens Tracking:
 *    - Record which onboarding or tutorial screens a user has seen.
 *
 * ✅ Unique Tags in Note Apps:
 *    - Manage a user’s set of tags or categories without repetition.
 *
 * ✅ Input Validation:
 *    - Check for duplicate entries in forms (e.g., unique email addresses).
 *
 * 🔹 Use HashSet when:
 *    - You need to enforce uniqueness with average O(1) add/contains.
 *    - Order is irrelevant and duplicates must be prevented.
 */
