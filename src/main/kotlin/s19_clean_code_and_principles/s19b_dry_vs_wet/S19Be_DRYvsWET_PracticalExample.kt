package s19_clean_code_and_principles.s19b_dry_vs_wet


/**
 * S19Be_DRYvsWET_PracticalExample.kt
 * Problem: You’re building a billing system that prints receipts.
 * Show the WET version (duplicated logic) and refactor to DRY.
 */

fun runS19Be_DRYvsWETExample() {
    println("💸 WET Version Output:")
    S19Be_BillingSystemWET().printReceipt("Alice", 120.0)
    S19Be_BillingSystemWET().printReceipt("Bob", 99.99)

    println("\n✅ DRY Version Output:")
    val printer = S19Be_ReceiptPrinter()
    S19Be_BillingSystemDRY(printer).printReceipt("Alice", 120.0)
    S19Be_BillingSystemDRY(printer).printReceipt("Bob", 99.99)
}

// 🔹 WET Version — duplicate logic in every function
class S19Be_BillingSystemWET {
    fun printReceipt(customerName: String, amount: Double) {
        println("Customer: $customerName")
        println("Total: $amount")
        println("Printed at: ${System.currentTimeMillis()}")
        println("------------------------------")
    }
}

// 🔹 DRY Version — logic extracted into reusable printer class
class S19Be_ReceiptPrinter {
    fun print(customerName: String, amount: Double) {
        println("Customer: $customerName")
        println("Total: $amount")
        println("Printed at: ${System.currentTimeMillis()}")
        println("------------------------------")
    }
}

class S19Be_BillingSystemDRY(private val printer: S19Be_ReceiptPrinter) {
    fun printReceipt(customerName: String, amount: Double) {
        printer.print(customerName, amount)
    }
}
