package javaArgorithmInterview._4_queue_stack


class MyQueue {
    val queue = ArrayDeque<Int>()

    fun push(x: Int) {
        queue.addLast(x)
    }

    fun peek(): Int? {
        return queue.firstOrNull()
    }

    fun pop(): Int {
        return queue.removeFirst()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }
}

fun main() {
    val queue = MyQueue()

    queue.push(1)
    queue.push(2)
    queue.push(3)

    println(queue.peek())
    println(queue.pop())
    println(queue.empty())
}
