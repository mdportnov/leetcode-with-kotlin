package week0

fun lengthOfLongestSubstring(s: String): Int {
    var longestSubstring = ""
    var length = 0

    for (i in s.indices) {
        if (!longestSubstring.contains(s[i])) {
            longestSubstring += s[i]
        } else {
            if (longestSubstring.length > length) {
                length = longestSubstring.length
            }
            val index = longestSubstring.indexOf(s[i])
            longestSubstring = longestSubstring.substring(index + 1, longestSubstring.length) + s[i]
        }
    }

    return if (longestSubstring.length > length) longestSubstring.length else length
}