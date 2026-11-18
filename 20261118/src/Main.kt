import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas
import pt.isel.canvas.onFinish
import pt.isel.canvas.onStart

/** Largura da janela de jogo, em píxeis. */
const val CANVAS_WIDTH = 700

/** Altura da janela de jogo, em píxeis. */
const val CANVAS_HEIGHT = 500

/** Período, em milissegundos, entre cada atualização e desenho do jogo. */
const val STEP_PERIOD_MS = 14

/** Período, em milissegundos, entre cada tentativa de disparo dos alienígenas. */
const val ALIEN_SHOOT_PERIOD_MS = 250

/**
 * Ponto de entrada da aplicação.
 *
 * Cria a janela e o estado inicial do jogo e liga os eventos:
 * - movimento do rato: move a nave;
 * - clique do rato: a nave dispara;
 * - temporizador rápido: avança o jogo e redesenha;
 * - temporizador lento: os alienígenas tentam disparar.
 */
fun main() {

    onStart {

        val canvas = Canvas(CANVAS_WIDTH, CANVAS_HEIGHT, BLACK)

        var game = Game(
            area = Area(canvas.width, canvas.height),
            ship = SpaceShip(canvas.width / 2),
            over = false
        )

        canvas.onMouseMove { me -> game = game.moveShip(me.x) }

        canvas.onMouseDown { game = game.shipShoot() }

        canvas.onTimeProgress(STEP_PERIOD_MS) {
            game = game.step()
            game.draw(canvas)
        }

        canvas.onTimeProgress(ALIEN_SHOOT_PERIOD_MS) {
            game = game.alienShoot()
        }

    }

    onFinish {  }

}

