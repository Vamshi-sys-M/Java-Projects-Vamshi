package Projects.TicTacToe.service.winnerDrawCheckStrategy;

public class WinnerCheckStrategyFactory {
    public static WinningCheckStrategy getWinnerCheckStrategy(int dimension){
        //add enum for different strategy names and apply switch case here
        return new OrderOneWinnerCheckStrategy(dimension);
    }
}
