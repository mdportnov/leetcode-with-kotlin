package week3

fun main() {
    println(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}

fun majorityElement(nums: IntArray): Int {
    val hm = mutableMapOf<Int, Int>() // num : count
    val countMajority = nums.size / 2
    nums.forEach { num ->
        if (hm.containsKey(num))
            hm[num] = hm[num]!!.plus(1)
        else
            hm[num] = 1
    }
    return hm.entries.filter { it.value > countMajority }.map { it.key }.first()
}