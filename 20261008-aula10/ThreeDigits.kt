fun main(){

    print("Número com 3 dígitos ? ")

    val number: String = readln().trim()

    //val inverted = "${number[2]}${number[1]}${number[0]}"

    val inverted = number.reversed()

    // val a = number[0].digitToInt()
    // val b = number[1].digitToInt()
    // val c = number[2].digitToInt()
    // val sum = a + b + c

    val sum: Int = number[0].digitToInt() + number[1].digitToInt() + number[2].digitToInt()

    println("O nº ao contrário é $inverted")

    println("A soma dos dígitos $number é $sum")

}