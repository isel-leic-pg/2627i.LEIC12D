
fun main(){

    print("Symbol? ")
    val symbol: Char = readln().first()

    when {
        symbol in '0'..'9' -> println("Digit")
        symbol in 'a'..'z' || symbol in 'A'..'Z' -> println("Letter")
        else -> println("Other Symbol")
    }

}