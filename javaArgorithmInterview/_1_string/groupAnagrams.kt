package javaArgorithmInterview._1_string

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val results = mutableMapOf<String, MutableList<String>>()

    for (s in strs) {
        val sortedStr = s.toCharArray().sorted().joinToString("")
        results.getOrPut(sortedStr) { mutableListOf() }
        results[sortedStr]!!.add(s)
    }

//    return listOf(results.keys.toList())

    return ArrayList<List<String>>(results.values)
}

fun main() {
    val input = arrayOf("eat", "tea", "tan", "ate", "ant", "cat")

    println(groupAnagrams(input)) // [[eat, tea, ate], [tan, ant], [cat]]
}
