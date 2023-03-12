package week1

/**
 * Given an array of integers nums which is sorted in
 * ascending order, and an integer target, write a function
 * to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */

fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var end: Int = nums.size - 1

    while (start <= end) {
        val mid = start + (end - start) / 2
        if (nums[mid] == target) return mid
        else if (nums[mid] > target)
            end = mid - 1
        else start = mid + 1
    }

    return -1
}

// 1 3 5 7 8 9
//