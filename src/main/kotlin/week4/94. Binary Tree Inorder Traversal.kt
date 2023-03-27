package week4

import week1.TreeNode
import java.util.*

val list = mutableListOf<Int>()

fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root != null) {
        inorderTraversal(root.left)
        list.add(root.`val`)
        inorderTraversal(root.right)
    }
    return list
}

fun inorderTraversalWithStack(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    var tmp = root
    if (root == null) return list
    val stack = Stack<TreeNode>()

    while (tmp != null || stack.isNotEmpty()) {
        while (tmp != null) {
            stack.push(tmp)
            tmp = tmp.left
        }

        tmp = stack.pop()
        list.add(tmp.`val`)
        tmp = tmp.right
    }
    return list
}
