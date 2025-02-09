package javaArgorithmInterview._5_deque_and_priority_queue

import javaArgorithmInterview.ListNode
import java.util.PriorityQueue

fun mergeKSortedLists(lists: Array<ListNode?>): ListNode? {
    val pq = PriorityQueue<ListNode> { o1, o2 ->
        when {
            o1.value == o2.value -> 0
            o1.value > o2.value -> 1
            else -> -1
        }
    }

    val root = ListNode(0)

    var tail = root

    for (node in lists) {
        if (node != null)
            pq.add(node)
    }


    while (pq.isNotEmpty()) {
        tail.next = pq.poll()
        tail = tail.next!!

        if (tail.next != null)
            pq.add(tail.next)
    }

    return root.next
}

fun main() {
    val input = arrayOf(
        ListNode(value = 1)
            .apply { next = ListNode(value = 4)
                .apply { next = ListNode(value = 5) }
            },
        ListNode(value = 1)
            .apply { next = ListNode(value = 3)
                .apply { next = ListNode(value = 4) }
            },
        ListNode(value = 2)
            .apply { next = ListNode(value = 7) },
        null
    )

    var result = mergeKSortedLists(input)

    while (result != null) {
        println(result.value)

        result = result.next
    }
}
