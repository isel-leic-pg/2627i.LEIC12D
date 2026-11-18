import pt.isel.canvas.Canvas
import pt.isel.canvas.RED
import pt.isel.canvas.WHITE
import kotlin.random.Random

/** Largura do tiro da nave, em píxeis. */
const val SHIP_SHOT_WIDTH = 4

/** Altura do tiro da nave, em píxeis. */
const val SHIP_SHOT_HEIGHT = 7

/** Velocidade do tiro da nave, em píxeis por passo (a subir). */
const val SHIP_SHOT_SPEED = 4

/** Cor do tiro da nave. */
const val SHIP_SHOT_COLOR = WHITE

/** Largura do tiro alienígena, em píxeis. */
const val ALIEN_SHOT_WIDTH = 4

/** Altura do tiro alienígena, em píxeis. */
const val ALIEN_SHOT_HEIGHT = 7

/** Velocidade mínima do tiro alienígena, em píxeis por passo (inclusive). */
const val ALIEN_MIN_SPEED = 1

/** Velocidade máxima do tiro alienígena, em píxeis por passo (inclusive). */
const val ALIEN_MAX_SPEED = 4

/** Cor do tiro alienígena. */
const val ALIEN_SHOT_COLOR = RED

/**
 * Tiro, quer da nave quer dos alienígenas.
 *
 * @property x coordenada horizontal da aresta esquerda.
 * @property y coordenada vertical da aresta superior.
 * @property width largura, em píxeis.
 * @property height altura, em píxeis.
 * @property color cor do tiro.
 * @property speed deslocamento vertical por passo: negativo sobe, positivo desce.
 */
data class Shot(val x: Int, val y: Int, val width: Int, val height: Int, val color: Int, val speed: Int)

/**
 * Cria um tiro da nave, centrado no canhão e a subir.
 *
 * @param gunX coordenada horizontal do centro do canhão.
 * @param gunTopY coordenada vertical do topo do canhão.
 * @return novo tiro da nave.
 */
fun newShipShot(gunX: Int, gunTopY: Int): Shot =
    Shot(gunX - SHIP_SHOT_WIDTH / 2, gunTopY, SHIP_SHOT_WIDTH, SHIP_SHOT_HEIGHT, SHIP_SHOT_COLOR, -SHIP_SHOT_SPEED)

/**
 * Cria um tiro alienígena logo acima da área, numa posição horizontal
 * aleatória (sempre inteiro dentro da área) e com velocidade aleatória
 * entre [ALIEN_MIN_SPEED] e [ALIEN_MAX_SPEED].
 *
 * @param areaWidth largura da área de jogo.
 * @return novo tiro alienígena a descer.
 */
fun newAlienShot(areaWidth: Int): Shot =
    Shot(
        x = Random.nextInt(0, areaWidth - ALIEN_SHOT_WIDTH + 1),
        y = -ALIEN_SHOT_HEIGHT,
        width = ALIEN_SHOT_WIDTH,
        height = ALIEN_SHOT_HEIGHT,
        color = ALIEN_SHOT_COLOR,
        speed = Random.nextInt(ALIEN_MIN_SPEED, ALIEN_MAX_SPEED + 1)
    )

/**
 * Desloca o tiro verticalmente segundo a sua [Shot.speed].
 *
 * @return novo tiro na posição seguinte.
 */
fun Shot.step(): Shot = copy(y = y + speed)

/**
 * Desenha o tiro como um retângulo.
 *
 * @param canvas superfície onde desenhar.
 */
fun Shot.draw(canvas: Canvas) = canvas.drawRect(x, y, width, height, color)

