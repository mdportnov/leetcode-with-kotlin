package week5

import week1.TreeNode
import java.util.*

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null)
        return true
    return isSymmetricTree(root.left, root.right)
}

fun isSymmetricTree(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null || right == null)
        return left == right
    if (left.`val` != right.`val`)
        return false
    return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left)
}

fun nonRecIsSymmetric(root: TreeNode?): Boolean {
    if (root == null)
        return true

    val stack = Stack<TreeNode>()

    var left: TreeNode?
    var right: TreeNode?

    if (root.left != null) {
        if (root.right != null) {
            return false
        }
        stack.push(root.left)
        stack.push(root.right)
    } else if (root.right != null)
        return false

    while (stack.isNotEmpty()) {
        if (stack.size % 2 != 0)
            return false

        right = stack.pop()
        left = stack.pop()

        if (left.`val` != right.`val`)
            return false

        if (left.left != null) {
            if (right.right == null)
                return false
            stack.push(left.left)
            stack.push(right.right)
        } else if (right.right != null)
            return false

        if (left.right != null) {
            if (right.left == null) return false
            stack.push(left.right)
            stack.push(right.left)
        } else if (right.left != null)
            return false
    }

    return true
}
