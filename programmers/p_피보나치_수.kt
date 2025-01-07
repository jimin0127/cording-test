package programmers

class p_피보나치_수 {
    fun solution(n: Int): Int {
//        return when(n) {
//            0 -> 0
//            1 -> 1
//            else -> solution(n - 2) + solution(n - 1)
//        }

        // n+1 크기의 배열을 1로 초기화
//        var answer = IntArray(n+1){ 1 }
//        // 3부터 n까지 반복하며 피보나치 수를 배열에 저장해 줍니다.
//        (3..n).forEach{ answer[it] = (answer[it - 2] + answer[it - 1]) % 1234567 }
//        // 배열에 n번 칸에 들어있는 숫자를 반환합니다.
//        return answer[n]


        return fibonacci(n, 0, 1)
    }

    fun fibonacci(n: Int, a: Int, b: Int): Int {
        return if (n == 0) a else fibonacci(n-1, (a+b)%1234567, a)
    }
}
