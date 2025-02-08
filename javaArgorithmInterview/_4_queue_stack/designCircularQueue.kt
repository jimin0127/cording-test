package javaArgorithmInterview._4_queue_stack

class MyCircularQueue(k: Int) {
    val q = IntArray(k)
    var front = 0
    var rear = -1
    var len = 0



    fun front(): Int {
        return if (q.isNotEmpty()) {
            q[front]
        } else {
            -1
        }
    }

    fun rear(): Int {
        return if (q.isNotEmpty()) {
            return q[rear]
        } else {
            -1
        }
    }



    fun enQueue(x: Int): Boolean {
        if (isFull()) return false

        rear = (rear + 1) % q.size
        q[rear] = x
        len++

        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false

        front = (front + 1) % q.size
        len--

        return true
    }

    fun isFull(): Boolean {
        return q.size == len
    }

    private fun isEmpty(): Boolean {
        return q.isEmpty()
    }
}


fun main() {
    val circularQueue = MyCircularQueue(5)

    println(circularQueue.enQueue(10)) // T
    println(circularQueue.enQueue(20)) // T
    println(circularQueue.enQueue(30)) // T
    println(circularQueue.enQueue(40)) // T
    println(circularQueue.enQueue(50)) // T
    println(circularQueue.enQueue(60)) // F
    println(circularQueue.rear()) // 50
    println(circularQueue.isFull()) // T
    println(circularQueue.deQueue()) // T
    println(circularQueue.deQueue()) // T
    println(circularQueue.front()) // 30
    println(circularQueue.rear()) // 50
    println(circularQueue.enQueue(50)) // T
    println(circularQueue.enQueue(60)) // T
    println(circularQueue.deQueue()) // T
    println(circularQueue.front()) // 40
    println(circularQueue.rear()) // 60
    println(circularQueue.enQueue(70)) // T
    println(circularQueue.isFull()) // T
}
