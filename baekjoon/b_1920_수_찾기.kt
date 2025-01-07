package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun b_1920_수_찾기() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val bw = System.out.bufferedWriter()
    readLine()
    val targetNums = readLine().split(" ").map { it.toInt() }.sorted()
    readLine()
    readLine().split(" ").forEach {
        if(binarySearch(targetNums, it.toInt())) {
            sb.append("1\n")
        } else {
            sb.append("0\n")
        }

    }

    bw.write(sb.toString())
    bw.close()
}

fun binarySearch(targetNums: List<Int>, targetNum: Int): Boolean {
    var min = 0
    var max = targetNums.size-1

    while (min <= max) {
        val midIdx = (max + min)/2
        val mid = targetNums[midIdx]
        if (targetNum == mid) {
            return true
        }
        if(targetNum > mid) {
            min = mid +1
        } else {
            max = mid -1
        }
    }

    return false
}
