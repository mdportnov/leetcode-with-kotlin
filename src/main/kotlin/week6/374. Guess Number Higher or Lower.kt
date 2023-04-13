package week6

fun guess(value: Int): Int = 1

class Solution {
    fun guessNumber(n: Int): Int {
        var min = 1
        var max = n

        while (true) {
            var mid = min + (max - min) / 2
            val guessResult = guess(mid)

            when {
                guessResult == -1 -> max = mid - 1
                guessResult == 1 -> min = mid + 1
                guessResult == 0 -> {
                    return mid
                }
            }
        }
    }
}