package programmers

class p_최소공배수 {
    fun solution(arr: IntArray): Int {
        val maxNum = arr.maxOrNull()!!
        var answer = maxNum
        while (arr.any { answer % it != 0 }) {
            answer += maxNum
        }

        return answer
    }
}
