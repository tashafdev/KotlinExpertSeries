/**
 * -----------------------------------------------------
 * ✅ Lecture: Observer Pattern (Behavioral)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * The Observer Pattern defines a one-to-many dependency between objects,
 * so that when one object changes state, all its dependents are notified and updated automatically.
 *
 * 📦 Use Case:
 * - Event-driven systems
 * - Data-binding
 * - UI updates from data/state changes
 *
 * 🧠 Why use it?
 * - Promotes loose coupling
 * - Enables reactive programming
 *
 * -----------------------------------------------------
 * 🧪 Example: News Agency and Subscribers
 * -----------------------------------------------------
 */

interface Observer {
    fun update(news: String)
}

class NewsAgency {
    private val observers = mutableListOf<Observer>()

    fun subscribe(observer: Observer) {
        observers.add(observer)
    }

    fun unsubscribe(observer: Observer) {
        observers.remove(observer)
    }

    fun notifyNews(news: String) {
        for (observer in observers) {
            observer.update(news)
        }
    }
}

class EmailSubscriber(private val name: String) : Observer {
    override fun update(news: String) {
        println("📧 $name received news: $news")
    }
}

fun main() {
    val agency = NewsAgency()

    val alice = EmailSubscriber("Alice")
    val bob = EmailSubscriber("Bob")

    agency.subscribe(alice)
    agency.subscribe(bob)

    agency.notifyNews("Kotlin 2.0 Released!")
}

/*
 * -----------------------------------------------------
 * 📱 Observer Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ LiveData (ViewModel → UI):
 *    - ViewModel holds LiveData.
 *    - Activities or Fragments observe changes and auto-update UI.
 *
 * ✅ Kotlin Flow / StateFlow:
 *    - StateFlow represents a single source of truth, and UI observes it via `collect { }`.
 *    - Common in MVVM and unidirectional data flow (UDF).
 *
 * ✅ BroadcastReceiver:
 *    - Acts as an observer to system-wide events (e.g., battery low, airplane mode).
 *
 * ✅ ContentObserver:
 *    - Used to observe changes in content providers (e.g., SMS, Contacts).
 *
 * ✅ RxJava Observable / Flowable:
 *    - Multiple subscribers can observe streams emitted over time.
 *
 * 🔹 Use this pattern when:
 *    - You want to build reactive, decoupled components that respond to state or event changes.
 */


