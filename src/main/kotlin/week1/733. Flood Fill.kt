package week1

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 *
 * You are also given three integers sr, sc, and color.
 * You should perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill, consider the starting pixel,
 * plus any pixels connected 4-directionally to the starting pixel
 * of the same color as the starting pixel, plus any pixels connected
 * 4-directionally to those pixels (also with the same color), and so on.
 * Replace the color of all of the aforementioned pixels with color.
 *
 * Return the modified image after performing the flood fill.
 */

// * 0 1 2
// 0 x y x
// 1 x y x
// 2 y u x
fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    if (image[sr][sc] == newColor)
        return image
    val oldColor = image[sr][sc]
    dfs(image, sr, sc, oldColor, newColor)
    return image
}

fun dfs(image: Array<IntArray>, sr: Int, sc: Int, oldColor: Int, newColor: Int) {
    if (sr < 0 || sc < 0 || sr >= image.size || sc >= image[0]  .size || image[sr][sc] != oldColor)
        return

    image[sr][sc] = newColor
    dfs(image, sr + 1, sc, oldColor, newColor)
    dfs(image, sr - 1, sc, oldColor, newColor)
    dfs(image, sr, sc + 1, oldColor, newColor)
    dfs(image, sr, sc - 1, oldColor, newColor)
}