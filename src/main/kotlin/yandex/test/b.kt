package yandex.test

/**
 * Требуется найти в бинарном векторе самую длинную
 * последовательность единиц и вывести её длину.
 *
 * Желательно получить решение, работающее за линейное время
 * и при этом проходящее по входному массиву только один раз.
 */

fun main() {
    val n = readLine()!!.toInt()
    val array = mutableListOf<Int>()

    repeat(n) {
        array.add(readLine()!!.toInt())
    }

    var maxLength = 0
    var currLength = 0

    array.forEach { el ->
        if (el == 0) {
            if (currLength > maxLength)
                maxLength = currLength
            currLength = 0
        } else
            if (el == 1)
                currLength++
    }

    if (currLength > maxLength)
        println(currLength)
    else
        println(maxLength)
}