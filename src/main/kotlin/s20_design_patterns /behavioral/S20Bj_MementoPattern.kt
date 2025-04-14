/**
 * -----------------------------------------------------
 * ✅ Lecture: Memento Pattern (Behavioral)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Memento Pattern captures and externalizes an object's internal state
 * so that it can be restored later without violating encapsulation.
 *
 * 📦 Use Case:
 * - Undo/redo functionality
 * - Snapshot saving
 * - Temporary state rollback
 *
 * 🧠 Why use it?
 * - Enables restoration of previous states
 * - Keeps object internals private
 * - Useful for UI, editors, or workflows
 *
 * -----------------------------------------------------
 * 🧪 Example: TextEditor with Undo
 * -----------------------------------------------------
 */

data class EditorMemento(val content: String)

class TextEditor {
    private var content: String = ""

    fun write(text: String) {
        content += text
    }

    fun createMemento(): EditorMemento = EditorMemento(content)

    fun restore(memento: EditorMemento) {
        content = memento.content
    }

    fun printContent() {
        println("📄 Current Content: $content")
    }
}

class HistoryManager {
    private val history = mutableListOf<EditorMemento>()

    fun save(memento: EditorMemento) {
        history.add(memento)
    }

    fun undo(): EditorMemento? {
        if (history.isNotEmpty()) {
            history.removeLast()
            return history.lastOrNull()
        }
        return null
    }
}

fun main() {
    val editor = TextEditor()
    val history = HistoryManager()

    editor.write("Hello")
    history.save(editor.createMemento())

    editor.write(", World!")
    history.save(editor.createMemento())

    editor.printContent() // Hello, World!

    val lastSaved = history.undo()
    if (lastSaved != null) editor.restore(lastSaved)

    editor.printContent() // Hello
}

/*
 * -----------------------------------------------------
 * 📱 Memento Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ TextEditor or Drawing Apps:
 *    - Maintain a history of states to support Undo/Redo.

 * ✅ onSaveInstanceState() / ViewModel SavedStateHandle:
 *    - Used to save and restore UI state during configuration changes or process death.

 * ✅ Form Drafts:
 *    - Snapshot of form input saved in memory or database so user can come back and continue.

 * ✅ Navigation Component SavedStateHandle:
 *    - Stores screen states across destinations and restores automatically.

 * ✅ Snapshot APIs (Compose):
 *    - Compose uses snapshot state that can be saved/restored.

 * 🔹 Use this pattern when:
 *    - You want to **save and restore an object’s state safely**.
 *    - You’re building features like **undo, redo, drafts, or temporary rollback**.
 */



