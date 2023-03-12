package week1

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */

var ti = TreeNode(5)
var v = ti.`val`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null)
            return null

        val tmp = root.left
        root.left = root.right
        root.right = tmp

        invertTree(root.left)
        invertTree(root.right)

        return root
    }
}