package javaArgorithmInterview._8_dijkstra

import java.util.PriorityQueue

// https://leetcode.com/problems/cheapest-flights-within-k-stops/

// 시작점에서 도착점까지의 가장 저렴한 가격을 계산하되, k개의 경유지 이내에 도착하는 가격을 리턴하라.
// src 시작점, dst 도착점,
class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val graph = mutableMapOf<Int, MutableMap<Int, Int>>()
        flights.forEach { flight ->
            graph.putIfAbsent(flight[0], mutableMapOf())
            graph[flight[0]]!![flight[1]] = flight[2]
        }

        val pq = PriorityQueue<List<Int>> { a: List<Int>, b: List<Int> -> a[1] - b[1]}
        pq.add(listOf(src, 0, 0))

        val visited = mutableMapOf<Int, Int>()
        // 큐에 값이 남아 있다면 없어질 때까지 반복
        while (pq.isNotEmpty()) {
            // 비용이 가장 저렴한 값 추출
            val cur = pq.poll()
            val u = cur[0]
            val priceU = cur[1]
            var k_visited = cur[2]

            // 만약 큐에서 추출한 값이 도착지 dst 라면 정답으로 리턴
            if (u == dst) {
                return priceU
            }

            // 도착지(u)가지 진행경로(k_visited) 저장, 따로 저장해두진 형태지만 비용이 가장 저렴한 경로
            visited[u] = k_visited

            // 진행 경로(k_visited)가 남은 경로 (k)이내에 있다면 처리 계속
            if (k_visited <= k) {
                // 처리하면서 진행 경로 +1
                k_visited += 1
                // u 지점을 출발지로 한 경로가 있다면 처리 시작
                if (graph.containsKey(u)) {
                    graph[u]!!.forEach { key, value ->
                        if (!visited.containsKey(key) || k_visited < visited[key]!!) {
                            val alt  = priceU + value
                            pq.add(listOf(key, alt, k_visited))
                        }
                    }
                }
            }
        }

        return -1
    }
}

fun main() {
    val flights = arrayOf(intArrayOf(0, 1, 100), intArrayOf(1, 2, 200), intArrayOf(0, 2, 500))
    val solution = Solution().findCheapestPrice(n = 3, flights, src = 0, dst = 2, k = 0)
    print(solution)
}
