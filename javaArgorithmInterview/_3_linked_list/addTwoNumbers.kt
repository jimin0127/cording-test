package javaArgorithmInterview._3_linked_list

import javaArgorithmInterview.ListNode

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1var = l1
    var l2var = l2

    var node = ListNode(0)

    val root = node

    var sum: Int
    var carry = 0
    var remainder: Int

    while (l1var != null || l2var != null || carry != 0) {
        sum = 0
        if (l1var != null) {
            sum += l1var.value
            l1var = l1var.next
        }

        if (l2var != null) {
            sum += l2var.value
            l2var = l2var.next
        }

        remainder = (sum + carry) % 10
        carry = (sum + carry) / 10
        node.next = ListNode(remainder)
        node = node.next!!
    }

    return root.next
}

fun main() {
    // (2 -> 4 -> 3) + (5 -> 6 -> 2) = 7 -> 0 -> 6
    // 342 + 265 = 607

    val list1 = ListNode(value = 2)
        .apply { next = ListNode(value = 4)
            .apply { next = ListNode(value = 3)
            }
        }

    val list2 = ListNode(value = 5)
        .apply { next = ListNode(value = 6)
            .apply { next = ListNode(value = 2)
            }
        }

    var result = addTwoNumbers(list1, list2)
    while (result != null) {
        println(result.value)

        result = result.next
    }
}
