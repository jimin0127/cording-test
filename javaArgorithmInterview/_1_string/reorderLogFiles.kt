package javaArgorithmInterview._1_string

fun reorderLogFiels(logs: Array<String>): Array<String> {
    val letterList = mutableListOf<String>()
    val digitList = mutableListOf<String>()

    for (log in logs) {
        if (Character.isDigit(log.split(" ")[1][0])) {
            digitList.add(log)
        } else {
            letterList.add(log)
        }
    }

    letterList.sortWith(Comparator { s1: String, s2: String ->
        val s1x = s1.split(" ", limit = 2)
        val s2x = s2.split(" ", limit = 2)

        val compared = s1x[1].compareTo(s2x[1])

        // 첫번째 문자열이 더작으면 음수, 같으면 0, 크면 양수 반환
        if (compared == 0) {
            s1x[0].compareTo(s2x[0])
        } else {
            compared
        }
    })

    letterList.addAll(digitList)

    return letterList.toTypedArray()
}

fun main() {
    val input = arrayOf(
        "id1 8 1 5 1",
        "id2 art can",
        "id3 3 6",
        "id4 own kit dig",
        "id5 art zero",
        "id6 art can",
    )
    println(reorderLogFiels(input).map { it }) // [id2 art can, id6 art can, id5 art zero, id4 own kit dig, id1 8 1 5 1, id3 3 6]
}
