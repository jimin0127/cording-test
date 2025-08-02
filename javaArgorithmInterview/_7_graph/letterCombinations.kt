package javaArgorithmInterview._7_graph

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// 2에서 9까지 숫자가 주어졌을 때 전화번호로 조합 가능한 모든 문자를 출력하라.

class SolutionLetterCombinations {
    fun letterCombinations(digits: String): List<String> {
        val result: MutableList<String> = mutableListOf()
        if (digits.isEmpty()) return result

        // 번호로 조합 가능한 문자 목록 구현
        val dic = mapOf(
            '0' to listOf(),
            '1' to listOf(),
            '2' to listOf('a', 'b', 'c'),
            '3' to listOf('d', 'e', 'f'),
            '4' to listOf('g', 'h', 'i'),
            '5' to listOf('j', 'k', 'l'),
            '6' to listOf('m', 'n', 'o'),
            '7' to listOf('p', 'q', 'r', 's'),
            '8' to listOf('t', 'u', 'v'),
            '9' to listOf('w', 'x', 'y', 'z'),
        )

        fun dfs(index: Int, path: StringBuilder) {
            // 끝까지 탐색했으면 결과를 저장하고 리턴
            if (path.length == digits.length) {
                result.add(path.toString())
                return
            }

            // 현재 자리 숫자에 해당하는 모든 문자열 탐색
            for (c in dic[digits[index]]!!) {
                // 현재 자리 +1, 지금까지 구성된 문자열 path 이용 재귀 DFS
                dfs(index + 1, StringBuilder(path).append(c))
            }
        }

        dfs(0, StringBuilder())

        return result
    }
}

fun main() {
    println(SolutionLetterCombinations().letterCombinations("24"))
    println(SolutionLetterCombinations().letterCombinations(""))
    println(SolutionLetterCombinations().letterCombinations("2"))
    println(SolutionLetterCombinations().letterCombinations("234"))
}
