/**
 * -----------------------------------------------------
 * ✅ Lecture: Adapter Pattern (Structural)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * The Adapter Pattern allows incompatible interfaces to work together
 * by converting one interface into another expected by the client.
 *
 * 📦 Use Case:
 * - Integrating with legacy code or third-party APIs
 * - Bridging between mismatched interfaces
 *
 * 🧠 Why use it?
 * - Promotes code reuse and flexibility
 * - Makes integration smoother
 * - Helps you work with external or legacy APIs
 *
 * -----------------------------------------------------
 * 🧪 Example: Media Player Adapter
 * -----------------------------------------------------
 */

interface AudioPlayer {
    fun play(filename: String)
}

class MP3Player : AudioPlayer {
    override fun play(filename: String) {
        println("▶️ Playing MP3 file: $filename")
    }
}

class VLCPlayer {
    fun startVLCPlayback(file: String) {
        println("🎵 Playing VLC file: $file")
    }
}

class VLCAdapter(private val vlcPlayer: VLCPlayer) : AudioPlayer {
    override fun play(filename: String) {
        vlcPlayer.startVLCPlayback(filename)
    }
}

fun main() {
    val mp3 = MP3Player()
    mp3.play("song.mp3")

    val vlc = VLCAdapter(VLCPlayer())
    vlc.play("video.vlc")
}


/*
 * -----------------------------------------------------
 * 📱 Adapter Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ RecyclerView.Adapter:
 *    - Adapts a list of data into visual item views using ViewHolder.
 *    - Converts a data model into UI elements = classic adapter usage.

 * ✅ View Binding Adapters (with Data Binding or Compose):
 *    - BindingAdapters act as adapters to convert or apply data to UI in XML/Compose.

 * ✅ Retrofit Converter Factories:
 *    - Convert server responses (JSON, XML) to Kotlin objects.
 *    - E.g., Moshi/Gson converters adapt raw JSON to data classes.

 * ✅ ListAdapter vs BaseAdapter:
 *    - Both adapt data to different list UIs — ListAdapter optimizes diffing.

 * ✅ Custom Layout Inflaters:
 *    - Adapters help reuse layouts across view types.

 * 🔹 Use this pattern when:
 *    - You need to **integrate incompatible APIs or bridge logic and UI**.
 *    - You’re converting one structure or format into another required by a system.
 */

