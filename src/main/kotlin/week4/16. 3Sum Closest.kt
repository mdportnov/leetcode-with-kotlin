package week4

import kotlin.math.abs

// Space O(1) / Time O(N^2)
fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()
    val n = nums.size
    var closest = nums[0] + nums[1] + nums[2]

    loop@ for (i in 0..n - 2) {
        var l = i + 1
        var r = n - 1
        while (l < r) {
            val sum = nums[i] + nums[l] + nums[r]
            if (sum == target) return sum
            if (abs(sum - target) < abs(target - closest))
                closest = sum

            if (sum > target) r--
            else l++
        }
    }
    return closest
}