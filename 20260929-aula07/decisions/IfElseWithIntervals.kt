
fun main(){

    // print (sem "ln") deixa o cursor na mesma linha da pergunta
    print("Symbol? ")

    // readln() lê uma linha (String) e first() devolve o primeiro caracter (Char).
    val symbol: Char = readln().first()

    // Primeira condição: o caracter pertence ao intervalo '0'..'9'?
    // Sem chavetas, o if controla apenas a instrução seguinte (o println)
    if(symbol in '0'..'9')
        println("Digit")
    else
    // Só chega aqui se não for dígito. Este segundo if está aninhado
    // dentro do else do primeiro (cadeia if / else if / else)
        if(symbol in 'a'..'z' || symbol in 'A'..'Z')
            println("Letter")
        else
        // Ramo final: nem dígito nem letra (a-z, A-Z)
            println("Other Symbol")

}