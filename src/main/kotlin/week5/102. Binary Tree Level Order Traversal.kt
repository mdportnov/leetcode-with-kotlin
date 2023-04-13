package week5

import week1.TreeNode

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val listOfLists = mutableListOf<MutableList<Int>>()
    val queue = ArrayDeque<TreeNode>()

    if (root == null) return listOfLists

    queue.addFirst(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val levelList = mutableListOf<Int>()

        for (i in 0 until levelSize) {
            val node = queue.removeLast()
            levelList.add(node.`val`)
            if (node.left != null)
                queue.addFirst(node.left!!)
            if (node.right != null)
                queue.addFirst(node.right!!)
        }
        listOfLists.add(levelList)
    }

    return listOfLists
}