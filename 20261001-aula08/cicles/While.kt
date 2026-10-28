fun main() {

    println("iniciou")

    // println muda de linha depois de escrever; a resposta do utilizador
    // aparece, por isso, na linha seguinte
    println("escreve um carater: ")

    // readln() lê uma linha inteira (String) e first() devolve o primeiro
    // caracter (Char). Se o utilizador escrever "abc", fica só com 'a'.
    // "var" porque o valor vai ser reatribuído dentro do ciclo
    var c = readln().first()

    // Ciclo while: repete enquanto a condição for verdadeira.
    // A condição é testada ANTES de cada iteração, por isso, se o primeiro
    // caracter já for 'a', o corpo do ciclo nunca chega a executar.
    // Note-se que 'a' é um Char, não uma String ("a")
    while(c!='a'){
        println("escreve um carater: ")
        c = readln().first()            // lê novo caracter e atualiza c
    }

    // Só chega aqui quando o utilizador escreve um caracter que começa por 'a'
    println("terminou")

}