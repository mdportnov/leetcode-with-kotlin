package week3

import java.util.*

fun setZeroes(matrix: Array<IntArray>) {
    val m: Int = matrix.size
    val n: Int = matrix[0].size
    val rowsArray = IntArray(m)
    val colsArray = IntArray(n)

    Arrays.fill(rowsArray, 1)
    Arrays.fill(colsArray, 1)

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (matrix[i][j] == 0) {
                rowsArray[i] = 0
                colsArray[j] = 0
            }
        }
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (rowsArray[i] == 0 || colsArray[j] == 0) matrix[i][j] = 0
        }
    }
}