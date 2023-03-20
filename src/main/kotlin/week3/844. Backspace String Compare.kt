package week3

import java.util.*

fun backspaceCompare(s: String, t: String): Boolean {
    return buildStack(s) == buildStack(t)
}

fun buildStack(str: String): Stack<Char> {
    val stack = Stack<Char>()
    for (c in str) {
        if (c != '#') {
            stack.push(c)
        } else if (stack.isNotEmpty())
            stack.pop()
    }
    return stack
}
