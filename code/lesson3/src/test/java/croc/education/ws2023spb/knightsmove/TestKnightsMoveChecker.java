package croc.education.ws2023spb.knightsmove;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Тест методов {@link KnightsMoveChecker}.
 * 
 * @author Dmitry Malenok
 */
public class TestKnightsMoveChecker {

    /**
     * Тестируемый обработчик.
     */
    private KnightsMoveChecker checker;

    /**
     * Инициализация, выполняемая перед каждым тестом.
     */
    @BeforeEach
    protected void setUp() {
        checker = KnightsMoveCheckerFactory.get();
    }

    /**
     * Тест метода {@link KnightsMoveChecker#check(ChessPosition[])}.
     * <p/>
     * Проверяет один правильный ход.
     * 
     * @throws IllegalMoveException
     *             при ошибке теста
     */
    @Test
    public void checkOneLegalMove() throws IllegalMoveException {
        // given:

        // when:
        // then:
        checker.check(new String[] { "b1", "c3" });
        checker.check(new String[] { "b1", "a3" });
        checker.check(new String[] { "g8", "h6" });
        checker.check(new String[] { "g8", "f6" });
    }

    /**
     * Тест метода {@link KnightsMoveChecker#check(ChessPosition[])}.
     * <p/>
     * Проверяет обход доски конём по маршруту Яниша.
     * 
     * @throws IllegalMoveException
     *             при ошибке теста
     */
    @Test
    public void checkJaenischSequence() throws IllegalMoveException {
        // given:

        // when:

        // then:
        checker.check(new String[] { "d4",
            "c2",
            "a1",
            "b3",
            "c1",
            "a2",
            "b4",
            "d3",
            "c5",
            "a6",
            "b8",
            "d7",
            "f6",
            "e8",
            "g7",
            "h5",
            "g3",
            "h1",
            "f2",
            "e4",
            "d6",
            "b5",
            "a7",
            "c8",
            "e7",
            "g8",
            "h6",
            "f5",
            "h4",
            "g2",
            "e1",
            "f3",
            "e5",
            "f7",
            "h8",
            "g6",
            "f8",
            "h7",
            "g5",
            "e6",
            "f4",
            "h3",
            "g1",
            "e2",
            "c3",
            "d1",
            "b2",
            "a4",
            "b6",
            "a8",
            "c7",
            "d5",
            "e3",
            "g4",
            "h2",
            "f1",
            "d2",
            "b1",
            "a3",
            "c4",
            "a5",
            "b7",
            "d8",
            "c6" });
    }

    /**
     * Тест метода {@link KnightsMoveChecker#check(ChessPosition[])}.
     * <p/>
     * Проверяет неправильный ход.
     * 
     * @throws IllegalMoveException
     *             при ошибке теста
     */
    @Test
    public void checkWrongMove() {
        // given:

        // when:
        // then:
        assertThatThrownBy(() -> checker.check(new String[] { "b2", "b3" })).isInstanceOf(IllegalMoveException.class)
                .hasMessageContaining("b2 -> b3");
        assertThatThrownBy(() -> checker.check(new String[] { "b2", "c4", "e4", "g6" }))
                .isInstanceOf(IllegalMoveException.class)
                .hasMessageContaining("c4 -> e4");
    }
}
