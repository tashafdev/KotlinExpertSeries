package s21_data_structures.trees


/*
 * -----------------------------------------------------
 * ✅ Lecture: Trie Implementation (S21De_TrieImplementation.kt)
 * -----------------------------------------------------
 *
 * 📌 A Trie (also called Prefix Tree) is a specialized tree used to store
 *     a set of strings where each node represents a character of a word.
 *
 * 🔤 Key Features:
 * - Fast prefix-based searching
 * - Efficient memory for large word sets
 *
 * ✅ Operations:
 * - insert(word): O(n)
 * - search(word): O(n)
 * - startsWith(prefix): O(n)
 *
 * 📦 Common Use Cases:
 * - Autocomplete / search suggestions
 * - Spell checkers
 * - Word games
 * - Dictionary-based apps
 */

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEndOfWord: Boolean = false
}

class S21De_Trie {
    private val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (char in word) {
            node = node.children.getOrPut(char) { TrieNode() }
        }
        node.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (char in word) {
            node = node.children[char] ?: return false
        }
        return node.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for (char in prefix) {
            node = node.children[char] ?: return false
        }
        return true
    }
}

fun main() {
    val trie = S21De_Trie()
    trie.insert("apple")
    trie.insert("app")
    trie.insert("bat")

    println("🔍 Search Results:")
    println("Search 'app' → ${trie.search("app")}")       // true
    println("Search 'appl' → ${trie.search("appl")}")     // false
    println("Prefix 'ap' → ${trie.startsWith("ap")}")     // true
    println("Prefix 'ba' → ${trie.startsWith("ba")}")     // true
}


/*
 * -----------------------------------------------------
 * 📱 Trie in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ Autocomplete Fields:
 *    - Fast real-time suggestions in search bars, filters, or forms.

 * ✅ Dictionary or Language Apps:
 *    - Quick lookup of definitions or translations using word prefixes.

 * ✅ Contact Search:
 *    - Efficient prefix-based matching in contact apps (e.g., T9-like input).

 * ✅ Input Prediction:
 *    - Keyboard apps (like GBoard, SwiftKey) use Trie to suggest next words.

 * ✅ Smart Search Filters:
 *    - Used in note-taking, shopping, or document apps to offer quick results.

 * ✅ Word Games:
 *    - Useful in Boggle, Scrabble, Wordle clones for validating words.

 * 🔹 Use Trie when:
 *    - You need fast lookup by prefix
 *    - You have a large set of strings and want optimal search performance
 */
