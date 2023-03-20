package week3

import java.util.*

val dir = intArrayOf(0, 1, 0, -1, 0)

fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size

    val queue = ArrayDeque<IntArray>()

    for (r in 0..m) {
        for (c in 0..n) {
            if (mat[r][c] == 0) queue.offer(intArrayOf(r, c))
            else mat[r][c] = -1 // not processed yet!
        }
    }

    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        val r = curr[0]
        val c = curr[1]

        for (i in 0 until 4) {
            val nr = r + dir[i]
            val nc = c + dir[i + 1]
            if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1)
                continue
            mat[nr][nc] = mat[r][c] + 1
            queue.offer(intArrayOf(nr, nc))
        }
    }
    return mat
}