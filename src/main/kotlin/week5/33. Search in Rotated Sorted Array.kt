package week5

fun search(nums: IntArray, target: Int): Int {
    var lo = 0
    var hi: Int = nums.size - 1
    while (lo < hi) {
        val mid = (lo + hi) / 2
        if (nums[mid] == target) return mid
        if (nums[lo] <= nums[mid]) {
            if (target >= nums[lo] && target < nums[mid])
                hi = mid - 1
            else
                lo = mid + 1
        } else
            if (target > nums[mid] && target <= nums[hi])
                lo = mid + 1
            else
                hi = mid - 1
    }
    return if (nums[lo] == target) lo else -1
}