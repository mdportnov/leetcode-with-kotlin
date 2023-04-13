package week5

import java.util.*

class MinStack() {
    private val stack = Stack<Int>()
    private val minHeap = PriorityQueue<Int>()
//    private val maxHeap = PriorityQueue<Int>(Collections.reverseOrder()) // for Max Stack

    fun push(value: Int) {
        stack.push(value)
        minHeap.offer(value)
    }

    fun pop() {
        val removed = stack.pop()
        minHeap.remove(removed)
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minHeap.peek()
    }
}