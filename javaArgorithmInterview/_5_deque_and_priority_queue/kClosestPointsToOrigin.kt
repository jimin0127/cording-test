package javaArgorithmInterview._5_deque_and_priority_queue

import java.util.PriorityQueue
import java.util.Queue

data class Point(var distance: Long, var point: IntArray)

fun KClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val pq: Queue<Point> = PriorityQueue(compareBy { a -> a.distance })

    for (point in points) {
        val distance = point[0].toLong() * point[0] + point[1].toLong() * point[1]
        pq.add(
            Point(
                distance = distance,
                point = point
            )
        )
    }

    val results: Array<IntArray> = Array(k) { IntArray(2) { 0 } }
    for (i in 0 until k) {
        results[i] = pq.poll().point
    }

    return results
}

fun main() {
    val points = arrayOf(
        intArrayOf(3, 3),
        intArrayOf(6, -1),
        intArrayOf(-2, 4),
    )


    val results = KClosest(points, 2)
    for (i in results) {
        println(i.map { it })
    }

    // [3, 4], [-2, 4]
}
