fun main(args: Array<String>){
    val romanNum = "II".toUpperCase()
    var total = 0
    if(romanNum.length > 1) {
        for (i in 1..romanNum.length - 1 step 2) {
            val currentChar: Int = parseRoman(romanNum[i])
            val prevChar: Int = parseRoman(romanNum[i - 1])
            if (currentChar < prevChar || currentChar == prevChar) total += (currentChar + prevChar) else total += (currentChar - prevChar)
        }
    } else total += parseRoman(romanNum[0])
    print(total)
}

fun parseRoman(roman: Char): Int{
    when(roman){
        'I' -> return 1
        'V' -> return 5
        'X' -> return 10
        'L' -> return 50
        'C' -> return 100
        'D' -> return 500
        'M' -> return 1000
        else -> return 0
    }
}
