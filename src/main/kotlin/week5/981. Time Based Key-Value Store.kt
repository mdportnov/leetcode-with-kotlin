package week5

import java.util.*

class TimeMap() {
    val map = hashMapOf<String, PriorityQueue<Tuple>>()

    class Tuple(var timestamp: Int, var value: String) : Comparable<Tuple> {
        override operator fun compareTo(other: Tuple): Int {
            return other.timestamp - timestamp
        }
    }

    fun set(key: String, value: String, timestamp: Int) {
        map.putIfAbsent(key, PriorityQueue())
        map[key]?.offer(Tuple(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        if (!map.containsKey(key))
            return ""

        val queue = map[key]!!

        val tuple = binarySearch(queue, timestamp) ?: return ""

        return tuple.value
    }

    private fun binarySearch(queue: PriorityQueue<Tuple>, timestamp: Int): Tuple? {
        var result: Tuple? = null
        while (queue.isNotEmpty()) {
            val tuple = queue.peek()
            if (tuple.timestamp <= timestamp) {
                result = tuple
                queue.poll()
            } else
                break
        }
        return result
    }
}
