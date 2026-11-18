import pt.isel.canvas.Canvas
import pt.isel.canvas.GREEN
import pt.isel.canvas.YELLOW

/** Largura do corpo da nave, em píxeis. */
const val SHIP_BODY_WIDTH = 50

/** Altura do corpo da nave, em píxeis. */
const val SHIP_BODY_HEIGHT = 10

/** Cor do corpo da nave. */
const val SHIP_BODY_COLOR = GREEN

/** Largura do canhão da nave, em píxeis. */
const val SHIP_GUN_WIDTH = 4

/** Altura do canhão da nave, em píxeis. */
const val SHIP_GUN_HEIGHT = 5

/** Cor do canhão da nave. */
const val SHIP_GUN_COLOR = YELLOW

/** Coordenada vertical do topo do corpo da nave. */
const val SHIP_Y = 450

/**
 * Nave do jogador.
 *
 * @property x coordenada horizontal do centro da nave.
 * @property shot tiro da nave em jogo, ou `null` se não existir nenhum.
 */
data class SpaceShip(val x: Int, val shot: Shot? = null)

/**
 * Move a nave para [newX], garantindo que fica inteira dentro da área.
 *
 * @param newX nova posição desejada para o centro da nave.
 * @param areaWidth largura da área de jogo.
 * @return nova nave com a posição ajustada aos limites.
 */
fun SpaceShip.moveTo(newX: Int, areaWidth: Int): SpaceShip =
    copy(x = newX.coerceIn(SHIP_BODY_WIDTH / 2, areaWidth - SHIP_BODY_WIDTH / 2))

/**
 * Dispara a partir do topo do canhão. Só pode existir um tiro de cada vez.
 *
 * @return nova nave com o tiro criado, ou a mesma nave se já havia um tiro.
 */
fun SpaceShip.shoot(): SpaceShip =
    if (shot != null) this else copy(shot = newShipShot(x, SHIP_Y - SHIP_GUN_HEIGHT))

/**
 * Avança o tiro da nave um passo e descarta-o quando sai totalmente
 * pela parte de cima da área.
 *
 * @return nova nave com o tiro atualizado.
 */
//fun SpaceShip.step(): SpaceShip =
//    copy(shot = shot?.step()?.takeIf { it.y + it.height > 0 })

fun SpaceShip.step(): SpaceShip {
    if (shot == null) return this
    val movedShot = shot.step()
    return if (movedShot.y + movedShot.height > 0) copy(shot = movedShot) else copy(shot = null)
}



/**
 * Desenha o corpo, o canhão e o tiro da nave (se existir).
 *
 * @param canvas superfície onde desenhar.
 */
fun SpaceShip.draw(canvas: Canvas) {
    canvas.drawRect(x - SHIP_BODY_WIDTH / 2, SHIP_Y, SHIP_BODY_WIDTH, SHIP_BODY_HEIGHT, SHIP_BODY_COLOR)
    canvas.drawRect(x - SHIP_GUN_WIDTH / 2, SHIP_Y - SHIP_GUN_HEIGHT, SHIP_GUN_WIDTH, SHIP_GUN_HEIGHT, SHIP_GUN_COLOR)
    shot?.draw(canvas)
}

