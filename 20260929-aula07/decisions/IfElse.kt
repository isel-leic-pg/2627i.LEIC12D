fun main(){

    // print (sem "ln") deixa o cursor na mesma linha da pergunta
    print("Symbol? ")

    // Alternativas anteriores (comentadas): ler como String.
    // readln() devolve a linha inteira; trim() remove espaços nas pontas.
    // Como a seguir se comparam caracteres, é preferível trabalhar com Char
    //val symbol: String = readln()
    //val symbol: String = readln().trim()

    // first() devolve o primeiro caracter (Char) da linha lida.
    val symbol: Char = readln().first()

    // Mostra o caracter lido (útil para confirmar qual foi o escolhido,
    // já que só o primeiro caracter da linha é considerado)
    println(symbol)

    // Comparações diretas entre Char: os caracteres são comparados pelo seu
    // código Unicode, e os dígitos '0'..'9' têm códigos consecutivos.
    // symbol>='0' && symbol<='9' é o equivalente manual de symbol in '0'..'9'
    if(symbol>='0' && symbol<='9')
        println("Digit")
    else
    // Precedência dos operadores: && avalia-se antes de ||, por isso a
    // condição lê-se como (minúscula) OU (maiúscula), sem precisar de
    // parênteses. Mesmo assim, parênteses tornariam a leitura mais clara:
    // (symbol>='a' && symbol<='z') || (symbol>='A' && symbol<='Z')
        if(symbol>='a' && symbol<='z' || symbol>='A' && symbol<='Z')
            println("Letter")
        else
        // Nem dígito nem letra (a-z, A-Z)
            println("Other Symbol")

}