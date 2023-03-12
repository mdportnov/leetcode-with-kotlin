package week1

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

fun maxProfit(prices: IntArray): Int {
    var buyPtr = 0
    var sellPtr = 1
    var maxProfit = 0
    while (sellPtr != prices.size) {
        val currentProfit = prices[sellPtr] - prices[buyPtr]
        if (currentProfit > 0) {
            maxProfit = maxOf(maxProfit, currentProfit)
        } else {
            buyPtr = sellPtr
        }
        sellPtr++
    }
    return maxProfit
}

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))) // 5
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1))) // 0
}