package week3

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val res = mutableListOf<Int>()
    if (matrix.isEmpty())
        return res

    var rowBegin = 0
    var rowEnd = matrix.size - 1
    var colBegin = 0
    var colEnd = matrix[0].size - 1

    while (rowBegin <= rowEnd && colBegin <= colEnd) {
        for (i in colBegin..colEnd)
            res.add(matrix[rowBegin][i])
        rowBegin++

        for (i in rowBegin..rowEnd)
            res.add(matrix[i][colEnd])
        colEnd--

        if (rowBegin <= rowEnd) {
            for (i in colEnd downTo colBegin)
                res.add(matrix[rowEnd][i])
        }
        rowEnd--

        if (colBegin <= colEnd) {
            for (i in rowEnd downTo rowBegin)
                res.add(matrix[i][colBegin])
        }
        colBegin++
    }
    return res
}