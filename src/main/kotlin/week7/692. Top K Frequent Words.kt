package week7

import java.util.*


fun topKFrequent(words: Array<String>, k: Int): List<String> {
    val result = mutableListOf<String>()
    val map = mutableMapOf<String, Int>()

    for (i in words.indices) {
        if (map.containsKey(words[i]))
            map[words[i]] = map[words[i]]!! + 1
        else
            map[words[i]] = 1
    }

    val pq = PriorityQueue { (key, value): Map.Entry<String, Int>, (key1, value1): Map.Entry<String, Int> ->
        if (value == value1) key1.compareTo(key) else value - value1
    }

    map.entries.forEach { entry ->
        pq.offer(entry)
        if (pq.size > k)
            pq.poll()
    }

    while (pq.isNotEmpty())
        result.add(0, pq.poll().key)

    return result
}