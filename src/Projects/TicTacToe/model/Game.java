package Projects.TicTacToe.model;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<Board> boards;
    private int numberOfMaps;

    private Game(Board board, List<Player> players,
                 Player currentPlayer, GameStatus gameStatus,
                 List<Move> moves, List<Board> boards, int numberOfMaps) {
        this.board = board;
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.gameStatus = gameStatus;
        this.moves = moves;
        this.boards = boards;
        this.numberOfMaps = numberOfMaps;
    }

    public static Builder builder(){
        return new Builder();
    }


    public static class Builder {
        private Board board;
        private List<Player> players;
        private Player currentPlayer;
        private GameStatus gameStatus;
        private List<Move> moves;
        private List<Board> boards;
        private int numberOfMaps;


        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public void setCurrentPlayer(Player currentPlayer) {
            this.currentPlayer = currentPlayer;
        }

        public Builder setGameStatus(GameStatus gameStatus) {
            this.gameStatus = gameStatus;
            return this;
        }

        public Builder setMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public Builder setBoards(List<Board> boards) {
            this.boards = boards;
            return this;
        }

        public Builder setNumberOfMaps(int numberOfMaps) {
            this.numberOfMaps = numberOfMaps;
            return this;
        }
        private void validate() {
            //check the number of players  == N-1. if N is the dimension of board
            //check all the players have different symbols
        }

        public Game build() {
            validate();
            return new Game(board, players, currentPlayer, gameStatus, moves, boards, numberOfMaps);
        }
    }
}
