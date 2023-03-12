package week1

import java.util.*

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */

fun main() {
    println(isValid("{}"))
    println(isValid("()(){}"))
    println(isValid("(()){}"))
    println(isValid("(({)){}"))
    println(isValid("(([()[]]"))
    println(isValid("]"))
    println(isValid("[])"))
}

fun isValid(s: String): Boolean {
    var flag = true
    val chars = s.toCharArray()
    val stack = Stack<Char>()

    if (s.startsWith('}') || s.startsWith(')') || s.startsWith(']'))
        flag = false

    chars.forEach { ch ->
        if (ch == '{' || ch == '(' || ch == '[') {
            stack.add(ch)
        } else if (stack.empty()) {
            flag = false
        } else if ((ch == '}' || ch == ')' || ch == ']')) {
            val opening = stack.pop()
            if (opening == '{' && ch == '}' || (opening == '(' && ch == ')')
                || (opening == '[' && ch == ']')
            )
                return@forEach
            else
                flag = false
        }
    }
    return flag && stack.empty()
}

// {}()
// Stack: {