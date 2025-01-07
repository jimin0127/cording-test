package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun b_11399_ATM() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    val nums = readLine().split(" ").map { it.toInt() }.sorted()

    val results = mutableListOf<Int>()

    nums.forEachIndexed { idx, num->
        val previousTime = if (idx > 0) { results[idx-1] } else { 0 }
        val numTime = previousTime + num
        results.add(numTime)
    }

    print(results.sum())
}
