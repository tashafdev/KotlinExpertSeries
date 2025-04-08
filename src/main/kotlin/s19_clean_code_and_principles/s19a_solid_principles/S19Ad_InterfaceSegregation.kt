package s19_clean_code_and_principles.s19a_solid_principles


/*
 * -----------------------------------------------------
 * ✅ SOLID Principle: Interface Segregation Principle (ISP)
 * -----------------------------------------------------
 * ISP = Clients **should not be forced to depend** on interfaces
 * they **do not use**.
 *
 * Break large interfaces into smaller, more specific ones.
 * This avoids bloated implementations and improves code clarity.
 */

/*
 * 📌 Section 1 — ❌ Violation: Fat interface with unrelated responsibilities
 */
interface Worker {
    fun work()
    fun eat()
    fun sleep()
}

class RobotWorker : Worker {
    override fun work() {
        println("🤖 Robot working")
    }

    override fun eat() {
        // ❌ Robots don't eat — unnecessary method
        println("⚠️ Robot does not eat")
    }

    override fun sleep() {
        // ❌ Robots don't sleep either
        println("⚠️ Robot does not sleep")
    }
}

fun section1_ISPViolation() {
    val robot = RobotWorker()
    robot.work()
    robot.eat()
    robot.sleep()
}

/*
 * 📌 Section 2 — ✅ ISP-Compliant: Split interfaces by behavior
 */
interface Workable {
    fun work()
}

interface Eatable {
    fun eat()
}

interface Sleepable {
    fun sleep()
}

class HumanWorker : Workable, Eatable, Sleepable {
    override fun work() = println("👨‍💼 Human working")
    override fun eat() = println("🍱 Human eating")
    override fun sleep() = println("💤 Human sleeping")
}

class ImprovedRobot : Workable {
    override fun work() = println("🤖 Improved robot working only")
}

fun section2_ISPCompliantDesign() {
    val human = HumanWorker()
    val robot = ImprovedRobot()

    human.work()
    human.eat()
    human.sleep()

    robot.work()
    // ✅ No irrelevant method calls like eat() or sleep()
}

/*
 * 🧠 What You Will Learn:
 * - What makes an interface too fat
 * - Why splitting interfaces improves modularity
 * - How to design role-based interfaces
 */

/*
 * 🚀 Quick Summary:
 * ✅ ISP = Interface should only expose what is needed
 * ✅ Break up multipurpose interfaces into smaller chunks
 * ✅ Clients implement only what they need
 */

/*
 * 📘 Key Takeaways:
 * - Fat interfaces cause boilerplate and misuse
 * - Fewer, smaller interfaces = more focused, readable code
 * - Works great with modern Kotlin and dependency injection

 * 💡 Real-World Use Cases:
 * - UI lifecycle interfaces (onStart, onResume, etc.)
 * - Feature-based interfaces for UseCases
 * - Clean separation in Repository/Service contracts

 * 🧼 Clean Code Insight:
 * If a class says “not implemented” or throws inside an interface method —
 * that interface is **too big**. Break it up.
 */
