package week4

import java.util.*

fun leastInterval(tasks: CharArray, n: Int): Int {
    val pq = PriorityQueue<Int>()
    val mp = IntArray(26) { 0 }

    for (task in tasks)
        mp[task - 'A']++

    for (i in 0 until 26)
        if (mp[i] != 0)
            pq.offer(mp[i])

    var time = 0

    while (pq.isNotEmpty()) {
        val remain = mutableListOf<Int>()
        var cycle = n + 1 // n+1 is the CPU cycle length, if n is the cooldown period then after a task A there will be n more tasks. Hence n+1

        while (cycle != 0 && pq.isNotEmpty()) {
            val maxFreq = pq.poll()
            if (maxFreq > 1) // task with more than one occurrence, the next occurrence will be done in the next cycle
                remain.add(maxFreq - 1) // add it to remaining task list
            ++time
            --cycle
        }

        for (count in remain)
            pq.add(count)

        if (pq.isEmpty()) break // if the priority queue is empty than all tasks are completed and we don't need to include the idle time
        time += cycle // counts the idle time
    }
    return time
}