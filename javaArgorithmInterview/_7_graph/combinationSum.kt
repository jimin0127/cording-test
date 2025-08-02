package javaArgorithmInterview._7_graph

import java.util.ArrayDeque
import java.util.Deque


// https://leetcode.com/problems/combination-sum/description/

class SolutionCombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        fun dfs(target: Int, index: Int, path: Deque<Int>) {
            // 0보다 작다면 목푯값을 넘어섰으므로 리턴
            if (target < 0) return
            // 0이면 목푯값에 도달했으므로 결과에 추가하고 리턴
            if (target == 0) {
                // 이전 경로를 저장해둔 path를 결과에 삽입
                results.add(ArrayList(path))
                return
            }
            // 자기자신보다 큰 숫자를 DFS 진행
            for (i in index until candidates.size) {
                // path 에 현재 엘리먼트 추가
                path.add(candidates[i])
                // 재귀 DFS
                dfs(target - candidates[i], i, path)
                println("$i, ${candidates[i]}")
                path.removeLast()
            }
        }

        dfs(target, 0, ArrayDeque())
        return results
    }
}


fun main() {
    val candidates = intArrayOf(2, 3, 5, 8)

    println(SolutionCombinationSum().combinationSum(candidates, 8))
}
