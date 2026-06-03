package Projects.TicTacToe.service.BotPlayingStrategy;

import Projects.TicTacToe.exception.GameDrawException;
import Projects.TicTacToe.model.Board;
import Projects.TicTacToe.model.Cell;
import Projects.TicTacToe.model.Move;
import Projects.TicTacToe.model.Player;
import Projects.TicTacToe.model.constants.CellState;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {
    public Move makeMove(Board board, Player player) {
        List<List<Cell>> matrix = board.getMatrix();
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.get(i).size(); j++){
                if(matrix.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    matrix.get(i).get(j).setCellState(CellState.FILLED);
                    matrix.get(i).get(j).setPlayer(player);
                    return new Move(player, matrix.get(i).get(j));
                }
            }
        }
        throw new GameDrawException("All the cells are full");
    }
}
