
fun main(){

    print("Symbol? ")
    val symbol: Char = readln().first()

    when(symbol) {
        in '0'..'9' -> println("Digit")
        in 'a'..'z', in 'A'..'Z' -> println("Letter")
        else -> println("Other Symbol")
    }

}