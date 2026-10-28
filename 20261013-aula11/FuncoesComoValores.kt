fun main(){

    // Chamada normal à função increment: devolve 3
    val res1 = increment(2)
    println(res1)                         // 3

    // Referência para a função increment através do operador ::
    // O tipo (Int)->Int indica "recebe um Int e devolve um Int"
    val fx: (Int)->Int = ::increment

    // Invocar a variável fx é o mesmo que chamar increment(2)
    val res2: Int = fx(2)
    println(res2)                         // 3

    // Três formas equivalentes de passar a função como argumento:
    // 1) Passando a referência guardada em fx
    //funcaoQueRecebeFunção(2, "Incremento", fx)

    // 2) Lambda com parâmetro explícito
    //funcaoQueRecebeFunção(2, "Incremento", { a -> a + 1 })

    // 3) Lambda com "it" (nome implícito do único parâmetro): a forma mais curta
    funcaoQueRecebeFunção(2, "Incremento", { it + 1 })
    // Output:
    // O primeiro argumento é: 2
    // O segundo argumento é: Incremento
    // O terceiro argumento é uma função que faz Incremento e devolve 3 quando passamos 2 como argumento

    // Lista imutável com 4 elementos
    val lista = listOf(1,2,3,4)
    //println(lista)

    // Ciclo for clássico (comentado), na versão de uma só linha
    //for(elem in lista) println(elem)

    // first() e last() devolvem o primeiro e o último elemento da lista
    // (lançam exceção se a lista estiver vazia)
    println(lista.first())                // 1
    println(lista.last())                 // 4

    // forEach percorre a lista, aplicando a lambda a cada elemento
    lista.forEach { println(it) }         // 1, 2, 3, 4 (um por linha)

    println()                             // Linha em branco

}

// Versão "clássica" com bloco e return explícito (comentada)
//fun increment(a: Int) : Int {
//    return  a + 1
//}

// Função de expressão única: o tipo de retorno (Int) é inferido
fun increment(a: Int) = a + 1

// Função de ordem superior: o terceiro parâmetro, fx, é uma função.
// Note-se que o tipo função pode ter parâmetros nomeados, (a: Int) -> Int,
// o que serve apenas de documentação (o nome "a" não é usado no corpo).
// Não devolve nada (Unit implícito), apenas imprime informação.
fun funcaoQueRecebeFunção(p1: Int, p2: String, fx: (a:Int) -> Int){

    println("O primeiro argumento é: $p1")
    println("O segundo argumento é: $p2")

    // Aplica a função recebida ao primeiro argumento e guarda o resultado
    var res = fx(p1)

    // Versão com expressão ${...} dentro do template (comentada):
    //println("O terceiro argumento é uma função que faz $p2 e devolve ${fx(p1)} quando passamos $p1 como argumento")

    // Versão com a variável res: mais legível, e evita chamar fx duas vezes
    println("O terceiro argumento é uma função que faz $p2 e devolve $res quando passamos $p1 como argumento")

}
