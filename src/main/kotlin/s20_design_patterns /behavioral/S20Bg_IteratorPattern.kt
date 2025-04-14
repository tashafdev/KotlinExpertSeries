
/**
 * -----------------------------------------------------
 * ✅ Lecture: Iterator Pattern (Behavioral)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Iterator Pattern provides a way to access elements of a collection
 * sequentially without exposing its internal structure.
 *
 * 📦 Use Case:
 * - Custom collections
 * - Lazy iteration
 * - Abstracting traversal logic
 *
 * 🧠 Why use it?
 * - Encapsulates collection structure
 * - Supports multiple iteration strategies
 * - Promotes single responsibility
 *
 * -----------------------------------------------------
 * 🧪 Example: NameCollection with Custom Iterator
 * -----------------------------------------------------
 */

interface NameIteratorPattern {
    fun hasNext(): Boolean
    fun next(): String
}

class NameCollection(private val names: List<String>) {
    fun createIterator(): NameIteratorPattern = NameListIterator(names)
}

class NameListIterator(private val names: List<String>) : NameIteratorPattern {
    private var index = 0

    override fun hasNext(): Boolean = index < names.size

    override fun next(): String = names[index++]
}

fun main() {
    val collection = NameCollection(listOf("Tashy", "Sarah", "Imran"))
    val iterator = collection.createIterator()

    while (iterator.hasNext()) {
        println("👤 Name: ${iterator.next()}")
    }
}


/*
 * -----------------------------------------------------
 * 📱 Iterator Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ Cursor (from ContentProvider):
 *    - Cursor allows sequential access to DB rows using `moveToNext()`, `getColumnIndex()`.
 *    - Classic Android iterator pattern.

 * ✅ RecyclerView.Adapter:
 *    - Iterates through a dataset to bind views at specific positions.

 * ✅ Kotlin Collections:
 *    - `forEach`, `map`, `filter` — all use Kotlin’s built-in `iterator()` under the hood.

 * ✅ Sequence and Flow:
 *    - Kotlin `Sequence` lazily iterates over elements.
 *    - `Flow` emits elements over time and can be collected one by one.

 * ✅ Paging 3 Library:
 *    - Loads chunks of data incrementally — acts like a paginated iterator.

 * 🔹 Use this pattern when:
 *    - You want to **iterate over a collection without exposing its structure**.
 *    - You want to support **lazy or controlled iteration** (especially for large data sets).
 */
