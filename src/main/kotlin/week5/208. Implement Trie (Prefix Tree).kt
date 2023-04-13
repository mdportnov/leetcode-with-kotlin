package week5

class Trie(val root: TrieNode = TrieNode()) {

    class TrieNode(
        var endOfWord: Boolean = false,
    ) {
        val children: MutableMap<Char, TrieNode> = mutableMapOf<Char, TrieNode>()
    }

    fun insert(word: String) {
        val chars = word.toCharArray()

        var node = root
        chars.forEach { char ->
            node.children.putIfAbsent(char, TrieNode())
            node = node.children[char]!!
        }

        node.endOfWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (c in word) node = node.children[c] ?: return false
        return node.endOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for (c in prefix) {
            node = node.children[c] ?: return false
        }
        return true
    }
}

fun main() {
    var obj = Trie()
    obj.insert("word")
    var param_2 = obj.search("word")
    var param_3 = obj.startsWith("prefix")
}