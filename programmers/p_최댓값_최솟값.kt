package programmers

// https://school.programmers.co.kr/learn/courses/30/lessons/12939
class p_최댓값_최솟값 {
    fun solution(s: String): String {
        val nums = s.split(" ").map { it.toInt() }
        return "${nums.minOrNull()} ${nums.maxOrNull()}"
    }
}
