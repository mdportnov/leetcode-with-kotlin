package week7

fun singleNumber(nums: IntArray): Int {
    var result = 0

    // XOR all the numbers together
    for (num in nums) {
        result = result xor num
    }

    return result
}