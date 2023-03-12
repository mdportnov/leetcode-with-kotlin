package week0


class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1 = l1
        var l2 = l2
        val dummyHead = ListNode(0)
        var curr: ListNode? = dummyHead
        var carry = 0
        while (l1 != null || l2 != null || carry != 0) {
            val x = l1?.value ?: 0
            val y = l2?.value ?: 0
            val sum = carry + x + y
            carry = sum / 10
            curr!!.next = ListNode(sum % 10)
            curr = curr.next
            if (l1 != null) l1 = l1.next
            if (l2 != null) l2 = l2.next
        }
        return dummyHead.next
    }
}