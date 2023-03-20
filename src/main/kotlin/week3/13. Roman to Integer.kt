package week3

fun romanToInt(s: String): Int {
    var sum = 0
    var pre = 0
    var ch = 0.toChar()
    for (element in s) {
        pre = ch.toInt()
        ch = element
        when (ch) {
            'I' -> sum++
            'V' -> sum = if (pre == 'I'.toInt()) sum + 3 else sum + 5
            'X' -> sum = if (pre == 'I'.toInt()) sum + 8 else sum + 10
            'L' -> {
                if (pre == 'V'.toInt()) sum = sum + 40
                sum = if (pre == 'X'.toInt()) sum + 30 else sum + 50
            }

            'C' -> {
                if (pre == 'I'.toInt()) sum = sum + 98
                if (pre == 'V'.toInt()) sum = sum + 90
                sum = if (pre == 'X'.toInt()) sum + 80 else sum + 100
            }

            'D' -> {
                if (pre == 'V'.toInt()) sum = sum + 490
                if (pre == 'X'.toInt()) sum = sum + 480
                if (pre == 'L'.toInt()) sum = sum + 400
                sum = if (pre == 'C'.toInt()) sum + 300 else sum + 500
            }

            'M' -> {
                if (pre == 'I'.toInt()) sum = sum + 998
                if (pre == 'V'.toInt()) sum = sum + 990
                if (pre == 'X'.toInt()) sum = sum + 980
                if (pre == 'L'.toInt()) sum = sum + 900
                sum = if (pre == 'C'.toInt()) sum + 800 else sum + 1000
            }
        }
    }
    return sum
}
