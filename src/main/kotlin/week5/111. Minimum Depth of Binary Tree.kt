package week5

import week1.TreeNode
import java.util.*

fun minDepth(root: TreeNode?): Int {
    val queue = ArrayDeque<TreeNode?>()

    var depth = 0

    if (root == null)
        return 0
    else depth++

    queue.offer(root)

    while (queue.isNotEmpty()) {
        for (i in 0 until queue.size) {
            val node = queue.poll()
            if (node?.left == null && node?.right == null)
                return depth
            node?.left?.let { queue.offer(it) }
            node?.right?.let { queue.offer(it) }
        }
        depth++
    }

    return depth
}