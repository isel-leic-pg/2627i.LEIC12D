fun main(){

    // Chamada normal a uma função: increment(2) devolve 3
    val res1 = increment(2)

    println(res1)                         // 3

    // Referências para funções: o operador :: permite tratar uma função
    // já declarada como um valor (do tipo função), que pode ser guardado
    // numa variável ou passado como argumento.
    // (Int) -> Int significa "recebe um Int e devolve um Int"
    val fx: (Int) -> Int = ::increment
    val fxIncrement2: (Int) -> Int = ::increment2   // não é usada neste exemplo

    // (Int, Int) -> Int significa "recebe dois Int e devolve um Int"
    val fxSoma: (Int,Int)->Int = ::soma

    // Chamar a função diretamente ou através da variável é equivalente
    println(increment(2))                 // 3
    println(fx(2))                        // 3

    // Função de ordem superior: funcaoQueRecebeFuncao recebe uma função
    // como parâmetro. Aqui passamos uma expressão lambda em vez de uma função com nome.
    //val res2 = funcaoQueRecebeFuncao(2, { n -> n+3 })
    // Com "it" (nome implícito do único parâmetro da lambda):
    val res2 = funcaoQueRecebeFuncao(2, { it + 3 }) //it -> it + 3
    println(res2)                         // 5

    // Overload com dois números e uma função de dois parâmetros.
    // Podia passar-se a referência fxSoma (versão comentada) ou, como aqui,
    // uma expressão lambda com dois parâmetros explícitos (a e b; "it" só serve
    // quando há um único parâmetro).
    //val res3 = funcaoQueRecebeFuncao(3,5, fxSoma)
    val res3 = funcaoQueRecebeFuncao(3,5, { a,b -> a + b })
    println(res3)                         // 8

}


// Versão "clássica" com bloco e return explícito (comentada)
//fun increment(n: Int): Int{
//
//    return n+1
//
//}

// Função de expressão única (single-expression function): o corpo é
// apenas "= expressão" e o tipo de retorno (Int) é inferido pelo compilador
fun increment(n: Int) = n+1
fun increment2(n: Int) = n+2

fun soma(a: Int, b: Int) = a + b

// Função de ordem superior (higher-order function): o segundo parâmetro,
// fx, é uma função do tipo (Int) -> Int. A função limita-se a aplicá-la a n.
fun funcaoQueRecebeFuncao(n: Int, fx: (Int)->Int) : Int{

    return fx(n)

}

// Overload (sobrecarga): mesmo nome, mas assinatura diferente
// (três parâmetros, sendo o último uma função de dois argumentos).
// O compilador escolhe a versão certa consoante os argumentos passados.
//para somar dois números
fun funcaoQueRecebeFuncao(a: Int, b: Int, fx: (Int, Int)->Int) : Int{

    return fx(a, b)

}