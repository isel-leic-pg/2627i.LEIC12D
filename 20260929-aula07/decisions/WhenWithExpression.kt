fun main(){

    // print (sem "ln") deixa o cursor na mesma linha da pergunta
    print("Symbol? ")

    // readln() lê uma linha (String) e first() devolve o primeiro caracter (Char).
    // Se o utilizador escrever "abc", fica só com 'a'.
    val symbol: Char = readln().first()

    // Avalia as
    // condições por ordem e executa o ramo da primeira que for verdadeira.
    // Aqui, como when é usado como instrução, o else não é obrigatório,
    // mas é boa prática (se fosse usado como expressão, seria obrigatório)
    when(symbol) {

        // "in" testa se o valor pertence a um intervalo.
        // '0'..'9' é um CharRange com todos os caracteres de '0' a '9'
        in '0'..'9' -> println("Digit")

        // Podem juntar-se várias condições no mesmo ramo, separadas por vírgula
        // (funciona como "ou"): é letra minúscula OU letra maiúscula
        in 'a'..'z', in 'A'..'Z' -> println("Letter")

        // Ramo por omissão: qualquer outro caracter (espaço, '#', '@', 'ç', ...)
        else -> println("Other Symbol")
    }

}