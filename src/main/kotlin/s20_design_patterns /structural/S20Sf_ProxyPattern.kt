
/**
 * -----------------------------------------------------
 * ✅ Lecture: Proxy Pattern (Structural)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Proxy Pattern provides a surrogate or placeholder for another object
 * to control access to it — useful for lazy loading, access control, logging, caching, etc.
 *
 * 📦 Use Case:
 * - Control access to a real object
 * - Add extra logic before/after real object usage
 *
 * 🧠 Why use it?
 * - Adds structure around real object usage
 * - Enables lazy creation, permission checks, logging
 * - Keeps the real subject untouched
 *
 * -----------------------------------------------------
 * 🧪 Example: S20Sf Image Proxy Loader
 * -----------------------------------------------------
 */

interface S20Sf_Image {
    fun display()
}

class S20Sf_RealImage(private val filename: String) : S20Sf_Image {
    init {
        loadFromDisk()
    }

    private fun loadFromDisk() {
        println("📂 Loading image: $filename from disk...")
    }

    override fun display() {
        println("🖼️ Displaying image: $filename")
    }
}

class S20Sf_ImageProxy(private val filename: String) : S20Sf_Image {
    private var realImage: S20Sf_RealImage? = null

    override fun display() {
        if (realImage == null) {
            realImage = S20Sf_RealImage(filename)
        }
        realImage?.display()
    }
}

fun main() {
    val image = S20Sf_ImageProxy("profile_picture.png")
    println("Image created... but not loaded yet.")

    image.display() // Loads and displays
    image.display() // Only displays (already loaded)
}


/*
 * -----------------------------------------------------
 * 📱 Proxy Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ Glide / Coil / Picasso:
 *    - Image loading libraries act as proxies for Bitmaps.
 *    - Load lazily, cache results, and manage transformations.

 * ✅ Room Lazy Relations (`@Relation`):
 *    - Room handles child entities lazily — actual DB access is deferred until needed.

 * ✅ WorkManager Enqueue Proxy:
 *    - Wrappers around real `Worker` classes manage execution, retries, constraints.

 * ✅ ViewModel Mocking:
 *    - During testing, proxy ViewModels simulate the real ones with predictable behavior.

 * ✅ Permission Wrappers:
 *    - Some apps wrap functionality to check permissions before actual execution.

 * ✅ Retrofit API Services:
 *    - The service interface is proxied by Retrofit using dynamic proxy generation.

 * 🔹 Use this pattern when:
 *    - You need to **control access, add caching/lazy logic, or abstract execution** of a real object.
 */
