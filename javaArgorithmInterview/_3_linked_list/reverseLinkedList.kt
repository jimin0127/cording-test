package javaArgorithmInterview._3_linked_list

import javaArgorithmInterview.ListNode

fun reverseLinkedList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var node = head

    while (node != null) {
        val next = node.next
        node.next = prev
        prev = node
        node = next
    }

    return prev
}


fun main() {
    val input = ListNode(value = 1)
        .apply { next = ListNode(value = 2)
            .apply { next = ListNode(value = 3)
                .apply { next = ListNode(value = 4)
                    .apply { next = ListNode(value = 5)
                        .apply { next = ListNode(value = 6) }
                    }
                }
            }
        }

    var result = reverseLinkedList(input)
    while (result != null) {
        println(result.value)

        result = result.next
    }
    // 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
}
