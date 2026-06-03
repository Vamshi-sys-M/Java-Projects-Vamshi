package Projects.TicTacToe.service.winnerDrawCheckStrategy;

import Projects.TicTacToe.model.Board;
import Projects.TicTacToe.model.Move;
import Projects.TicTacToe.model.Player;

public interface WinningCheckStrategy {
    Player checkWinner(Board board, Move lastMove);
}
