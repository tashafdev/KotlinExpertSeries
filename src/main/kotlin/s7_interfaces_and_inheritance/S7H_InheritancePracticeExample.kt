package s7_interfaces_and_inheritance


/**
 * S7H_InheritancePracticeExample.kt
 * Real-world example: Smart Home Device System.
 * Demonstrates interfaces, abstract classes, inheritance, visibility modifiers, and polymorphism.
 */

fun runS7H_InheritanceExample() {
    println("🏠 Smart Home System Starting...\n")

    val light = S7H_LightBulb("Living Room Light")
    val fan = S7H_CeilingFan("Bedroom Fan")

    val devices: List<S7H_Device> = listOf(light, fan)
    for (device in devices) {
        device.turnOn()
        device.turnOff()
        println()
    }

    val controller = S7H_SmartController()
    controller.logDeviceStatus(light)
}

// 🔹 Interface
interface S7H_Device {
    val name: String
    fun turnOn()
    fun turnOff()
}

// 🔹 Abstract class
abstract class S7H_SmartDevice(override val name: String) : S7H_Device {
    protected fun statusLog(action: String) {
        println("[$name] $action")
    }
}

// 🔹 Inheriting classes
class S7H_LightBulb(name: String) : S7H_SmartDevice(name) {
    override fun turnOn() = statusLog("💡 Light turned ON")
    override fun turnOff() = statusLog("💡 Light turned OFF")
}

class S7H_CeilingFan(name: String) : S7H_SmartDevice(name) {
    override fun turnOn() = statusLog("🌀 Fan spinning")
    override fun turnOff() = statusLog("🌀 Fan stopped")
}

// 🔹 Multiple inheritance (interface + class)
interface S7H_Loggable {
    fun log(message: String)
}

class S7H_SmartController : S7H_Loggable {
    override fun log(message: String) = println("🧠 Controller Log: $message")

    fun logDeviceStatus(device: S7H_Device) {
        log("Checked device: ${device.name}")
    }
}
