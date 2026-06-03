package Projects.TicTacToe.model;

import Projects.TicTacToe.model.constants.BotDifficultyLevel;
import Projects.TicTacToe.model.constants.PlayerType;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Bot(int id, String name, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
