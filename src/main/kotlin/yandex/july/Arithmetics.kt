package yandex.july

import java.util.*

class Arithmetics {
    private val heap = PriorityQueue<Progression>(compareBy { it.a1 })
    private val idSet = mutableSetOf<Int>()
    private var nextId = 1

    fun addProgression(a1: Int, d: Int, id: Int) {
        if (id in idSet) return
        heap.offer(Progression(a1, d, a1, id))
        idSet.add(id)
    }

    fun removeProgression(id: Int) {
        idSet.remove(id)
        val newHeap = PriorityQueue<Progression>(compareBy { it.a1 })
        while (heap.isNotEmpty()) {
            val prog = heap.poll()
            if (prog.id != id) {
                newHeap.offer(prog)
            } else {
                break
            }
        }
        heap.addAll(newHeap)
    }

    fun getMinElement(): Int {
        val prog = heap.poll()
        val nextA = prog.nextA + prog.d
        heap.offer(Progression(nextA, prog.d, nextA, prog.id))
        return prog.a1
    }

    data class Progression(val a1: Int, val d: Int, val nextA: Int, val id: Int)
}

fun main() {
    val scanner = Scanner(System.`in`)
    val arithmetics = Arithmetics()

    val q = scanner.nextInt()
    repeat(q) {
        when (scanner.nextInt()) {
            1 -> {
                val a1 = scanner.nextInt()
                val d = scanner.nextInt()
                val id = scanner.nextInt()
                arithmetics.addProgression(a1, d, id)
            }

            2 -> {
                val id = scanner.nextInt()
                arithmetics.removeProgression(id)
            }

            3 -> {
                println(arithmetics.getMinElement())
            }
        }
    }
}