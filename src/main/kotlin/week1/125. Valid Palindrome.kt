package week1

/**
 * A phrase is a palindrome if, after converting all uppercase letters
 * into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
fun isPalindrome(s: String): Boolean {
    if (s.isEmpty())
        return true

    var left = 0
    var right = s.length - 1
    while (left < right) {
        if (!s[left].isLetterOrDigit())
            left++
        else if (!s[right].isLetterOrDigit())
            right--
        else {
            if (s[right].toLowerCase() != s[left].toLowerCase())
                return false
            left++
            right--
        }
    }
    return true
}

fun main() {

}