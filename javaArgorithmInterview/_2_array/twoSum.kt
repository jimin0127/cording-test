package javaArgorithmInterview._2_array

fun twoSum1(nums: IntArray, target: Int): IntArray {
    val numsMap = mutableMapOf<Int, Int>()

    nums.forEachIndexed {  index, num ->
        if (numsMap.containsKey(target - num)) {
            return intArrayOf(numsMap[target-num] ?: 0, index)
        } else {
            numsMap[num] = index
        }
    }
    return intArrayOf(0, 0)
}

fun twoSum2(nums: IntArray, target: Int): IntArray {
    val numsMap = mutableMapOf<Int, Int>()

    nums.forEachIndexed {  index, num ->
        if (numsMap.containsKey(target - num)) {
            return intArrayOf(numsMap[target-num]!!, index)
        } else {
            numsMap[num] = index
        }
    }
    return intArrayOf()
}

fun main() {
    val nums = intArrayOf(2, 6, 11, 15)
    val target = 8

    // target 을 만들 수 있는 nums 의 두 index 반환
    println(twoSum1(nums, target).map { it }) // [0, 1]
    println(twoSum2(nums, target).map { it })
}
