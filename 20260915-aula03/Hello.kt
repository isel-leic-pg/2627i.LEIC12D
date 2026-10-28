fun main(){

	// println escreve o texto e muda de linha, por isso a resposta
	// do utilizador aparece na linha seguinte
	println("Indica o teu nome:")

	// readln() lê uma linha inteira do teclado e devolve uma String.
	// O tipo (: String) podia ser omitido, pois o compilador infere-o.
	val name: String = readln()

	// Template de string: $name é substituído pelo valor da variável.
	// Exemplo com input "Rui": "Olá, Rui!"
	// Para inserir expressões usa-se ${...}, por exemplo ${name.uppercase()}
	println("Olá, $name!")

}