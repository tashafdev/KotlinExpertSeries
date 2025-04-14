/**
 * -----------------------------------------------------
 * ✅ Lecture: Object Pool Pattern (Optional Creational)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Object Pool Pattern manages a set of reusable objects,
 * reusing them instead of creating new instances repeatedly.
 *
 * 📦 Use Case:
 * - Managing resources like database connections, bitmaps, threads, etc.
 * - When object creation is expensive or slow
 *
 * 🧠 Why use it?
 * - Saves memory
 * - Boosts performance
 * - Reduces GC pressure in high-performance systems
 *
 * ⚠️ Note:
 * - Requires careful handling to avoid leaks or reuse issues
 *
 * -----------------------------------------------------
 * 🧪 Example: Reusing Expensive `Worker` Objects
 * -----------------------------------------------------
 */

class Worker(val id: Int) {
    fun doWork(task: String) {
        println("👷 Worker #$id is processing: $task")
    }
}

class WorkerPool(private val maxSize: Int = 3) {
    private val availableWorkers = ArrayDeque<Worker>()
    private var createdCount = 0

    fun acquire(): Worker {
        return if (availableWorkers.isNotEmpty()) {
            availableWorkers.removeFirst()
        } else {
            createdCount++
            Worker(createdCount)
        }
    }

    fun release(worker: Worker) {
        if (availableWorkers.size < maxSize) {
            availableWorkers.addLast(worker)
        }
    }
}

fun main() {
    val pool = WorkerPool()

    val worker1 = pool.acquire()
    worker1.doWork("Task A")

    val worker2 = pool.acquire()
    worker2.doWork("Task B")

    pool.release(worker1)
    pool.release(worker2)

    val worker3 = pool.acquire()
    worker3.doWork("Task C") // May reuse worker1 or worker2
}



/*
 * -----------------------------------------------------
 * 📱 Real-World Usage in Android – Object Pool Pattern
 * -----------------------------------------------------
 *
 * 🔹 Bitmap Pooling (Glide / Coil / Picasso):
 *    - Libraries like Glide use object pooling to reuse Bitmaps and reduce memory churn.
 *    - `BitmapPool` ensures Bitmaps are reused instead of being constantly created/destroyed.
 *
 * 🔹 RecyclerView.ViewHolder Pooling:
 *    - `RecyclerView.RecycledViewPool` reuses ViewHolder instances across RecyclerViews.
 *    - Improves performance by avoiding view inflation overhead.
 *
 * 🔹 Camera & Media APIs:
 *    - Frame buffers and preview surfaces are reused in a pool for performance.
 *
 * 🔹 ThreadPoolExecutor (in Java/Kotlin coroutines):
 *    - Reuses threads instead of spawning new ones for every task.
 *
 * 🔹 CursorAdapter:
 *    - Cursor data objects are reused and updated rather than recreated.
 *
 * ✅ Use Object Pool Pattern when:
 *    - You are dealing with **expensive-to-create objects** (e.g., Bitmaps, threads, DB connections).
 *    - You want to **boost performance** and reduce memory pressure by reusing instances.
 */
