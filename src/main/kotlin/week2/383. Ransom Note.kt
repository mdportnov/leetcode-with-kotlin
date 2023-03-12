package week2

fun main() {
    println(canConstruct("aa", "aab"))
}

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val ransomNoteChars = ransomNote.toCharArray()
    val magazineChars = magazine.toCharArray()
    val hm = mutableMapOf<Char, Int>()

    magazineChars.forEach { char ->
        if (hm.containsKey(char))
            hm[char] = hm[char]?.plus(1)!!
        else
            hm[char] = 1
    }

    ransomNoteChars.forEach { char ->
        var count = hm[char] ?: return false
        if (count == 0) return false
        hm[char] = --count
    }

    return true
}