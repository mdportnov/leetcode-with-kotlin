package week5

fun numIslands(grid: Array<CharArray>): Int {
    if (grid.size == 0)
        return 0

    var num = 0

    for (i in 0 until grid.size) {
        for (j in 0 until grid[i].size) {
            if (grid[i][j] == '1') {
                num += dfs(grid, i, j)
            }
        }
    }

    return num
}

fun dfs(grid: Array<CharArray>, i: Int, j: Int): Int {
    if (i < 0 || j < 0 || i >= grid.size || j >= grid[i].size
        || grid[i][j] == '0'
    )
        return 0

    grid[i][j] = '0'

    dfs(grid, i + 1, j)
    dfs(grid, i - 1, j)
    dfs(grid, i, j + 1)
    dfs(grid, i, j - 1)

    return 1
}