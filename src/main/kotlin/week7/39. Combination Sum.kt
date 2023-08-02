package week7

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val results = mutableListOf<List<Int>>()
    backtrack(candidates, target, 0, mutableListOf(), results)
    return results
}

fun backtrack(
    candidates: IntArray,
    target: Int,
    start: Int,
    current: MutableList<Int>,
    results: MutableList<List<Int>>
) {
    if (target < 0)
        return

    if (target == 0)
        results.add(current.toList())

    for (i in start until candidates.size) {
        current.add(candidates[i])
        backtrack(candidates, target - candidates[i], i, current, results)

        current.removeAt(current.size - 1)
    }
}