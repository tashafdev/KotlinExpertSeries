/**
 * -----------------------------------------------------
 * ✅ Lecture: Flyweight Pattern (Structural)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * The Flyweight Pattern minimizes memory usage by sharing as much data as possible
 * with similar objects — used when many similar objects are needed efficiently.
 *
 * 📦 Use Case:
 * - Rendering thousands of lightweight objects (icons, particles, emojis)
 * - Caching heavy shared resources
 *
 * 🧠 Why use it?
 * - Reduces memory footprint
 * - Improves performance in high-volume object use
 *
 * -----------------------------------------------------
 * 🧪 Example: S20Sg Icon Factory (Flyweight)
 * -----------------------------------------------------
 */

interface S20Sg_Icon {
    fun draw(x: Int, y: Int)
}

class S20Sg_ConcreteIcon(private val type: String) : S20Sg_Icon {
    override fun draw(x: Int, y: Int) {
        println("🎯 Drawing $type icon at ($x, $y)")
    }
}

object S20Sg_IconFactory {
    private val icons = mutableMapOf<String, S20Sg_Icon>()

    fun getIcon(type: String): S20Sg_Icon {
        return icons.getOrPut(type) {
            println("📦 Creating new icon for type: $type")
            S20Sg_ConcreteIcon(type)
        }
    }
}

fun main() {
    val locations = listOf(1 to 2, 3 to 4, 5 to 6)

    for ((x, y) in locations) {
        val treeIcon = S20Sg_IconFactory.getIcon("Tree")
        treeIcon.draw(x, y)
    }

    val houseIcon = S20Sg_IconFactory.getIcon("House")
    houseIcon.draw(10, 20)
}


/*
 * -----------------------------------------------------
 * 📱 Flyweight Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ Emoji & Font Rendering:
 *    - Emojis, glyphs, and fonts are reused across messages or views instead of creating new ones.

 * ✅ RecyclerView ViewHolder Reuse:
 *    - Uses flyweight pattern to recycle view objects — only updates visible items.

 * ✅ Drawable Caching:
 *    - Image and vector drawables are cached and reused to save memory.

 * ✅ Span & TextStyle Pools:
 *    - Text styling (Bold, Italic, Underline, etc.) often uses flyweight spans reused across text.

 * ✅ Bitmap Pools (Glide):
 *    - Glide reuses Bitmaps via `BitmapPool` to avoid re-allocating memory.

 * ✅ Typeface.createFromAsset():
 *    - Uses internal caching to prevent reloading the same font from disk.

 * 🔹 Use this pattern when:
 *    - You need to **render or reuse many similar lightweight objects**.
 *    - You want to **optimize performance and memory usage**.
 */

