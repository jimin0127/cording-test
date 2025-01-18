package javaArgorithmInterview._2_array

fun productExceptSelf(nums: IntArray): IntArray {
    val result = IntArray(nums.size)

    // i 를 기준으로 왼쪽을 곱한 값을 먼저 넣고 오른쪽 값을 곱함

    var p = 1
    for (i in nums.indices) {
        result[i] = p

        p *= nums[i]
    }

    p = 1
    for (i in nums.indices.reversed()) {
        result[i] *= p

        p *= nums[i]
    }

    return result
}

fun main() {
    val input = intArrayOf(1, 3, 5, 7)
    println(productExceptSelf(input).map { it })
}
