package javaArgorithmInterview._4_queue_stack

import java.util.LinkedList

class MyStack {
    val queue = LinkedList<Int>()
    fun push(value: Int) {
        queue.addFirst(value)
    }

    fun pop(): Int {
        return queue.removeFirst()
    }

    fun top(): Int? {
        return queue.peek()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }
}

fun main() {
    val stack = MyStack()

    stack.push(1)
    stack.push(2)
    stack.push(3)

    println(stack.top()) // 3
    println(stack.pop()) // 3
    println(stack.empty()) // false
}
