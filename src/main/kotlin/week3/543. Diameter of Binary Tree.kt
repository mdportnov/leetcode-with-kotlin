package week3

import week1.TreeNode
import java.lang.Integer.max

var max = 0

fun diameterOfBinaryTree(root: TreeNode?): Int {
    maxDepth(root)
    return max
}

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0

    val left = maxDepth(root.left)
    val right = maxDepth(root.right)
    max = max(max, left + right)

    return max(left, right) + 1
}