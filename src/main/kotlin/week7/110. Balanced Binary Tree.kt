package week7

import week1.TreeNode

fun isBalanced(root: TreeNode?): Boolean {
    return isHeightBalancedHelper(root).first
}

fun isHeightBalancedHelper(node: TreeNode?) : Pair<Boolean, Int> {
    if(node==null)
        return Pair(true, 0)

    val left = isHeightBalancedHelper(node.left)
    val right = isHeightBalancedHelper(node.right)

    val isBalanced = left.first && right.first && Math.abs(left.second - right.second) <=1

    val height = Math.max(left.second, right.second) + 1

    return Pair(isBalanced, height)
}