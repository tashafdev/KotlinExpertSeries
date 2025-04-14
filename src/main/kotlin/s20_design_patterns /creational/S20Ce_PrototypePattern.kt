/**
 * -----------------------------------------------------
 * ✅ Lecture: Prototype Pattern (Creational)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Prototype Pattern allows you to create new objects by copying
 * an existing object, known as the prototype.
 *
 * 📦 Use Case:
 * - When object creation is costly
 * - To duplicate complex structures (e.g., deep copies)
 *
 * 🧠 Why use it?
 * - Improves performance (no need to re-create)
 * - Useful when many identical objects are needed
 *
 * -----------------------------------------------------
 * 🧪 Example: Cloning a Shape
 * -----------------------------------------------------
 */

interface Shape : Cloneable {
    public override fun clone(): Shape
    fun draw()
}

class Circle(var radius: Int) : Shape {
    override fun clone(): Shape = Circle(radius)
    override fun draw() = println("🟠 Drawing a circle with radius $radius")
}

class Rectangle(var width: Int, var height: Int) : Shape {
    override fun clone(): Shape = Rectangle(width, height)
    override fun draw() = println("🟦 Drawing a rectangle ${width}x$height")
}

fun main() {
    val originalCircle = Circle(10)
    val copiedCircle = originalCircle.clone()
    copiedCircle.draw()

    val originalRect = Rectangle(5, 7)
    val copiedRect = originalRect.clone()
    copiedRect.draw()
}

/*
 * -----------------------------------------------------
 * 📱 Real-World Usage in Android – Prototype Pattern
 * -----------------------------------------------------
 *
 * 🔹 Bitmap.copy():
 *    - Used to duplicate a `Bitmap` with the same pixel data but independent memory.
 *    - Avoids recreating a new Bitmap from scratch, which is costly.
 *
 * 🔹 View cloning in Custom Layout Editors:
 *    - Tools or internal frameworks may duplicate UI elements by copying base views.
 *
 * 🔹 Object.deepCopy() (custom model duplication):
 *    - You might clone data classes to avoid modifying the original instance.
 *    - Useful in undo/redo operations or diffing.
 *
 * 🔹 Animation or Drawable Templating:
 *    - A prototype of an animated drawable or vector is cloned and reused.
 *
 * 🔹 Google ML Kit / MediaPipe:
 *    - In advanced SDKs, cloning preprocessed data like image frames, detection metadata can avoid recomputation.
 *
 * ✅ Use Prototype Pattern when:
 *    - You need to **clone existing objects** (especially costly ones).
 *    - You want to ensure the **new object has the same structure/state**, but is a separate instance.
 */

