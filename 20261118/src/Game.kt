import pt.isel.canvas.Canvas
import kotlin.random.Random

/**
 * Estado completo do jogo num dado instante.
 *
 * É imutável: cada operação devolve um novo [Game].
 *
 * @property area dimensões da área de jogo.
 * @property ship nave do jogador.
 * @property alienShots tiros alienígenas atualmente em jogo.
 * @property over indica se o jogo terminou (ainda não é usado pela lógica).
 */
data class Game(
    val area: Area,
    val ship: SpaceShip,
    val alienShots: List<Shot> = emptyList(),
    val over: Boolean = false
)

/**
 * Move a nave para a posição horizontal [newX], limitada à área de jogo.
 *
 * @param newX nova posição do centro da nave.
 * @return novo jogo com a nave movida.
 */
fun Game.moveShip(newX: Int): Game = copy(ship = ship.moveTo(newX, area.width))

/**
 * Faz a nave disparar, se ainda não tiver um tiro em jogo.
 *
 * @return novo jogo com o tiro da nave criado, ou o mesmo jogo se já existia um.
 */
fun Game.shipShoot(): Game = copy(ship = ship.shoot())

/**
 * Tenta criar um tiro alienígena numa posição horizontal aleatória.
 * O disparo só acontece com 50% de probabilidade.
 *
 * @return novo jogo com um tiro alienígena adicional, ou o mesmo jogo se não houve disparo.
 */
fun Game.alienShoot(): Game =
    if (Random.nextBoolean()) copy(alienShots = alienShots + newAlienShot(area.width)) else this

/**
 * Avança o jogo um passo: move a nave e os respetivos tiros e descarta
 * os tiros alienígenas que já saíram pela parte de baixo da área.
 *
 * @return novo jogo no passo seguinte.
 */
fun Game.step(): Game = copy(
    ship = ship.step(),
    alienShots = alienShots
        .map { it.step() }
        .filter { it.y < area.height }
)

/**
 * Apaga o [canvas] e desenha a nave, o tiro da nave e os tiros alienígenas.
 *
 * @param canvas superfície onde desenhar.
 */
fun Game.draw(canvas: Canvas) {
    canvas.erase()
    ship.draw(canvas)
    alienShots.forEach { it.draw(canvas) }
}

