package programmers

// https://school.programmers.co.kr/learn/courses/30/lessons/12914
class p_멀리뛰기 {
    fun solution(n: Int): Long {
        return fibonacci(n, 0, 1).toLong()
    }
    fun fibonacci(n: Int, a: Int, b: Int): Int {
        return if (n == 0) a else fibonacci(n-1, (a+b)%1234567, a)
    }
}
