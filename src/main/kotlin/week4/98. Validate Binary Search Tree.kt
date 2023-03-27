package week4

import week1.TreeNode
import java.util.*

fun isValidBST(root: TreeNode?): Boolean {
    if (root == null)
        return true

    val stack = Stack<TreeNode>()
    var tmp = root
    var pre: TreeNode? = null

    while (tmp != null || stack.isNotEmpty()) {
        while (tmp != null) {
            stack.push(tmp)
            tmp = tmp.left
        }

        tmp = stack.pop()
        if ((pre != null) && (tmp.`val` <= pre.`val`))
            return false

        pre = tmp
        tmp = tmp.right
    }

    return true
}