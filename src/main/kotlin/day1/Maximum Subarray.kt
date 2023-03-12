package day1

fun maxSubArray(nums: IntArray): Int {
    var mSum = Integer.MIN_VALUE
    var sum = 0
    for (i in nums.indices) {
        sum += nums[i]
        if (sum < nums[i]) sum = nums[i]
        if (mSum < sum) mSum = sum
    }
    return mSum
}