fun main() {

    println("iniciou")

    // Ciclo do-while: o corpo executa PRIMEIRO e a condição é testada DEPOIS.
    // Garante, por isso, pelo menos uma iteração, ao contrário do while,
    // onde o corpo pode nunca executar
    do{

        println("escreve um carater: ")

        // readln() lê uma linha (String) e first() devolve o primeiro caracter (Char).
        // "val" é possível aqui porque, a cada iteração, c é uma variável nova
        // (declarada dentro do corpo), em vez de ser reatribuída
        val c = readln().first()

        // A condição vê a variável c declarada dentro do corpo do do-while
        // (em Kotlin isto é permitido, ao contrário de outras linguagens).
        // Repete enquanto c for diferente de 'a' (Char, plicas)
    }while(c!='a')

    // Só chega aqui quando o primeiro caracter da linha escrita for 'a'
    println("terminou")

}