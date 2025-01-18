package javaArgorithmInterview._2_array

fun threeSum(nums: IntArray): List<List<Int>> {
    var left: Int
    var right: Int
    var sum: Int
    val result = mutableListOf<List<Int>>()
    nums.sort()

    for (i in 0 until nums.size - 2) {
        if (i > 0 && nums[i] == nums[i - 1]) continue

        left = i + 1
        right = nums.size - 1
        while (left < right) {
            sum = nums[i] + nums[left] + nums[right]

            if (sum < 0) {
                left += 1
            } else if (sum > 0) {
                right -= 1
            } else {
                result.add(listOf(nums[i], nums[left], nums[right]))

                while (left < right && nums[left] == nums[left + 1])
                    left += 1

                while (left < right && nums[right] == nums[right - 1])
                    right -= 1

                left += 1
                right -= 1
            }
        }
    }

    return result
}

fun main() {
    val nums = intArrayOf(-1, 0, 1, 2, 2, -1, -5)
    println(threeSum(nums)) //[[-1, -1, 2], [-1, 0, 1]]
}
