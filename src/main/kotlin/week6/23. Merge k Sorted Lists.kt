package week6

import week0.ListNode
import java.util.*

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val pq = PriorityQueue<ListNode> { o1, o2 -> o1.value - o2.value }

    for (list in lists) {
        if (list != null) {
            pq.offer(list)
        }
    }

    var result: ListNode? = null
    var current: ListNode? = null

    while (pq.isNotEmpty()) {
        val node = pq.poll()
        if (result == null) {
            result = node
            current = result
        } else {
            current?.next = node
            current = current?.next
        }
        if (node?.next != null)
            pq.offer(node.next)
    }

    return result
}