fun main(){

    // print (sem "ln") deixa o cursor na mesma linha da pergunta
    print("Symbol? ")

    // readln() lê uma linha (String) e first() devolve o primeiro caracter (Char).
    val symbol: Char = readln().first()

    // when SEM argumento: cada ramo é uma condição booleana completa.
    // As condições são avaliadas por ordem e executa-se o ramo da primeira
    // que for verdadeira. É o equivalente a uma cadeia if / else if / else,
    // mas mais legível
    when {

        // "symbol in '0'..'9'" é um teste de pertença a um CharRange
        // e devolve Boolean (equivale a symbol >= '0' && symbol <= '9')
        symbol in '0'..'9' -> println("Digit")

        // Aqui as condições são combinadas com || (ou) em vez de vírgulas.
        // Em when SEM argumento, a vírgula não é permitida como "ou":
        // é preciso escrever o operador lógico explicitamente
        symbol in 'a'..'z' || symbol in 'A'..'Z' -> println("Letter")

        // Ramo por omissão: qualquer outro caracter
        else -> println("Other Symbol")
    }

}