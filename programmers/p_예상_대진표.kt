package programmers// https://school.programmers.co.kr/learn/courses/30/lessons/12985

class p_예상_대진표 {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0

        var a = a
        var b = b

        while (a != b) {
            answer += 1
            if (a % 2 != 0) { a += 1 }
            if (b % 2 != 0) { b += 1 }

            a /= 2
            b /= 2
        }

        return answer
    }
}
