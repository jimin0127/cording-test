package javaArgorithmInterview._3_linked_list

fun reverseLinkedList2(head: ListNode?, left: Int, right: Int): ListNode? {
    if (head == null) return null

    val root = ListNode(0)
    root.next = head

    var start = root
    for (i in 0 until left - 1)
        start = start.next!!

    val end = start.next!!
    for (i in 0 until right - left) {
        val tmp = start.next
        start.next = end.next
        end.next = end.next?.next
        start.next?.next = tmp
    }

    return root.next
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

    val left = 2
    var right = 5

    var result = reverseLinkedList2(input, left, right)
    while (result != null) {
        println(result.value)

        result = result.next
    }
}
