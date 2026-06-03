package Projects.TicTacToe.service.BotPlayingStrategy;

import Projects.TicTacToe.model.Board;
import Projects.TicTacToe.model.Player;
import Projects.TicTacToe.model.constants.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        //TODO Create switch case based strategy object creation and return
        return new RandomBotPlayingStrategy();
    }
}
