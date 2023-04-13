package yandex.test

import java.util.*
import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val cities = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        cities.add(x to y)
    }
    val maxDistance = readLine()!!.toInt()
    val (start, end) = readLine()!!.split(" ").map { it.toInt() }

    // Создаем матрицу расстояний между городами
    val distances = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val (xi, yi) = cities[i]
            val (xj, yj) = cities[j]
            distances[i][j] = abs(xi - xj) + abs(yi - yj)
            distances[j][i] = distances[i][j]
        }
    }

    // Алгоритм Флойда -Уоршелла для поиска кратчайших путей между всеми парами городов
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                distances[i][j] = minOf(distances[i][j], distances[i][k] + distances[k][j])
            }
        }
    }

// Проверяем, может ли Петя добраться до конечной точки без дозаправки
    if (distances[start - 1][end - 1] > maxDistance) {
        println(-1)
        return
    }

    println(minRoadsCount(n, distances, start - 1, end - 1))
}

fun minRoadsCount(n: Int, roads: Array<IntArray>, s: Int, t: Int): Int {
    val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }
    for ((u, v, w) in roads) {
        graph[u].add(Pair(v, w))
        graph[v].add(Pair(u, w))
    }

    val dist = IntArray(n) { Int.MAX_VALUE }
    dist[s] = 0
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    pq.add(Pair(s, 0))

    while (pq.isNotEmpty()) {
        val (u, d) = pq.poll()
        if (u == t) {
            return d
        }
        if (d > dist[u]) {
            continue
        }
        for ((v, w) in graph[u]) {
            if (dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w
                pq.add(Pair(v, dist[v]))
            }
        }
    }
    return -1
}

// Алгоритм Дейкстры для поиска кратчайшего пути в матрице расстояний
fun findShortestPath(distances: Array<IntArray>, start: Int, end: Int): List<Int> {
    val n = distances.size
    val visited = BooleanArray(n) { false }
    val distance = IntArray(n) { Int.MAX_VALUE }
    val prev = IntArray(n) { -1 }
    val queue = mutableListOf(start)

    distance[start] = 0

    while (queue.isNotEmpty()) {
        val current = queue.minByOrNull { distance[it] }!!
        queue.remove(current)
        visited[current] = true

        if (current == end) {
            break
        }

        for (next in 0 until n) {
            if (!visited[next] && distances[current][next] <= distance[current] + Int.MAX_VALUE) {
                val newDistance = distance[current] + distances[current][next]
                if (newDistance < distance[next]) {
                    distance[next] = newDistance
                    prev[next] = current
                    queue.add(next)
                }
            }
        }
    }
    val path = mutableListOf<Int>()
    var current = end
    while (current != -1) {
        path.add(current)
        current = prev[current]
    }
    return path.reversed()
}

