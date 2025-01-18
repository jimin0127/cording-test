package javaArgorithmInterview._2_array

// n 개의 페어를 이용한 min(a, b)의 합으로 만들 수 있는 가장 큰 수를 출력하라.

fun arrayPairSum(nums: IntArray): Int {
    var result = 0
    nums.sort()

    nums.forEachIndexed { index, i ->
        if (index % 2 == 0) {
            result += i
        }
    }

    return result
}

fun main() {
    val input = intArrayOf(1, 3, 4, 2)
    println(arrayPairSum(input)) // 4
}
