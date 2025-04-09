package s6_classes_and_objects



/**
 * S6I_ClassesPracticeExample.kt
 * Real-world example: Movie Ticketing System
 * Safe and scoped version with unique names for this section.
 */

fun runS6I_PracticeExample() {
    println("🎬 Welcome to ${S6I_AppSettings.cinemaName}")

    val user = S6I_User("Tashy", 28)
    val ticket = S6I_Ticket.generate(user.name, S6I_Movie.AVATAR, S6I_SeatType.PREMIUM)
    ticket.printDetails()

    println("🎟️ Booking Status: ${S6I_BookingStatus.Confirmed.message}")
    println("🌙 Dark mode enabled: ${S6I_AppSettings.darkModeEnabled}")

    val screen = S6I_Screen(1)
    screen.Controller().control()
    S6I_Screen.Info().display()
}

// 🔹 Class with properties and methods
class S6I_User(val name: String, var age: Int)

// 🔹 Enum for movies
enum class S6I_Movie {
    AVATAR, INCEPTION, INTERSTELLAR
}

// 🔹 Data class for Ticket
data class S6I_Ticket(val userName: String, val movie: S6I_Movie, val seat: S6I_SeatType) {
    fun printDetails() {
        println("🎟️ $userName booked $movie - ${seat.description}")
    }

    companion object {
        fun generate(name: String, movie: S6I_Movie, seat: S6I_SeatType): S6I_Ticket {
            return S6I_Ticket(name, movie, seat)
        }
    }
}

// 🔹 Enum class for seat types
enum class S6I_SeatType(val description: String) {
    REGULAR("Regular Seat"),
    PREMIUM("Premium Seat"),
    VIP("VIP Seat with Recliner")
}

// 🔹 Sealed class to model booking status
sealed class S6I_BookingStatus(val message: String) {
    object Confirmed : S6I_BookingStatus("✅ Booking confirmed")
    object Cancelled : S6I_BookingStatus("❌ Booking cancelled")
    object Pending : S6I_BookingStatus("⏳ Awaiting confirmation")
}

// 🔹 Singleton object for settings
object S6I_AppSettings {
    val cinemaName = "Kotlin Cineplex"
    var darkModeEnabled = true
}

// 🔹 Nested & inner class example
class S6I_Screen(val number: Int) {
    class Info {
        fun display() = println("ℹ️ Static info about screen (no outer access)")
    }

    inner class Controller {
        fun control() = println("🎮 Controlling screen #$number")
    }
}

