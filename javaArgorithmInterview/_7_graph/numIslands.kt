package javaArgorithmInterview._7_graph
//https://leetcode.com/problems/number-of-islands/
// 1을 육지로 0을 물로 가정한 2차원 그리드맵이 주어졌을때 섬의 개수를 계산하라
class SolutionNumIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        fun dfs(i: Int, j: Int) {
            // 현재 위치가 그리드 밖이거나 물(0)인 겨우 종료
            if(
                (i < 0) ||
                        (i >= grid.size) ||
                        (j < 0) ||
                        (j >= grid[0].size) ||
                        (grid[i][j] == '0')
            ) return

            // 한번만 탐색하기 위해 탐색한 지점은 물(0)로 변경
            grid[i][j] = '0'

            // 동서남북 재귀 DFS
            dfs(i, j + 1) // 동
            dfs(i, j - 1) // 서
            dfs(i + 1, j) // 남
            dfs(i - 1, j) // 북
        }

        var count = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                // 만약 육지(1)인 경우 DFS 시작
                if (grid[i][j] == '1') {
                    dfs(i, j)

                    // 재귀가 모두 끝나면 섬 하나가 완성됐으므로 +1
                    count++
                }
            }
        }

        return count
    }
}

fun main() {
    val input1 = arrayOf(
        charArrayOf('1','1','1','1','0'),
        charArrayOf('1','1','0','1','0'),
        charArrayOf('1','1','0','0','0'),
        charArrayOf('0','0','0','0','0')
    )

    val input2 = arrayOf(
        charArrayOf('1','1','0','0','0'),
        charArrayOf('1','1','0','0','0'),
        charArrayOf('0','0','1','0','0'),
        charArrayOf('0','0','0','1','1')
    )

    println(SolutionNumIslands().numIslands(input1))
    println(SolutionNumIslands().numIslands(input2))
}
