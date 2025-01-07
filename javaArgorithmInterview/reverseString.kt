package javaArgorithmInterview

fun reverseString1(s: CharArray): CharArray {
    var start = 0
    var end = s.size -1

    while (start < end) {
        s[start] = s[end].also { s[end] = s[start] }

        start++
        end--
    }

    return s
}

fun reverseString2(s: CharArray): CharArray {
    return s.reversedArray()
}



fun main() {
    val startTime1 = System.currentTimeMillis()
    val array1 = charArrayOf('a', 'b', 'c')
    println(reverseString1(array1))
    val endTime1 = System.currentTimeMillis()
    println(endTime1-startTime1) // 2ms

    val startTime2 = System.currentTimeMillis()
    val array2 = charArrayOf('a', 'b', 'c')
    println(reverseString2(array2))
    val endTime2 = System.currentTimeMillis()
    println(endTime2-startTime2) // 11ms
}
