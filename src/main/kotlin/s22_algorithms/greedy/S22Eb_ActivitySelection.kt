package s22_algorithms.greedy

/*
 * -----------------------------------------------------
 * 📚 Lecture: Activity Selection (S22Eb_ActivitySelection.kt)
 * -----------------------------------------------------
 * Activity Selection:
 * - Given a set of activities each with a start and end time,
 *   select the maximum number of non‑overlapping activities.
 * - Greedy strategy: always pick the activity that finishes earliest.
 *
 * Time Complexity: O(n log n) due to sorting by end times
 * Space Complexity: O(n) for result list and sorting auxiliary space
 *
 * This lecture covers:
 * 1️⃣ Problem definition & greedy choice property
 * 2️⃣ Kotlin data class & sorting
 * 3️⃣ Greedy selection implementation
 * 4️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Define an Activity with name, start, and end times
data class Activity(val name: String, val start: Int, val end: Int)

/**
 * 2️⃣ Selects the maximum set of non‑overlapping activities.
 *  - Sort activities by increasing end time.
 *  - Iterate and pick each activity whose start >= last selected end.
 */
fun selectActivities(activities: List<Activity>): List<Activity> {
    if (activities.isEmpty()) return emptyList()

    // Sort by finish time
    val sorted = activities.sortedBy { it.end }
    val result = mutableListOf<Activity>()

    // Always pick the first (earliest finishing) activity
    var lastEnd = sorted.first().end
    result += sorted.first()

    // Iterate remaining activities
    for (i in 1 until sorted.size) {
        val activity = sorted[i]
        if (activity.start >= lastEnd) {
            result += activity
            lastEnd = activity.end
        }
    }
    return result
}

// 3️⃣ Demo in main()
fun main() {
    println("\n✅ Activity Selection Demo")

    val activities = listOf(
        Activity("A", start = 1, end = 4),
        Activity("B", start = 3, end = 5),
        Activity("C", start = 0, end = 6),
        Activity("D", start = 5, end = 7),
        Activity("E", start = 8, end = 9),
        Activity("F", start = 5, end = 9)
    )

    println("All activities:")
    activities.forEach { println("  → ${it.name}: [${it.start}, ${it.end})") }

    val selected = selectActivities(activities)
    println("\nSelected activities:")
    selected.forEach { println("  → ${it.name}: [${it.start}, ${it.end})") }
}

/*
 * 🔍 Android Use Cases:
 * - **Notification Scheduling:** Choose non‑conflicting notifications to display.
 * - **WorkManager Tasks:** Schedule background jobs so they don’t overlap time windows.
 * - **Calendar Event Views:** Display maximum non‑overlapping events in a day‑view UI.
 * - **UI Animation Queues:** Sequence animations without temporal overlap for smooth UX.
 * - **Resource Allocation:** Assign threads or workers to time slots without conflict.
 *
 * 🔟 Summary:
 * ✅ Greedy choice: pick earliest finishing activity to leave room for others.
 * ✅ Sorting by end time is key—gives O(n log n) performance.
 * ✅ Result list is maximal and optimal for this problem.
 * ✅ Widely applicable to any scheduling or interval‑selection tasks.
 */
