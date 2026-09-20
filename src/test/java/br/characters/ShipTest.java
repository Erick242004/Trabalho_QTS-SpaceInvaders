package br.characters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import br.Game;

/**
 * Casos de teste unitarios da classe br.characters.Ship.
 *
 * Disciplina: Qualidade e Teste de Software
 * Responsavel: Luiz Eduardo (123083019) - Testador da classe Ship
 *
 * A classe de teste fica no pacote br.characters de proposito: os campos x e img
 * sao protected em br.characters.Character e ficam acessiveis dentro do mesmo
 * pacote, o que permite montar os cenarios de teste sem reflection e sem alterar
 * uma linha sequer do SUT.
 */
@DisplayName("Ship - nave do jogador")
class ShipTest {

    /** Ship() posiciona a nave em Game.WIDTH / 2. */
    private static final int X_INICIAL = Game.WIDTH / 2;        // 400

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
}
