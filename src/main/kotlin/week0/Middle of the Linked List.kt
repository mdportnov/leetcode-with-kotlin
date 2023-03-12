package week0

var list = ListNode(5)

class ListNode(var value: Int) {
    var next: ListNode? = null
}

fun middleNode(head: ListNode?): ListNode? {
    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}
