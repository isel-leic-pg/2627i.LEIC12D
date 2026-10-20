fun main() {

    val lista: List<Int> = listOf(5,6,7,8)
    println(lista)

    val lista2 = lista + listOf(9,10,11,12)
    println(lista2)

    val lista3 = lista2 - listOf(7)
    println(lista3)

    for(elem in lista3){
        print(elem)
    }

    println()

    //lista3.forEach { elem -> print(elem) }
    lista3.forEach { print(it) }

    println()

    lista3.forEachIndexed { idx, elem -> println("$idx: $elem")}

    // na lista [5,6,7,8]
    //val pares: List<Int> = lista.filter { n -> n%2 == 0 }
    val pares: List<Int> = lista.filter { it%2 == 0 }
    println(pares)

    //val dobros: List<Int> = lista.map { elem -> elem*2 }
    val dobros: List<Int> = lista.map { it*2 }
    println(dobros)

    val dobroDosPares: List<Int> = lista.filter { it%2 == 0 }.map{it*2}
    val somatorioDobroDosPares = lista
        .filter { it%2 == 0 }
        .map{it*2}
        .sum()

    println(dobroDosPares)
    println(somatorioDobroDosPares)

}
