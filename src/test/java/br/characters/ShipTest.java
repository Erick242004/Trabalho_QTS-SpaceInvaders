package br.characters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.Game;

/**
 * Casos de teste unitarios da classe br.characters.Ship.
 *
 * Disciplina: Qualidade e Teste de Software
 * Responsavel: Luiz Eduardo (123083019) - Testador da classe Ship
 *
 * Os valores usados sao de fronteira (e nao valores "do meio") porque o criterio
 * cobrado e Todas-Arestas, e porque sao eles que matam os mutantes de troca de
 * operador relacional gerados pelo PIT.
 *
 * A classe de teste fica no pacote br.characters de proposito: os campos x e img
 * sao protected em br.characters.Character e ficam acessiveis dentro do mesmo
 * pacote, o que permite montar os cenarios de fronteira sem reflection e sem
 * alterar uma linha sequer do SUT.
 */
@DisplayName("Ship - nave do jogador")
class ShipTest {

    /** Ship() posiciona a nave em Game.WIDTH / 2. */
    private static final int X_INICIAL = Game.WIDTH / 2;        // 400

    /** Campo privado movex de Ship. */
    private static final int VELOCIDADE = 6;

    /** Valor fixo devolvido por getShipWidth(), que NAO e a largura da imagem. */
    private static final int LARGURA_NAVE = 100;

    /** Maior x em que a nave ainda cabe inteira na tela. */
    private static final int X_MAXIMO = Game.WIDTH - LARGURA_NAVE;   // 700

    /** Dimensoes reais do arquivo src/space-ship.png. */
    private static final int LARGURA_IMG = 444;
    private static final int ALTURA_IMG = 512;

    private Ship ship;

    @BeforeEach
    void preparar() {
        ship = new Ship();
    }

    @Nested
    @DisplayName("Construtor")
    class Construtor {

        @Test
        @DisplayName("posiciona a nave no centro horizontal da tela")
        void posicionaNoCentroHorizontal() {
            assertEquals(X_INICIAL, ship.getX());
        }

        @Test
        @DisplayName("comeca com a lista de tiros criada e vazia")
        void comecaSemTiros() {
            assertNotNull(ship.getShots(), "getShots() nao pode devolver null");
            assertTrue(ship.getShots().isEmpty());
        }

        @Test
        @DisplayName("carrega src/space-ship.png")
        void carregaImagemDaNave() {
            // load() engole a IOException e deixa img nulo. Se este teste falhar,
            // o diretorio de trabalho do surefire nao e a raiz do projeto, porque
            // Ship.load() usa new File("src/space-ship.png"), que e um caminho relativo.
            assertNotNull(ship.img, "imagem nao carregada: confira o workingDirectory do surefire");
            assertEquals(LARGURA_IMG, ship.img.getWidth());
            assertEquals(ALTURA_IMG, ship.img.getHeight());
        }
    }

    @Nested
    @DisplayName("moveShip(int)")
    class MoveShip {

        @Test
        @DisplayName("valor 1 desloca a nave 6 pixels para a direita")
        void moveParaDireita() {
            ship.moveShip(1);

            assertEquals(X_INICIAL + VELOCIDADE, ship.getX());
        }

        @Test
        @DisplayName("valor -1 desloca a nave 6 pixels para a esquerda")
        void moveParaEsquerda() {
            ship.moveShip(-1);

            assertEquals(X_INICIAL - VELOCIDADE, ship.getX());
        }

        @ParameterizedTest(name = "valor {0}")
        @ValueSource(ints = { 0, 2, -2, 7, -99 })
        @DisplayName("qualquer valor diferente de 1 e -1 nao move a nave")
        void valorNeutroNaoMove(int valor) {
            ship.moveShip(valor);

            assertEquals(X_INICIAL, ship.getX());
        }

        @Test
        @DisplayName("aplica os limites da tela depois de mover para a direita")
        void aplicaLimiteAoMoverParaDireita() {
            ship.x = X_MAXIMO - 1;   // 699: o passo de 6 estoura a borda direita

            ship.moveShip(1);

            assertEquals(X_MAXIMO, ship.getX());
        }

        @Test
        @DisplayName("aplica os limites da tela depois de mover para a esquerda")
        void aplicaLimiteAoMoverParaEsquerda() {
            ship.x = VELOCIDADE - 3;   // 3: o passo de 6 estoura a borda esquerda

            ship.moveShip(-1);

            assertEquals(0, ship.getX());
        }
    }

    @Nested
    @DisplayName("limits() - analise de valor limite")
    class Limites {

        @Test
        @DisplayName("x = 699 esta dentro da tela e nao e corrigido")
        void abaixoDoLimiteDireito() {
            ship.x = X_MAXIMO - 1;

            ship.limits();

            assertEquals(X_MAXIMO - 1, ship.getX());
        }

        @Test
        @DisplayName("x = 700 e a fronteira exata e nao e corrigido")
        void exatamenteNoLimiteDireito() {
            // 700 + 100 > 800 e falso: a nave encosta na borda mas ainda cabe.
            ship.x = X_MAXIMO;

            ship.limits();

            assertEquals(X_MAXIMO, ship.getX());
        }

        @Test
        @DisplayName("x = 701 ultrapassa a borda direita e volta para 700")
        void acimaDoLimiteDireito() {
            ship.x = X_MAXIMO + 1;

            ship.limits();

            assertEquals(X_MAXIMO, ship.getX());
        }

        @Test
        @DisplayName("x = 1 esta dentro da tela e nao e corrigido")
        void acimaDoLimiteEsquerdo() {
            ship.x = 1;

            ship.limits();

            assertEquals(1, ship.getX());
        }

        @Test
        @DisplayName("x = 0 e a fronteira exata e nao e corrigido")
        void exatamenteNoLimiteEsquerdo() {
            ship.x = 0;

            ship.limits();

            assertEquals(0, ship.getX());
        }

        @Test
        @DisplayName("x = -1 ultrapassa a borda esquerda e volta para 0")
        void abaixoDoLimiteEsquerdo() {
            ship.x = -1;

            ship.limits();

            assertEquals(0, ship.getX());
        }
    }
}
