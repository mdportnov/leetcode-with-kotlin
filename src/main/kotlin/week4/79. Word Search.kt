package week4

fun exist(board: Array<CharArray>, word: String): Boolean {
    for (i in 0 until board.size) {
        for (j in 0 until board[0].size) {
            if (board[i][j] == word[0] && dfs(board, i, j, 0, word))
                return true
        }
    }
    return false
}

fun dfs(board: Array<CharArray>, i: Int, j: Int, count: Int, word: String): Boolean {
    if (count == word.length) return true

    if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || board[i][j] != word[count])
        return false

    var tmp = board[i][j]
    board[i][j] = ' '
    var found = dfs(board, i + 1, j, count + 1, word)
            || dfs(board, i - 1, j, count + 1, word)
            || dfs(board, i, j + 1, count + 1, word)
            || dfs(board, i, j - 1, count + 1, word)

    board[i][j] = tmp
    return found
}


