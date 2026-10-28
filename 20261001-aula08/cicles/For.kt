fun main() {

    println("iniciou")

    // 1..10 cria um IntRange: um intervalo fechado, que inclui os dois
    // extremos (1 e 10). É uma sequência de valores, não uma lista em memória:
    // os valores são gerados à medida que são percorridos
    val intervalo = 1..10

    // O for percorre cada elemento do intervalo, do primeiro ao último.
    // "elemento" toma sucessivamente os valores 1, 2, 3, ..., 10
    // e é um val implícito (não pode ser reatribuído dentro do ciclo)
    for(elemento in intervalo){
        println(elemento)               // 1, 2, 3, ..., 10 (um por linha)
    }

    println("terminou")

}