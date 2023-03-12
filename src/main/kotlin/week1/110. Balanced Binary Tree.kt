package week1

import kotlin.math.abs

/**
 * Given a binary tree, determine if it is
 * height-balanced
 */

fun isBalanced(root: TreeNode?): Boolean {
    if (root == null)
        return true
    val l = isBalanced(root.left)
    val r = isBalanced(root.right)

    val lht = height(root.left)
    val rht = height(root.right)
    if (abs(lht - rht) >= 2) {
        return false
    }
    return l && r
}

fun height(root: TreeNode?): Int {
    if (root == null)
        return -1
    return maxOf(height(root.left), height(root.right)) + 1
}
