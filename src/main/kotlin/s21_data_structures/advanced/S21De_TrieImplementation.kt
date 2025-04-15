package s21_data_structures.advanced

/*
 * -----------------------------------------------------
 * ✅ Lecture: Trie Implementation (S21De_TrieImplementation.kt)
 * -----------------------------------------------------
 * A Trie (prefix tree) is a tree-like data structure for efficient retrieval of strings.
 * Each node represents a character; paths from root form words.
 *
 * Key Operations:
 * - insert(word): Add a word into the trie.
 * - search(word): Return true if the word is in the trie.
 * - startsWith(prefix): Return true if any word starts with the prefix.
 */
// Source: S21De_TrieImplementation.kt citeturn4file1

// 1️⃣ Define TrieNode
class TrieNode {
    val children: MutableMap<Char, TrieNode> = mutableMapOf()
    var isEndOfWord: Boolean = false
}

// 2️⃣ Trie implementation
class S21DeTrieImplementation {
    private val root = TrieNode()

    // Insert a word into the trie
    fun insert(word: String) {
        var node = root
        for (ch in word) {
            node = node.children.getOrPut(ch) { TrieNode() }
        }
        node.isEndOfWord = true
    }

    // Search for exact word in the trie
    fun search(word: String): Boolean {
        var node = root
        for (ch in word) {
            node = node.children[ch] ?: return false
        }
        return node.isEndOfWord
    }

    // Check if any word starts with the given prefix
    fun startsWith(prefix: String): Boolean {
        var node = root
        for (ch in prefix) {
            node = node.children[ch] ?: return false
        }
        return true
    }
}

fun main() {
    println("\n✅ Trie Demo")
    val trie = S21DeTrieImplementation()
    val words = listOf("apple", "app", "bat", "batch")
    words.forEach { trie.insert(it) }
    println("search(\"app\"): ${trie.search("app")}   // true")
    println("search(\"apple\"): ${trie.search("apple")}   // true")
    println("search(\"bat\"): ${trie.search("bat")}   // true")
    println("search(\"bath\"): ${trie.search("bath")}   // false")
    println("startsWith(\"ba\"): ${trie.startsWith("ba")}   // true")
    println("startsWith(\"cat\"): ${trie.startsWith("cat")}   // false")
}

/*
 * 🔍 Android Use Cases:
 * - Autocomplete in Search Bars (SearchView, EditText suggestions)
 * - Dictionary or Translation Apps (prefix-based lookups)
 * - Contact Search (fast prefix matching)
 * - Keyboard Input Prediction (soft keyboards suggestion)
 * - Smart Filters in Note or Email Apps (filtering by prefix)
 *
 * 🔟 Summary:
 * ✅ Trie offers O(m) lookup where m is word length
 * ✅ Efficient for prefix-based searches
 * ✅ Ideal for autocomplete and word-based features
 */
