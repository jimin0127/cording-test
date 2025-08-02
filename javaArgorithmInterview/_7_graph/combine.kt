package javaArgorithmInterview._7_graph

import java.util.LinkedList

// https://leetcode.com/problems/combinations/
class SolutionCombination {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val results = mutableListOf<List<Int>>()

        fun dfs(elements: LinkedList<Int>, start: Int, k: Int) {
            // k 번째 노드에 도달하면 결과에 추가
            if (k == 0) {
                results.add(elements.toList())
                return
            }

            for (i in start..n) {
                // 전달받은 엘리먼트에 더해 현재 엘리먼트 추가
                elements.add(i)
                // 재귀 DFS
                dfs(elements, i+1, k - 1)

                // 돌아온 이후에는 현재 엘리먼트 삭제
                elements.removeLast()
            }
        }

        dfs(LinkedList(), 1, k)
        return results
    }
}

fun main() {
    val n = 5
    val k = 3

    println(SolutionCombination().combine(n = n, k = k))
}
