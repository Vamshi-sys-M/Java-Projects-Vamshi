package Projects.TicTacToe.controller;

import Projects.TicTacToe.model.Board;
import Projects.TicTacToe.model.Game;
import Projects.TicTacToe.model.Player;
import Projects.TicTacToe.model.constants.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public Game createGame(Board board, List<Player> players){
        int dimension = board.getDimension();
        Game game = Game.builder()
                .setGameStatus(GameStatus.IN_PROGRESS)
                .setPlayers(players)
                .setBoard(board)
                .setCurrentPlayer(players.get(0))
                .setMoves(new ArrayList<>())
                .setBoardStates(new ArrayList<>())
                .setNumberOfMaps(2*dimension + 3)
                .build();
        return game;
    }

    public void displayBoard(Game game  ){
        game.getBoard().displayBoard();
    }
}
