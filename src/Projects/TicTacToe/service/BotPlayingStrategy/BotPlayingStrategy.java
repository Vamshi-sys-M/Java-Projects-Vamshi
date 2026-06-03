package Projects.TicTacToe.service.BotPlayingStrategy;

import Projects.TicTacToe.model.Board;
import Projects.TicTacToe.model.Move;
import Projects.TicTacToe.model.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}
