package javaArgorithmInterview._4_queue_stack

fun validParentheses(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    val table = mapOf(
        ')' to '(',
        '}' to '{',
        ']' to '['
    )

    for (i in s.indices) {
        if (!table.containsKey(s[i])) {
            stack.addLast(s[i])
        } else if (stack.isEmpty() || table[s[i]] != stack.removeLast()) {
            return false
        }
    }

    return stack.size == 0
}

fun main() {
    val input1 = "[]{}()"
    println(validParentheses(input1))

    val input2 = "[]{(})"
    println(validParentheses(input2))
}
