package week5

/**
 *[
 *  [2],
 *  [3,4],
 *  [6,5,7], i = 2 j = 0
 *  [4,1,8,3]
 * ]
 */
fun minimumTotal(triangle: List<List<Int>>): Int {
    val n = triangle.size
    val memo = triangle[n - 1].toIntArray()

    for (i in n - 2..0) {
        for (j in 0..i) {
            memo[j] = triangle[i][j] + minOf(memo[j], memo[j + 1])
        }
    }

    return memo[0]
}