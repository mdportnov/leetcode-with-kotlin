package day2

class Solution {
    // Time O(n*log(n))
    fun isAnagram1(s: String, t: String): Boolean {
        val s = s.toCharArray()
        val t = t.toCharArray()
        s.sort()
        t.sort()
        return String(s) == String(t)
    }

    // Time: O(n)
    // Space: O(1)
    fun isAnagram2(s: String, t: String): Boolean {
        val counts = IntArray(26)

        for (c in s.toCharArray()) {
            counts[c - 'a']++
        }
        for (c in t.toCharArray()) {
            counts[c - 'a']--
        }
        return counts.none { it != 0 }
    }

    // with Unicode
    // Time O(n)
    // Space O(1)
    fun isAnagram3(s: String, t: String): Boolean {
        val counts = mutableMapOf<Char, Int>()

        for (c in s.toCharArray()) {
            counts[c] = (counts[c] ?: 0).plus(1)
        }
        for (c in t.toCharArray()) {
            counts[c] = (counts[c] ?: 0).minus(1)
        }
        return counts.values.none { it != 0 }
    }
}