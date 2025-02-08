package javaArgorithmInterview._5_deque_and_priority_queue

class MyCircularDeque(val k: Int) {
    data class DoublyLinkedList(var value: Int) {
        var left: DoublyLinkedList? = null
        var right: DoublyLinkedList? = null
    }

    var len = 0
    var head: DoublyLinkedList? = null
    var tail: DoublyLinkedList? = null

    init {
        head = DoublyLinkedList(0)
        tail = DoublyLinkedList(0)

        head!!.right = tail
        tail!!.left = head

    }

    fun insertFront(value: Int): Boolean {
        if (isFull()) return false

        val node = DoublyLinkedList(value)
        node.right = head!!.right
        node.left = head
        head!!.right!!.left = node
        head!!.right = head

        len++

        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isFull()) return false

        val node = DoublyLinkedList(value)
        node.left = tail!!.left
        node.right = tail
        tail!!.left!!.right = node
        tail!!.left = node

        len++

        return true
    }

    fun deleteFront(): Boolean {
        if (isEmpty()) return false

        head!!.right!!.right!!.left = head
        head!!.right = head!!.right!!.right

        len--

        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) return false

        tail!!.left!!.left!!.right = tail
        tail!!.left = tail!!.left!!.left

        len--

        return true
    }

    fun getFront(): Int {
        return if (isEmpty()) -1 else head!!.right!!.value
    }

    fun getRear(): Int {
        return if (isEmpty()) -1 else tail!!.left!!.value
    }

    fun isEmpty(): Boolean {
        return len == 0
    }

    fun isFull(): Boolean {
        return k == len
    }
}

fun main() {
    val circularDeque = MyCircularDeque(5)

    println(circularDeque.insertFront(10)) // T
    println(circularDeque.insertLast(20)) // T
    println(circularDeque.insertLast(30)) // T
    println(circularDeque.insertLast(40)) // T
    println(circularDeque.insertFront(0)) // F

    println(circularDeque.deleteLast()) // T
    println(circularDeque.getFront()) // 0
    println(circularDeque.getRear()) // 30

    println(circularDeque.deleteFront()) // T
    println(circularDeque.deleteLast()) // T

    println(circularDeque.getFront()) // 0
    println(circularDeque.getRear()) // 20


    println(circularDeque.isFull()) // F
    println(circularDeque.isEmpty()) // F
}
