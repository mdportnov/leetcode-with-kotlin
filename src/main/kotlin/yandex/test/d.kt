package yandex.test

/**
 * Дано целое число n. Требуется вывести все правильные
 * скобочные последовательности длины 2 ⋅ n,
 * упорядоченные лексикографически (см. https://ru.wikipedia.org/wiki/Лексикографический_порядок).
 *
 * В задаче используются только круглые скобки.
 */

fun main() {
    val n = readLine()!!.toInt()
    printAllP3(n)
}

fun printAllP3(n: Int) {
    val arr = CharArray(n) { '(' } + CharArray(n) { ')' }

    fun f(n: Int, arr: CharArray) {
// печатаем нулевую последовательность
        println(arr.joinToString(""))
        while (true) {
            var ind = n - 1
            var cnt = 0
// находим откр. скобку, которую можно заменить
            while (ind >= 0) {
                if (arr[ind] == ')') {
                    cnt -= 1
                }
                if (arr[ind] == '(') {
                    cnt += 1
                }
                if (cnt < 0 && arr[ind] == '(') {
                    break
                }
                ind -= 1
            }
// если не нашли, то алгоритм заканчивает работу
            if (ind < 0)
                break
// заменяем на закр. скобку
            arr[ind] = ')'
// заменяем на самую лексикографическую минимальную
            for (i in ind + 1 until n) {
                if (i <= (n - ind + cnt) / 2 + ind) {
                    arr[i] = '('
                } else {
                    arr[i] = ')'
                }
            }
            println(arr.joinToString(""))
        }
    }

    f(n, arr)
}

fun printAllParentheses2(n: Int, str: String, open: Int, close: Int, result: MutableList<String>) {
    if (str.length == 2 * n) {
        result.add(str)
        return
    }

    if (open < n) {
        printAllParentheses2(n, "$str(", open + 1, close, result)
    }

    if (close < open) {
        printAllParentheses2(n, "$str)", open, close + 1, result)
    }
}

// Превышен объём памяти
fun printAllParentheses1(n: Int, str: String, open: Int, close: Int) {
    if (str.length == 2 * n) {
        println(str)
        return
    }
    if (open < n)
        printAllParentheses1(n, str + "(", open + 1, close)
    if (close < open)
        printAllParentheses1(n, str + ")", open, close + 1)
}