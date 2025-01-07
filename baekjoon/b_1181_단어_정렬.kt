package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun b_1181_단어_정렬() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val lists = (1..N).map { readLine() }
    val results = lists.sortedWith(compareBy({ it.length }, { it })).toSet()

    results.forEach { println(it) }
}
