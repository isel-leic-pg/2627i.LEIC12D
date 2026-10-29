fun main() {

    // Construtor sem argumentos: usa os valores por omissão (x = 0, y = 0)
    val p1: Point = Point()
    println(p1)            // Point(x=0, y=0): o toString() é gerado automaticamente
    //println(p1.toString()) // equivalente à linha anterior

    // Argumento nomeado: só se indica o y; o x fica com o valor por omissão (0)
    val p2 = Point(y = 10)
    println(p2)            // Point(x=0, y=10)

    // Argumentos posicionais: x = 15, y = 15
    val p3 = Point(15, 15)
    println("p3: $p3")       // Point(x=15, y=15)

    // Outro objeto, distinto de p3, mas com os mesmos valores
    val p4 = Point(15, 15)
    println("p4: $p4")

    // == compara o conteúdo (chama equals()). Numa data class, o equals()
    // compara todas as propriedades do construtor primário. Resultado: true
    println("p3==p4? ${p3 == p4}")

    // === compara a identidade (a referência), isto é, se são o mesmo objeto
    // em memória. p3 e p4 são objetos diferentes. Resultado: false
    println("p3===p4? ${p3 === p4}")

    // p5 não é um objeto novo: é uma segunda referência para o mesmo objeto de p4
    val p5 = p4

    // Mesmo conteúdo, logo true
    println("p4==p5? ${p4 == p5}")

    // Mesma referência, logo também true
    println("p4===p5? ${p4 === p5}")


    val a: Int = 2
    val b: Int = 3

    // Função "normal" (de topo) que recebe os dois valores como parâmetros
    val res1 = addV1(a, b)
    println(res1)            // 5

    // Função de extensão: chama-se como se fosse um método de Int.
    // Aqui, o "this" dentro da função é o valor de a
    val res2 = a.addV2(b)
    println(res2)            // 5

    // As funções de extensão também funcionam sobre literais
    val res3 = 2.addV2(b)
    println(res3)            // 5

    val p6 = Point(2, 2)
    val p7 = Point(4, 4)

    // Soma de pontos com uma função "normal"
    val p8 = add(p6, p7)

    // Soma de pontos com uma função de extensão de Point.
    // O Kotlin escolhe a versão certa de addV2 pelo tipo do recetor (Int ou Point)
    val p9 = p6.addV2(p7)

    println(p8)              // Point(x=6, y=6)
    println(p9)              // Point(x=6, y=6)

    // copy() é gerado pela data class e cria um novo objeto com os mesmos valores
    val shallowCopyP8 = p8.copy()

    // Mesmo conteúdo: true
    println("shallowCopyP8==p8? ${shallowCopyP8 == p8}")

    // Objetos diferentes em memória: false
    println("shallowCopyP8===p8? ${shallowCopyP8 === p8}")

    // copy() permite alterar só algumas propriedades (aqui y = 100); o x mantém-se (6).
    val shallowCopyP8Modified = p8.copy(y = 100)

    // Conteúdo diferente (y é 100 e não 6): false
    println("shallowCopyP8Modified==p8? ${shallowCopyP8Modified == p8}")

    // Objetos diferentes: false
    println("shallowCopyP8Modified===p8? ${shallowCopyP8Modified === p8}")


}

// A data class gera automaticamente equals(), hashCode(), toString(), copy()
// Ambas as propriedades têm valor por omissão 0, pelo que o construtor
// pode ser chamado com 0, 1 ou 2 argumentos
data class Point(val x: Int = 0, val y: Int = 0)

// Função normal com corpo em expressão: o tipo de retorno (Int) é inferido
fun addV1(a: Int, b: Int) = a + b

// Função de extensão: acrescenta addV2 a Int sem alterar a classe Int.
// Dentro dela, "this" é o valor sobre o qual a função é chamada
fun Int.addV2(b: Int) = this + b


// Soma dois pontos componente a componente e devolve um Point novo
// (os pontos originais não são alterados, porque as propriedades são val)
fun add(p1: Point, p2: Point) = Point(p1.x + p2.x, p1.y + p2.y)

// Versão com "this" explícito (comentada)
//fun Point.addV2(p2: Point) = Point(this.x + p2.x, this.y + p2.y)

// Equivalente à anterior: dentro de uma função de extensão, x e y referem-se
// às propriedades do recetor (this), por isso o "this." pode ser omitido
fun Point.addV2(p2: Point) = Point(x + p2.x, y + p2.y)