package javaArgorithmInterview._1_string

fun mostCommonWord1(p: String, banned: Array<String>): String {
    val counts = mutableMapOf<String, Int>()
    val words = p.replace("\\W+".toRegex(), " ").lowercase().trim().split(" ")

    for (word in words) {
        if (!banned.contains(word)) {
            counts[word] = counts.getOrDefault(word, 0) + 1
        }
    }

    return counts.maxBy { it.value }.key
}

fun mostCommonWord2(p: String, banned: Array<String>): String {
    val counts = mutableMapOf<String, Int>()
    val words = p
        .replace("\\W+".toRegex(), " ")
        .lowercase()
        .trim()
        .split(" ")
        .filter { !banned.contains(it) }

    for (word in words) {
        counts[word] = counts.getOrDefault(word, 0) + 1
    }

    return counts.maxBy { it.value }.key
}

fun main() {
    val paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit."
    val banned = arrayOf("hit")

    println(mostCommonWord1(paragraph, banned)) // ball
    println(mostCommonWord2(paragraph, banned))
}
