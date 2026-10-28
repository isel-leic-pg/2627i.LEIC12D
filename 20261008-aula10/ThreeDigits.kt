fun main(){

    // print (sem "ln") deixa o cursor na mesma linha, para o utilizador
    // escrever a resposta logo a seguir à pergunta
    print("Número com 3 dígitos ? ")

    // readln() lê uma linha do teclado e devolve uma String
    // (lança exceção se não houver input, ao contrário de readlnOrNull()).
    // trim() remove espaços no início e no fim
    val number: String = readln().trim()

    // Forma manual de inverter: acede a cada caracter pelo índice [0], [1], [2]
    // e junta-os por ordem inversa através de um template de string
    //val inverted = "${number[2]}${number[1]}${number[0]}"

    // reversed() inverte a sequência de caracteres e devolve uma nova String.
    // Funciona com qualquer número de dígitos, não só com 3
    val inverted = number.reversed()

    // Versão passo a passo (comentada): number[i] devolve um Char e
    // digitToInt() converte o caracter '7' no inteiro 7.
    // Atenção: .toInt() num Char devolveria o código ASCII/Unicode ('7' -> 55)
    // val a = number[0].digitToInt()
    // val b = number[1].digitToInt()
    // val c = number[2].digitToInt()
    // val sum = a + b + c

    // Versão compacta: converte e soma os três dígitos numa só expressão
    val sum: Int = number[0].digitToInt() + number[1].digitToInt() + number[2].digitToInt()

    // Exemplo com input 123: "O nº ao contrário é 321"
    println("O nº ao contrário é $inverted")

    // Exemplo com input 123: "A soma dos dígitos 123 é 6"
    println("A soma dos dígitos $number é $sum")

}