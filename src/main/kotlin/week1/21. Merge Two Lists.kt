package week1

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        val sb = StringBuilder()
        var tmp = this
        while (tmp.next != null) {
            sb.append("${tmp.`val`} ")
            tmp = tmp.next!!
        }

        sb.append("${tmp.`val`} ")
        return sb.toString()
    }
}

fun main() {
    val li = ListNode(1)
    li.next = ListNode(2)
    li.next!!.next = ListNode(4)

    val li2 = ListNode(1)
    li2.next = ListNode(3)
    li2.next!!.next = ListNode(4)

    val m = mergeTwoLists(li, li2)
    println(m)
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null)
        return list2
    if (list2 == null)
        return list1

    var head: ListNode?
    var ptr1 = list1
    var ptr2 = list2

    if (ptr1.`val` > ptr2.`val`) {
        head = ptr2
        ptr2 = ptr2.next
    } else {
        head = ptr1
        ptr1 = ptr1.next
    }

    var tail = head

    while (ptr1 != null && ptr2 != null) {
        if (ptr1.`val` < ptr2.`val`) {
            tail?.next = ptr1
            ptr1 = ptr1.next
        } else {
            tail?.next = ptr2
            ptr2 = ptr2.next
        }
        tail = tail?.next
    }

    if (ptr1 != null) {
        tail?.next = ptr1
    } else
        tail?.next = ptr2

    return head
}

// 1 3 5 6
// 3 4 5
// Tail: 1 3
