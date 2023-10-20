package croc.education.ws2023spb.knightsmove;

/**
 * Обработчик, проверяющий, что последовательность клеток на шахматной доске может быть пройдена ходом коня.
 * 
 * @author Dmitry Malenok
 */
public interface KnightsMoveChecker {

    /**
     * Проверяет, что указанная последовательность клеток на шахматной доске может быть пройдена ходом шахматного коня.
     * 
     * @param positions
     *            последовательность клеток на шахматной доске, которую надо обойти от предыдущей клетки к следующей
     * @throws IllegalMoveException
     *             если при перемещении шахматного коня из текущей клетки в следующую происходит с нарушением правил
     */
    void check(String[] positions) throws IllegalMoveException;
}
