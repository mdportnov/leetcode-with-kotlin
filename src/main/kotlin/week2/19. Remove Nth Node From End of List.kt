package week2

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)

//    println(removeNthFromEnd(head, 2))
    println(removeNthFromEnd(head, 2))
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head?.next == null) {
        return null
    }

    var fast = head
    var slow = head

    repeat(n) {
        fast = fast?.next
    }

    if (fast == null)
        return head.next

    while (fast?.next != null) {
        fast = fast?.next
        slow = slow?.next
    }

    slow?.next = slow?.next?.next
    return head
}