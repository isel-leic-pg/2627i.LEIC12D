

fun main(){

    print("Symbol? ")
    val symbol: Char = readln().first()

    if(symbol in '0'..'9')
        println("Digit")
    else
        if(symbol in 'a'..'z' || symbol in 'A'..'Z')
            println("Letter")
        else
            println("Other Symbol")

}