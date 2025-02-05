package javaArgorithmInterview._4_queue_stack

fun removeDeplicateLetters(s: String): String {
    val counter = hashMapOf<Char, Int>()
    val seen = hashMapOf<Char, Boolean>()
    val stack = ArrayDeque<Char>()

    for (c in s) {
        counter[c] = counter.getOrDefault(c, 0) + 1
    }

    for (c in s) {
        counter[c] = counter[c]!! - 1

        if (seen[c] == true) continue

        while (!stack.isEmpty() && stack.first() > c && counter[stack.first()]!! > 0)
            seen[stack.removeLast()] = false

        stack.addLast(c)
        seen[c] = true
    }

    val sb = StringBuilder()
    while (!stack.isEmpty())
        sb.append(stack.removeFirst())
    return sb.toString()
}

fun main() {
    val input = "dbacdcbc"

    println(removeDeplicateLetters(input)) // acdb

}
