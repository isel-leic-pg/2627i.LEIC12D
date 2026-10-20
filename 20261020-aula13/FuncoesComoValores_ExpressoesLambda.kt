
fun main(){


    val res1 = increment(2)

    println(res1)

    val fx: (Int) -> Int = ::increment
    val fxIncrement2: (Int) -> Int = ::increment2

    val fxSoma: (Int,Int)->Int = ::soma

    println(increment(2))
    println(fx(2))

    //val res2 = funcaoQueRecebeFuncao(2, { n -> n+3 })
    val res2 = funcaoQueRecebeFuncao(2, { it + 3 }) //it -> it + 3
    println(res2)

    //val res3 = funcaoQueRecebeFuncao(3,5, fxSoma)
    val res3 = funcaoQueRecebeFuncao(3,5, { a,b -> a + b })
    println(res3)



}


//fun increment(n: Int): Int{
//
//    return n+1
//
//}

fun increment(n: Int) = n+1
fun increment2(n: Int) = n+2

fun soma(a: Int, b: Int) = a + b

fun funcaoQueRecebeFuncao(n: Int, fx: (Int)->Int) : Int{

    return fx(n)

}

//para somar dois números
fun funcaoQueRecebeFuncao(a: Int, b: Int, fx: (Int, Int)->Int) : Int{

    return fx(a, b)

}
