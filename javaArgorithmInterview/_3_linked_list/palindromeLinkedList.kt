package javaArgorithmInterview._3_linked_list

import java.util.Deque
import java.util.LinkedList

fun isPalindrome(head: ListNode?): Boolean {
    val deque: Deque<Int> = LinkedList()

    var node = head

    while (node != null) {
        deque.add(node.value)
        node = node.next
    }

    while (deque.isNotEmpty() && deque.size > 1) {
        if (deque.pollFirst() != deque.pollLast()) {
            return false
        }
    }

    return true
}


fun main() {
    val input = ListNode(value = 1)
        .apply { next = ListNode(value = 2)
            .apply { next = ListNode(value = 3)
                .apply { next = ListNode(value = 3)
                    .apply { next = ListNode(value = 2)
                        .apply { next = ListNode(value = 1) }
                    }
                }
            }
        }

    println(isPalindrome(input))
}
