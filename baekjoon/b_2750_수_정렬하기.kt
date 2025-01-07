package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun b_2750_수_정렬하기() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val len = readLine().toInt()
    val nums = mutableListOf<Int>()

    repeat(len) {
        nums.add(readLine().toInt())
    }

    nums.sorted()
        .forEach { println(it) }
}
