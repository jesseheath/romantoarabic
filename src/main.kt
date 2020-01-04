fun main(){
    var romanNum: String
    var nums: List<Int?>
    var total: Int = 0
    do {
        romanNum = readLine()!!.toUpperCase()
        nums = romanNum.map {parseRoman(it)}
    } while(checkNulls(nums) || nums.isEmpty())

    val numsFilt = nums.filterNotNull()

    if(numsFilt.size == 1) total = numsFilt[0] else{
        for(i in 1..nums.size-1 step 2){
            val currentNum = numsFilt[i]
            val prevNum = numsFilt[i-1]
            total += if(currentNum <= prevNum) (currentNum+prevNum) else (currentNum-prevNum)
        }
    }

    println(total)

}

fun checkNulls(list: List<Int?>): Boolean{
    for(element in list){
        if(element == null) return true
    }
    return false
}

fun parseRoman(roman: Char): Int?{
    when(roman){
        'I' -> return 1
        'V' -> return 5
        'X' -> return 10
        'L' -> return 50
        'C' -> return 100
        'D' -> return 500
        'M' -> return 1000
        else -> return null
    }
}