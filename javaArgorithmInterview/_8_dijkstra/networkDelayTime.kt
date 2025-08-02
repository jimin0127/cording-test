package javaArgorithmInterview._8_dijkstra

import java.util.AbstractMap
import java.util.Collections
import java.util.PriorityQueue

// k에서 출발해 모든 노드가 신호를 받을 수 있는 시간을 계산하라. 한 군데라도 노드에 도달할 수 없는 경우 -1을 리턴한다.
// 입력값 (u, v, w)는 각각 출발지, 도착지, 소요 시간으로 구성되며, 전체 노드의 개수는 n이다.

class NetworkDelayTimeSolution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        // 네트워크의 각 노드를 출발지 -> 도착지 형태의 그래프로 구성
        val graph = mutableMapOf<Int, MutableMap<Int, Int>>()
        times.forEach { time ->
            // 값이 존재하지 않을 경우 빈 해시맵 생성
            graph.putIfAbsent(time[0], mutableMapOf())
            // 출발지에 (도착지, 소요시간)추가
            graph[time[0]]!![time[1]] = time[2]
        }

        // 우선순위 큐 생성, 값이 (도착지, 소요 시간)으로 구성되므로
        // 정렬 기준은 소요 시간을 기준으로 한다.
        val pq = PriorityQueue<Map.Entry<Int, Int>>(compareBy { (node, time) -> time })
        pq.add(AbstractMap.SimpleEntry(k, 0))

        // (도착지, 소요 시간) 최종 결과를 저장하는 변수 선언
        val dist = mutableMapOf<Int, Int>()
        // 큐에 값이 남아 있다면 없어질 때까지 반복
        while (pq.isNotEmpty()) {
            // 소요 시간이 가장 빠른 값 추출
            val (u, distU) = pq.poll()
            // u 지점가지의 소요 시간이 아직 계산되지 않았다면 처리 시작
            if (!dist.containsKey(u)) {
                // u 지점까지의 소요 시간을 결과 변수에 삽입
                dist[u] = distU
                print(distU)
                // u 지점을 출발지로 한 모든 경로 순회

                if (graph.containsKey(u)) {
                    graph[u]!!.forEach { v, lengthUV ->
                        // u 지점까지의 소요 시간 + u 지점을 출발지로 한
                        // 도착지까지의 소요 시간
                        val alt = distU + lengthUV
                        // 우선순위 큐에 (도착지, 소요 시간) 삽입
                        pq.add(AbstractMap.SimpleEntry(v, alt))
                    }
                }
            }
        }

        return if (dist.size == n) {
            print(dist.values)
            Collections.max(dist.values)
        } else {
            -1
        }
    }
}

fun main() {
    val times = arrayOf(intArrayOf(3, 1, 5), intArrayOf(3, 2, 2), intArrayOf(2, 1, 2), intArrayOf(3, 4, 1), intArrayOf(4, 5, 1), intArrayOf(5, 6, 1), intArrayOf(6, 7, 1), intArrayOf(7, 8, 1), intArrayOf(8, 1, 1))
    val solution = NetworkDelayTimeSolution().networkDelayTime(times, 8, 3)
    print(solution)
}
