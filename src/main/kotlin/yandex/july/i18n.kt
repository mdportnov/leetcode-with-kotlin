package yandex.july

fun main() {
    val n = readln().toInt()
    val words = Array(n) { readln() }
    val res = Array(n) { "" }
    val list = getShortestAbbreviation(words.toList())
    for (i in 0 until n) {
        println(list[i])
    }
}

fun compress(s: String): String {
    if (s.length <= 3) return s
    return s[0] + (s.length - 2).toString() + s[s.length - 1]
}

fun getShortestAbbreviation(words: List<String>): List<String> {
    val usedResults = mutableSetOf<String>()
    val result = mutableMapOf<String, String>()
    val resultMapper = mutableMapOf<String, String>()

    for (word in words) {
        for (i in 1..word.length / 2) {
            val compressed = compress(word.substring(0, i) + word.substring(word.length - i))
            if (compressed !in usedResults) {
                usedResults.add(compressed)
                if (compressed in resultMapper) {
                    val tmp = resultMapper[compressed]!!
                    resultMapper.remove(compressed)
                    result.remove(tmp)
                    result[compress(tmp)] = tmp
                    resultMapper[compress(tmp)] = tmp
                    continue
                }
                result[word] = compressed
                resultMapper[compressed] = word
                break
            }
        }
    }
    return words.map { result[it] ?: it }
}
