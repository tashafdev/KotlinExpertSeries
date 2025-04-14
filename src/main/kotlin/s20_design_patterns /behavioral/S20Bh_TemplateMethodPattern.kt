/**
 * -----------------------------------------------------
 * ✅ Lecture: Template Method Pattern (Behavioral)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Template Method Pattern defines the skeleton of an algorithm in a base class,
 * while allowing subclasses to override specific steps without changing the algorithm's structure.
 *
 * 📦 Use Case:
 * - Workflow orchestration
 * - Algorithms with fixed structure but variable steps
 *
 * 🧠 Why use it?
 * - Promotes code reuse
 * - Enforces consistent process flow
 * - Encourages extension without modification
 *
 * -----------------------------------------------------
 * 🧪 Example: Report Generation Template
 * -----------------------------------------------------
 */

abstract class ReportTemplate {

    fun generateReport() {
        prepareData()
        formatContent()
        export()
    }

    protected abstract fun prepareData()
    protected abstract fun formatContent()

    protected open fun export() {
        println("📝 Exporting report as PDF")
    }
}

class SalesReport : ReportTemplate() {
    override fun prepareData() {
        println("📊 Preparing sales data")
    }

    override fun formatContent() {
        println("🧾 Formatting sales report")
    }
}

class InventoryReport : ReportTemplate() {
    override fun prepareData() {
        println("📦 Fetching inventory details")
    }

    override fun formatContent() {
        println("📋 Formatting inventory report")
    }

    override fun export() {
        println("📁 Exporting inventory report as Excel file")
    }
}

fun main() {
    val sales = SalesReport()
    val inventory = InventoryReport()

    sales.generateReport()
    inventory.generateReport()
}

/*
 * -----------------------------------------------------
 * 📱 Template Method Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ Activity / Fragment Lifecycle:
 *    - Android framework defines the lifecycle (`onCreate`, `onStart`, `onResume`, etc.).
 *    - You override only the steps relevant to your logic — the lifecycle "template" is fixed.

 * ✅ RecyclerView.Adapter:
 *    - The Adapter class defines fixed methods like `onCreateViewHolder`, `onBindViewHolder`, `getItemCount`.
 *    - You override steps to customize item rendering.

 * ✅ Base Classes in MVVM Architecture:
 *    - BaseActivity/BaseFragment might define `setupUI()`, `observeViewModel()`, `initListeners()` and call them in order from `onCreate()`.

 * ✅ View Binding or UI Setup Flow:
 *    - Common pattern in custom views or fragments where setup steps are fixed but customizable per screen.

 * 🔹 Use this pattern when:
 *    - You want to **enforce an execution sequence**, but allow specific steps to be overridden.
 *    - You want to **promote code reuse** across screens or components.
 */
