package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun b_2751_수_정렬하기2() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val len = readLine().toInt()
    val nums = mutableListOf<Int>()

    val sb = StringBuilder()
    val bw = System.out.bufferedWriter()

    repeat(len) {
        nums.add(readLine().toInt())
    }
    nums.sort()

    sb.append(nums.joinToString("\n"))
    bw.write(sb.toString())
    bw.close()
}
