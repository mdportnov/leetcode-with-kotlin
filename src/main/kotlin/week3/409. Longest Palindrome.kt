package week3

fun main() {
    println(longestPalindrome("abbaccccdd"))
    println(longestPalindrome("aa"))
}

fun longestPalindrome(s: String): Int {
    val chars = s.toCharArray()
    val hashSet = mutableSetOf<Char>()
    var len = 0
    for (char in chars) {
        if (hashSet.contains(char)) {
            len += 2
            hashSet.remove(char)
        } else
            hashSet.add(char)
    }
    if (hashSet.size > 0)
        len++
    return len
}