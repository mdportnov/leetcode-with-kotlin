package week2

import java.util.*

class MyQueue(
    var x: Int = 0,
) {
    val behind = Stack<Int>()
    val top = Stack<Int>()

    fun push(x: Int) {
        top.push(x)
    }

    fun pop(): Int {
        if (top.isNotEmpty())
            while (top.isNotEmpty())
                behind.push(top.pop())

        if (behind.isNotEmpty())
            x = behind.pop()

        while (behind.isNotEmpty())
            top.push(behind.pop())

        return x
    }

    fun peek(): Int {
        if (top.isNotEmpty())
            while (top.isNotEmpty())
                behind.push(top.pop())

        if (behind.isNotEmpty())
            x = behind.peek()

        while (behind.isNotEmpty())
            top.push(behind.pop())

        return x
    }

    fun empty(): Boolean {
        if (top.isEmpty())
            return true
        return false
    }
}