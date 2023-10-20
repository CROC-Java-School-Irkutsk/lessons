package croc.education.ws2023spb.knightsmove;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Тест логики работы приложения.
 *
 * @author Dmitry Malenok
 */
public class TestApplication {

    /**
     * Исходный основной поток приложения.
     */
    private final PrintStream standardOut = System.out;

    /**
     * Поток, в который записывается вывод приложения в консоль.
     */
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    /**
     * Инициализация, запускаемая перед каждым тестом.
     */
    @BeforeEach
    protected void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor, true, UTF_8));
    }

    /**
     * Восстановление, запускаемое после каждого теста.
     */
    @AfterEach
    protected void tearDown() {
        System.setOut(standardOut);
    }

    /**
     * Тест запуска приложения с неверным ходом в последовательности ходов.
     */
    @Test
    public void testIllegalMove() {
        // given:
        final String[] moves = new String[] { "g8", "e7", "e6" };

        // when:
        Application.main(moves);

        // then:
        assertThat(outputStreamCaptor.toString(UTF_8)).isEqualTo("конь так не ходит: e7 -> e6");
    }

    /**
     * Тест запуска приложения с верной последовательностью ходов.
     */
    @Test
    public void testLegalMoves() {
        // given:
        final String[] moves = new String[] { "g8", "e7", "c8" };

        // when:
        Application.main(moves);

        // then:
        assertThat(outputStreamCaptor.toString(UTF_8)).isEqualTo("OK");
    }
}
