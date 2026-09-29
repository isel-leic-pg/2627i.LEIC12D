
fun main(){

    println("Indica um nº inteiro (a) : ")
    val a: Int  = readln().toInt()
    println("Indica um nº inteiro (b) : ")
    val b: Int  = readln().toInt()

    //sem função
    //val res: Int = a + b

    //com função
    val res: Int = sum(a,b)

    println("$a + $b = $res")

}

//função
/*
fun sum(a: Int, b: Int):Int {
    return a + b
}

 */

//função expressão
fun sum(a: Int, b: Int) = a + b
