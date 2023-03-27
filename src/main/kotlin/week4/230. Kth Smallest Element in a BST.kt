package week4

import week1.TreeNode
import java.util.*

var count = 0
var res = 0

fun kthSmallest(root: TreeNode, k: Int): Int {
    count = k
    dfs(root)
    return res
}

fun dfs(root: TreeNode?) {
    if (root == null)
        return

    dfs(root.left)
    count--
    if (count == 0) {
        res = root.`val`
        return
    }
    dfs(root.right)
}

fun kthSmallestWithStack(root: TreeNode?, k: Int): Int {
    val stack = Stack<TreeNode>()
    var tmp = root
    var count = k
    while (tmp != null || stack.isNotEmpty()) {
        while (tmp != null) {
            stack.push(tmp)
            tmp = tmp.left
        }
        tmp = stack.pop()
        if (--count == 0) break
        tmp = tmp.right
    }

    return tmp?.`val` ?: -1
}