package week3

fun addBinary(a: String, b: String): String {
    val sb = StringBuilder()
    var i = a.length - 1
    var j = b.length - 1
    var carry = 0
    while (i >= 0 || j >= 0) {
        var sum = carry
        if (i >= 0) {
            sum += a[i] - '0'
            i--
        }
        if (j >= 0) {
            sum += b[j] - '0'
            j--
        }
        carry = if (sum > 1) 1 else 0
        sb.append(sum % 2)
    }
    if (carry != 0)
        sb.append(carry)

    return sb.reverse().toString()
}