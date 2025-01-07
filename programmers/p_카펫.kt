package programmers// https://school.programmers.co.kr/learn/courses/30/lessons/42842

class p_카펫 {
    fun solution(brown: Int, yellow: Int): IntArray {
        val area = brown + yellow
        val commonMultiple = (3..area).filter { area % it == 0 }
        val height = commonMultiple.first { height ->
            val width = area / height
            (height - 2) * (width - 2) == yellow
        }

        return arrayOf(area / height, height).toIntArray()
    }
}
