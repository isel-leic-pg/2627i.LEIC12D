import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas
import pt.isel.canvas.WHITE
import pt.isel.canvas.onFinish
import pt.isel.canvas.onStart

// Dimensões da janela de jogo (em pixels)
const val CANVAS_WIDTH: Int = 700
const val CANVAS_HEIGHT: Int = 300

// Raio inicial da bola controlada pelo jogador
const val BALL_RADIUS = 70
// Deslocamento horizontal da bola em cada ciclo de tempo (em pixels).
// O valor é positivo (move para a direita); o sinal inverte-se para mudar de direção.
const val BALL_OFFSET = 5

/**
 * Representa uma bola (ou meteoro) no ecrã.
 * @param x posição horizontal do centro
 * @param y posição vertical do centro
 * @param radius raio do círculo
 * @param color cor do círculo
 * @param offset deslocamento horizontal aplicado a cada ciclo de tempo
 *               (o sinal define a direção do movimento)
 */
data class Ball(val x: Int, val y: Int, val radius: Int, val color: Int, val offset: Int)

/**
 * Estado completo do jogo num dado instante.
 * @param ball bola principal, controlada pelo jogador
 * @param meteors lista de meteoros presentes no ecrã
 * @param score pontuação atual (começa em 0)
 */
data class GameState(val ball: Ball, val meteors: List<Ball>, val score: Int = 0)

// Desenha apenas o círculo da bola, sem limpar o canvas.
// Assim pode ser chamada várias vezes seguidas sem apagar o que já foi desenhado.
fun Canvas.draw(ball: Ball) {
    drawCircle(ball.x, ball.y, ball.radius, ball.color)
}

// Desenha o estado completo do jogo.
// O canvas é limpo uma única vez, e depois desenhados a bola principal e todos os meteoros.
fun Canvas.draw(gameState: GameState) {
    erase()
    draw(gameState.ball)
    gameState.meteors.forEach { draw(it) }
}

fun main() {

    // Função chamada quando a janela é criada.
    // A função deve criar um Canvas e iniciá-lo.
    onStart {

        println("Janela foi criada")

        // Estado inicial: bola preta ao centro do canvas, sem meteoros e pontuação a zero.
        // É uma 'var' porque vai sendo substituído por novos estados (dados imutáveis + copy)
        var gameState = GameState(
            ball = Ball(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, BALL_RADIUS, BLACK, offset = 5),
            meteors = listOf(),
            score = 0
        )

        // Cria a janela de desenho com fundo branco
        val canvas = Canvas(CANVAS_WIDTH, CANVAS_HEIGHT, WHITE)

        // Evento temporal: é chamado a cada 100 ms (10 vezes por segundo)
        canvas.onTimeProgress(100) {

            // Cria uma nova bola movida horizontalmente de acordo com o seu offset
            val newBall = gameState.ball.copy(x = gameState.ball.x + gameState.ball.offset)

            // Atualiza o estado do jogo com a bola na nova posição
            gameState = gameState.copy(ball = newBall)

            // Redesenha o jogo com o novo estado
            canvas.draw(gameState)
        }

        // Evento de teclado: ao premir a tecla 's', inverte o sentido do movimento
        // da bola (troca o sinal do offset), mantendo o resto do estado
        canvas.onKeyPressed {
            if (it.char == 's') {
                gameState = gameState.copy(
                    ball = gameState.ball.copy(offset = -gameState.ball.offset)
                )
            }
        }
    }

    // Executado quando a janela é fechada
    onFinish {
        println("Janela foi fechada")
    }
}