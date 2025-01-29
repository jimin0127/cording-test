package javaArgorithmInterview._3_linked_list

fun mergeTwoSortedLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    return if (list1.value < list2.value) {
        list1.next = mergeTwoSortedLists(list1.next, list2)

        list1
    } else {
        list2.next = mergeTwoSortedLists(list1, list2.next)

        list2
    }

}

fun main() {
    val list1 = ListNode(value = 1)
        .apply { next = ListNode(value = 2)
            .apply { next = ListNode(value = 5)
            }
        }

    val list2 = ListNode(value = 1)
        .apply { next = ListNode(value = 3)
            .apply { next = ListNode(value = 4)
            }
        }


    var result = mergeTwoSortedLists(list1, list2)
    while (result != null) {
        println(result.value)

        result = result.next
    }
    // 1 -> 1 -> 2 -> 3 -> 4 -> 5 -> null
}


