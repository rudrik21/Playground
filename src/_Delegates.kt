import kotlin.properties.Delegates

fun main() {

//    var d1 = DelegatedLevel(1, "Rudrik")
//    d1.unlocked = true
//    println(DelegatedLevel.highestLevel)
//    var d2 = DelegatedLevel(2, "Rudrik")
//    d2.unlocked = true
//    println(DelegatedLevel.highestLevel)


    val light = LightBulb()
    light.current = 50
//    println(light.current)
    var current = light.current // 0
    light.current = 40
    current = light.current // 40
//    println(light.current)
}

class DelegatedLevel(val id: Int, var boss: String) {
    companion object {
        var highestLevel = 1
    }

    var unlocked: Boolean by Delegates.observable(false) { _, old, new ->
        if (new && id > highestLevel) {
            highestLevel = id
        }
        println("$old -> $new")
    }
}

class LightBulb {
    companion object {
        const val maxCurrent = 40
    }

    var current by Delegates.vetoable(0) { _, _, new ->
        if (new > maxCurrent) {
            println("Current too high, falling back to previous setting.")
            false
        } else {
            true
        }
    }
}