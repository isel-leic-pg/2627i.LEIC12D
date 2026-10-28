fun main() {

    // Lista imutável de inteiros (List<Int> só permite leitura)
    val lista: List<Int> = listOf(5,6,7,8)
    println(lista)                        // [5, 6, 7, 8]

    // O operador + não altera a lista original: cria uma NOVA lista
    // com os elementos da primeira seguidos dos da segunda
    val lista2 = lista + listOf(9,10,11,12)
    println(lista2)                       // [5, 6, 7, 8, 9, 10, 11, 12]

    // O operador - também devolve uma nova lista, sem as ocorrências indicadas
    // (aqui remove o 7)
    val lista3 = lista2 - listOf(7)
    println(lista3)                       // [5, 6, 8, 9, 10, 11, 12]

    // Ciclo for clássico: percorre cada elemento da lista
    // print (sem "ln") não muda de linha, por isso sai tudo seguido
    for(elem in lista3){
        print(elem)                       // 5 6 8 9 10 11 12 -> "5689101112"
    }

    println()                             // Muda de linha

    // Versão com forEach e parâmetro nomeado (comentada)
    //lista3.forEach { elem -> print(elem) }

    // Versão com forEach usando "it": nome implícito do parâmetro
    // quando a lambda tem apenas um argumento
    lista3.forEach { print(it) }          // 5689101112

    println()

    // forEachIndexed dá acesso ao índice (idx) e ao elemento (elem)
    // "$idx: $elem" é string interpolation (template de strings)
    lista3.forEachIndexed { idx, elem -> println("$idx: $elem") }
    // 0: 5
    // 1: 6
    // 2: 8
    // ...

    // filter: devolve uma nova lista só com os elementos que satisfazem
    // a condição (predicado). Aqui, os números pares da lista original [5,6,7,8]
    //val pares: List<Int> = lista.filter { n -> n%2 == 0 }
    val pares: List<Int> = lista.filter { it%2 == 0 }
    println(pares)                        // [6, 8]

    // map: transforma cada elemento, devolvendo uma nova lista
    // com o resultado da transformação (aqui, o dobro)
    //val dobros: List<Int> = lista.map { elem -> elem*2 }
    val dobros: List<Int> = lista.map { it*2 }
    println(dobros)                       // [10, 12, 14, 16]

    // Encadeamento de operações: primeiro filtra os pares, depois duplica-os
    val dobroDosPares: List<Int> = lista.filter { it%2 == 0 }.map{it*2}

    // Mesmo encadeamento, escrito em várias linhas para melhor legibilidade,
    // terminando com sum(), que soma todos os elementos da lista resultante
    val somatorioDobroDosPares = lista
        .filter { it%2 == 0 }             // [6, 8]
        .map{it*2}                        // [12, 16]
        .sum()                            // 28

    println(dobroDosPares)                // [12, 16]
    println(somatorioDobroDosPares)       // 28

}
