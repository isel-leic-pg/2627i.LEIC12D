
fun main(){

    print("Symbol? ")
    //val symbol: String = readln()
    //val symbol: String = readln().trim()
    val symbol: Char = readln().first()

    println(symbol)

    if(symbol>='0' && symbol<='9')
        println("Digit")
    else
        if(symbol>='a' && symbol<='z' || symbol>='A' && symbol<='Z')
            println("Letter")
        else
            println("Other Symbol")

}