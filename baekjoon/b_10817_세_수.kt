package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun b_10817_세_수() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nums = readLine().split(" ").map { it.toInt() }

    print(nums.sorted()[1])
}
