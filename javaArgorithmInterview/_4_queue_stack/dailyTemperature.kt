package javaArgorithmInterview._4_queue_stack

fun dailyTemperature(temperatures: IntArray): IntArray {
    val result = IntArray(temperatures.size)
    val stack = ArrayDeque<Int>()

    for (i in temperatures.indices) {
        while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
            val last = stack.removeLast()
            result[last] = i - last
        }

        stack.addLast(i)
    }

    return result
}

fun main() {
    val input = intArrayOf(23, 24, 25, 21, 19, 22, 26, 23)
    val result = dailyTemperature(input)

    for (a in result) {
        print(a)
    }
    // 1 1 4 2 1 1 0 0
}
