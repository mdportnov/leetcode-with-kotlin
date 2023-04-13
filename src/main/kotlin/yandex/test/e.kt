package yandex.test

/**
 * Даны две строки, состоящие из строчных латинских букв.
 * Требуется определить, являются ли эти строки анаграммами,
 * т. е. отличаются ли они только порядком следования символов.
 */

fun main() {
    val s1 = readLine()!!
    val s2 = readLine()!!
    println(if (permutation(s1, s2)) 1 else 0)
}

fun permutation(s: String, t: String): Boolean {
    if (s.length != t.length)
        return false

    val letters = IntArray(256)
    val sArray = s.toCharArray()
    for (c in sArray)
        letters[c.code]++

    for (element in t) {
        val c = element.code
        if (--letters[c] < 0)
            return false
    }
    return true
}