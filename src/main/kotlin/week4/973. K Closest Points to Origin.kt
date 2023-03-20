package week4

import java.util.*

// O(n*log(n))

fun kClosest1(points: Array<IntArray>, k: Int): Array<IntArray?> {
    val v = mutableListOf<Pair<Int, Pair<Int, Int>>>()

    points.forEach {
        val dist = it[0] * it[0] + it[1] * it[1]
        v.add(Pair(dist, Pair(it[0], it[1])))
    }

    v.sortBy { it.first }

    val ans = arrayOfNulls<IntArray>(k)

    for (i in 0 until k) {
        ans[i] = intArrayOf(v[i].second.first, v[i].second.second)
    }

    return ans
}

// O(k*log(n))

fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray?> {
    val maxHeap = PriorityQueue<IntArray> { a, b -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]) }

    points.forEach {
        maxHeap.add(it)
        if (maxHeap.size > k)
            maxHeap.remove()
    }

    val result = arrayOfNulls<IntArray>(k)
    for (i in k - 1 downTo 0)
        result[i] = maxHeap.remove()
    return result
}