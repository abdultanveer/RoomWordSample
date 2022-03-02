package com.example.roomwordsample.kotlinexs

/*fun main(){
    print("sum of 3 and 5 is ")
    println(sum(3, 5))
    reformat("abdul",wordSeparator = '_')
}*/
//-------------------------------
/*fun sum(a:Int, b:Int): Int{
    return a+b
}*/
//-------------------------------------
fun reformat(
    str: String,
    normalizeCase: Boolean = true,
    upperCaseFirstLetter: Boolean = true,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' ',
) { /*...*/ }


fun demo() {
    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3)) // extension-like call

}



fun calculate(x: Int,
              y: Int,
              z: (Int, Int) -> Int): Int {  // 1
    return z(x, y)                                          // 2
}

fun sum(a: Int, b: Int) = a + b                                     // 3

fun main() {
    val sumResult = calculate(4, 5, ::sum)                          // 4
    val mulResult = calculate(4, 5) { a, b -> a * b }               // 5
    println("sumResult $sumResult, mulResult $mulResult")
}