package croc.education.ws2023spb.knightsmove;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

/**
 * Тесты методов {@link ChessPositionParser}.
 * 
 * @author Dmitry Malenok
 */
public class TestChessPositionParser {

    /**
     * Тест метода {@link ChessPositionParser#parse(String)}.
     * <p/>
     * Проверяет правильность преобразования наименования одной из клеток внутри доски.
     */
    @Test
    public void parseSomethingInside() {
        // given:
        final String position = "e4";
        final int expectedX = 4;
        final int expectedY = 3;

        // when:
        final ChessPosition result = ChessPositionParser.parse(position);
        assertThat(result).isNotNull();
        assertThat(result.x()).isEqualTo(expectedX);
        assertThat(result.y()).isEqualTo(expectedY);
        assertThat(result.toString()).isEqualTo(position);
    }

    /**
     * Тест метода {@link ChessPositionParser#parse(String)}.
     * <p/>
     * Проверяет правильность преобразования наименования левой нижней клетки.
     */
    @Test
    public void parseLowerLeftConner() {
        // given:
        final String position = "a1";
        final int expectedX = 0;
        final int expectedY = 0;

        // when:
        final ChessPosition result = ChessPositionParser.parse(position);

        // then:
        assertThat(result).isNotNull();
        assertThat(result.x()).isEqualTo(expectedX);
        assertThat(result.y()).isEqualTo(expectedY);
        assertThat(result.toString()).isEqualTo(position);
    }

    /**
     * Тест метода {@link ChessPositionParser#parse(String)}.
     * <p/>
     * Проверяет правильность преобразования наименования правой верхней клетки.
     */
    @Test
    public void parseUpperRightConner() {
        // given:
        final String position = "h8";
        final int expectedX = 7;
        final int expectedY = 7;

        // when:
        final ChessPosition result = ChessPositionParser.parse(position);

        // then:
        assertThat(result).isNotNull();
        assertThat(result.x()).isEqualTo(expectedX);
        assertThat(result.y()).isEqualTo(expectedY);
        assertThat(result.toString()).isEqualTo(position);
    }

    /**
     * Тест метода {@link ChessPositionParser#parse(String)}.
     * <p/>
     * Проверяет правильность обработки некорректной клетки.
     */
    @Test
    public void parseInvalidPosition() {
        // given:
        final String expectedExceptionClassName = "IllegalPositionException";

        // when:
        // then:
        // В промышленном коде, лучше создать исключение с самого начала и проверить на соответствие его типу.
        assertThatThrownBy(() -> ChessPositionParser.parse("a9")).satisfies(
                exception -> assertThat(exception.getClass().getSimpleName()).isEqualTo(expectedExceptionClassName));
        assertThatThrownBy(() -> ChessPositionParser.parse("a0")).satisfies(
                exception -> assertThat(exception.getClass().getSimpleName()).isEqualTo(expectedExceptionClassName));
        assertThatThrownBy(() -> ChessPositionParser.parse("ao")).satisfies(
                exception -> assertThat(exception.getClass().getSimpleName()).isEqualTo(expectedExceptionClassName));
        assertThatThrownBy(() -> ChessPositionParser.parse("k1")).satisfies(
                exception -> assertThat(exception.getClass().getSimpleName()).isEqualTo(expectedExceptionClassName));
        assertThatThrownBy(() -> ChessPositionParser.parse("a23")).satisfies(
                exception -> assertThat(exception.getClass().getSimpleName()).isEqualTo(expectedExceptionClassName));
    }
}
