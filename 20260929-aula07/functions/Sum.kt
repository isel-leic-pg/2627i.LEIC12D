fun main(){

    // println muda de linha depois de escrever, por isso a resposta
    // do utilizador aparece na linha seguinte
    println("Indica um nº inteiro (a) : ")

    // readln() lê uma linha (String) e toInt() converte-a para Int.
    // (por exemplo "abc", "3.5" ou uma linha vazia)
    val a: Int  = readln().toInt()
    println("Indica um nº inteiro (b) : ")
    val b: Int  = readln().toInt()

    // Versão sem função (comentada): a soma é feita diretamente aqui
    //sem função
    //val res: Int = a + b

    // Versão com função: delega o cálculo em sum(a, b).
    // Os argumentos a e b da chamada são os valores lidos acima
    //com função
    val res: Int = sum(a,b)

    // Template de string: $a, $b e $res são substituídos pelos valores.
    // Exemplo com a = 3 e b = 4: "3 + 4 = 7"
    println("$a + $b = $res")

}

// Versão "clássica" (comentada): corpo em bloco, tipo de retorno
// declarado explicitamente (: Int) e return explícito
//função
/*
fun sum(a: Int, b: Int):Int {
    return a + b
}

 */

// Função de expressão única: o corpo é apenas "= expressão" e o tipo
// de retorno (Int) é inferido pelo compilador.
// Os parâmetros a e b são locais à função: não têm relação com
// as variáveis a e b do main, apesar de terem o mesmo nome
//função expressão
fun sum(a: Int, b: Int) = a + b