package week4

import java.util.*

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = HashSet<List<Int>>()
    if (nums.size < 3)
        return Collections.emptyList();

    Arrays.sort(nums)

    for (i in 0 until nums.size - 1) {
        var j = i + 1
        var k = nums.size - 1
        while (j < k) {
            var sum = nums[i] + nums[j] + nums[k]
            if (sum == 0) result.add(listOf(nums[i], nums[j++], nums[k--]))
            else if (sum > 0) k--
            else if (sum < 0) j++
        }
    }
    return result.toList()
}