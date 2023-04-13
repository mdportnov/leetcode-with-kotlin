package week6

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size
    val n = matrix[0].size
    var left = 0
    var right = m * n - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        val element = matrix[mid / n][mid % n]
        when {
            element == target -> return true
            element < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return false
}