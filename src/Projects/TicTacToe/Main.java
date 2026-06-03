package Projects.TicTacToe;

import Projects.TicTacToe.controller.GameController;
import Projects.TicTacToe.model.Board;
import Projects.TicTacToe.model.Bot;
import Projects.TicTacToe.model.Player;
import Projects.TicTacToe.model.constants.BotDifficultyLevel;
import Projects.TicTacToe.model.constants.PlayerType;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int id = 1;
        Scanner sc = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        GameController gameController = new GameController();
        System.out.println("Welcome to TicTacToe!");
        System.out.println("Please enter the size of the board");
        int dimension = sc.nextInt();
        int noOfPlayers = dimension -1;
        System.out.println("Do you want a bot for the game ? Y for Yes, N for No");
        String botAnswer = sc.next();
        if(botAnswer.equals("Y")) {
            noOfPlayers--;
            Player botPlayer = new Bot(id++, "BOT", 'B', BotDifficultyLevel.MEDIUM);
            players.add(botPlayer);
        }
        // Dimension is 5, then players is 4
        //no bot -> id = 1 ->[1p,2], [2p,3]. [3p,4], [4p.5]
        //if bot is there, id =2 -> [1p,3], [2p,4], [3p,5]
        while(id<dimension) {
            System.out.println("Please enter the name of the player");
            String name = sc.next();
            System.out.println("Please enter the symbol for the player");
            char symbol = sc.next().charAt(0);
            Player newPlayer = new Player(id++, name, symbol, PlayerType.HUMAN);
            players.add(newPlayer);
        }
        Collections.shuffle(players); //shuffling the orders of players
        Board board = new Board(dimension);
        gameController.createGame(board, players);

    }
}
