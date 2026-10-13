fun main(){

    val res1 = increment(2)
    println(res1)

    val fx: (Int)->Int = ::increment

    val res2: Int = fx(2)
    println(res2)

    //funcaoQueRecebeFunção(2, "Incremento", fx)

    //funcaoQueRecebeFunção(2, "Incremento", { a -> a + 1 })

    funcaoQueRecebeFunção(2, "Incremento", { it + 1 })

    val lista = listOf(1,2,3,4)
    //println(lista)

    //for(elem in lista) println(elem)

    println(lista.first())
    println(lista.last())

    lista.forEach { println(it) }

    println()

}

//fun increment(a: Int) : Int {
//    return  a + 1
//}

fun increment(a: Int) = a + 1

fun funcaoQueRecebeFunção(p1: Int, p2: String, fx: (a:Int) -> Int){

    println("O primeiro argumento é: $p1")
    println("O segundo argumento é: $p2")

    var res = fx(p1)

    //println("O terceiro argumento é uma função que faz $p2 e devolve ${fx(p1)} quando passamos $p1 como argumento")
    println("O terceiro argumento é uma função que faz $p2 e devolve $res quando passamos $p1 como argumento")

}
