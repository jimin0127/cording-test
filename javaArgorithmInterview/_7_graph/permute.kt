package javaArgorithmInterview._7_graph

//https://leetcode.com/problems/permutations/
// 서로 다른 정수를 입력 받아 가능한 모든 순열을 리턴하라.
class SolutionPermute {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun dfs(prevElement: MutableList<Int>, elements: List<Int>) {
            // 리프 노드에 도달하면 결과에 추가
            if (elements.isEmpty()) {
                result.add(prevElement.toList())
            }

            for (e in elements) {
                // 전달받은 엘리먼트에서 현재 엘리먼트를 제외하고 nextElement로 새롭게 구성
                val nextElement: MutableList<Int> = ArrayList(elements)
                nextElement.remove(e)

                // prevElement 는 기존 값에 현재 엘리먼트 추가
                prevElement.add(e)
                // 재귀 DFS
                dfs(prevElement, nextElement)

                // 돌아온 이후에는 prevElements에서 현재 엘리먼트 삭제
                prevElement.remove(e)
            }
        }


        dfs(mutableListOf(), nums.toList())

        return result
    }
}

fun main() {
    val input = intArrayOf(1, 2, 4)

    println(SolutionPermute().permute(input))
}
