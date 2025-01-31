package javaArgorithmInterview._3_linked_list

fun oddEvenLinkedList(head: ListNode?): ListNode? {
    if (head == null) return null

    var odd = head!!
    var even = head.next
    val evenHead = even

    while (even?.next != null) {
        odd.next = odd.next?.next
        even.next = even.next?.next

        odd = odd.next!!
        even = even.next
    }
    odd.next = evenHead
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
    var result = oddEvenLinkedList(input)
    while (result != null) {
        println(result.value)

        result = result.next
    }
    // 1 -> 3 -> 5 -> 2 -> 4 -> 6
}
