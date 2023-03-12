package week0

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index: Int, digit: Int ->
        if (map.containsKey(target - digit)) {
            return intArrayOf(map[target - digit]!!, index)
        } else
            map[digit] = index
    }

    return intArrayOf(-1, -1)
}
