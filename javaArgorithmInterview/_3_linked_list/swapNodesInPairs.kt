package javaArgorithmInterview._3_linked_list

import javaArgorithmInterview.ListNode

fun swapNodesInPairs(head: ListNode?): ListNode? {
    if (head?.next != null) {
        val p = head.next!!
        head.next = swapNodesInPairs(head.next!!.next)
        p.next = head
        return p
    }

    return head
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

    var result = swapNodesInPairs(input)
    while (result != null) {
        println(result.value)

        result = result.next
    }
    // 2 -> 1 -> 4 -> 3 -> 6 -> 5
}
