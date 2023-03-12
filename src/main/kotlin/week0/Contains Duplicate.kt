package week0

fun containsDuplicate(nums: IntArray): Boolean {
    var flag = false

    val set = mutableSetOf<Int>()

    for (num in nums) {
        if (set.contains(num)) {
            flag = true
            break
        } else
            set.add(num)
    }

    return flag
}