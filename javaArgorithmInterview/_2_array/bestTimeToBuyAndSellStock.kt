package javaArgorithmInterview._2_array

fun maxProfit(prices: IntArray): Int {
    var result = 0
    var minPrice = prices.first()

    for (price in prices) {
        minPrice = minPrice.coerceAtMost(price)
        result = result.coerceAtLeast(price - minPrice)
    }

    return result
}

fun main() {
    val input = intArrayOf(8, 1, 5, 3, 6, 4)
    println(maxProfit(input))
}
