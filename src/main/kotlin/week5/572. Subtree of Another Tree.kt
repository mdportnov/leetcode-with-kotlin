package week5

import week1.TreeNode
import java.util.*

fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (isEqualTree(root, subRoot)) return true
    return if (root == null) false else isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
}

private fun isEqualTree(root1: TreeNode?, root2: TreeNode?): Boolean {
    return if (root1 == null || root2 == null) root2 === root1
    else root1.`val` == root2.`val` && isEqualTree(root1.left, root2.left) && isEqualTree(root1.right, root2.right)
}

/**
 * For each node during pre-order traversal
 * of s, use a recursive function isSame to validate
 * if sub-tree started with this node is the same with t.
 */
fun isSubtree2(s: TreeNode?, t: TreeNode?): Boolean {
    val nodes: Queue<TreeNode> = LinkedList()
    nodes.offer(s)
    while (!nodes.isEmpty()) {
        val node: TreeNode = nodes.poll()
        if (isSameTree2(node, t)) {
            return true
        }
        if (node.left != null) {
            nodes.offer(node.left)
        }
        if (node.right != null) {
            nodes.offer(node.right)
        }
    }
    return false
}

fun isSameTree2(s: TreeNode?, t: TreeNode?): Boolean {
    if (s == null && t == null) return true
    if (s == null || t == null) return false
    return if (s.`val` != t.`val`) {
        false
    } else {
        isSameTree2(s.left, t.left) && isSameTree2(s.right, t.right)
    }
}