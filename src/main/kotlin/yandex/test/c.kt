package yandex.test

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Дан упорядоченный по неубыванию массив целых 32-разрядных чисел.
 * Требуется удалить из него все повторения.
 *
 * Желательно получить решение, которое не считывает входной файл целиком в память,
 * т.е., использует лишь константный объем памяти в процессе работы.
 */

fun main() {
    val r = BufferedReader(InputStreamReader(System.`in`))
    val n = r.readLine().toInt()

    var lastUniqueElement = ""
    for (i in 0 until n) {
        val elem = r.readLine()
        if (elem != lastUniqueElement) {
            lastUniqueElement = elem
            println(lastUniqueElement)
        }
    }
}