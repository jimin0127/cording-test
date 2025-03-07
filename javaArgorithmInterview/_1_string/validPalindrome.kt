package javaArgorithmInterview._1_string

fun isPalindrome(s: String): Boolean {
    var start = 0
    var end = s.length - 1

    while (start < end) {
        when {
            !Character.isLetterOrDigit(s[start]) -> start++
            !Character.isLetterOrDigit(s[end]) -> end--
            else -> {
                if (Character.toLowerCase(s[start]) != Character.toLowerCase(s[end])) {
                    return false
                }

                start++
                end--
            }
        }
    }

    return true
}

fun main() {
    println(isPalindrome("Do geese see God?"))
    println(isPalindrome("소주 만병만 주소"))
    println(isPalindrome("no palindrome"))
}

