package week5

import week1.TreeNode
import java.util.*

fun rightSideView(root: TreeNode?): List<Int> {
    if (root == null)
        return listOf()

    val queue = ArrayDeque<TreeNode>()
    queue.offer(root)
    val result = mutableListOf<Int>()

    while (queue.isNotEmpty()) {
        val levelSize = queue.size

        for (i in 0 until levelSize) {
            val node = queue.poll()
            node?.left?.let { queue.offer(it) }
            node?.right?.let { queue.offer(it) }
            if (i == levelSize - 1)
                result.add(node.`val`)
        }
    }

    return result
}