package week2

var li = ListNode(5)
var v = li.`val`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
//        val hashMap = mutableMapOf<Int, ListNode>()
        var slowPtr = head
        var fastPtr = head?.next
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next!!.next
            slowPtr = slowPtr?.next
            if (slowPtr == fastPtr)
                return true
        }
        return false
    }

    fun hasCycleWithMap(head: ListNode?): Boolean {
        val hashMap = mutableMapOf<ListNode, Int>()
        var ptr = head
        while (ptr != null) {
            if (hashMap.containsKey(ptr))
                return true
            else
                hashMap[ptr] = 1
            ptr = ptr.next
        }
        return false
    }
}