package Projects.TicTacToe.service.winnerDrawCheckStrategy;

import Projects.TicTacToe.model.Board;
import Projects.TicTacToe.model.Move;
import Projects.TicTacToe.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinnerCheckStrategy implements WinningCheckStrategy {
    private int dimension;
    private int eligibleMapsForWinning;
    private List<HashMap<Character,Integer>> rowHashMapList;
    private List<HashMap<Character,Integer>> colHashMapList;
    private HashMap<Character,Integer> leftDiagonalMap;
    private HashMap<Character,Integer> rightDiagonalMap;
     private HashMap<Character,Integer> cornerMap;

    public OrderOneWinnerCheckStrategy(int dimension) {
        this.dimension = dimension;
        this.eligibleMapsForWinning = (2 * dimension+3);
        this.rowHashMapList = new ArrayList<>();
        this.colHashMapList = new ArrayList<>();
        this.leftDiagonalMap = new HashMap<>();
        this.rightDiagonalMap = new HashMap<>();
        this.cornerMap = new HashMap<>();
        for(int i = 0; i < dimension; i++){
            rowHashMapList.add(new HashMap<>());
            colHashMapList.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        boolean winnerResult = checkAndUpdateRowMap(row, symbol)
                            || checkAndUpdateColMap(col, symbol)
                            || (checkLeftDiagonal(row, col) && checkAndUpdateLeftDiagonalMap(symbol))
                            || (checkRightDiagonal(row, col) && checkAndUpdateRightDiagonalMap(symbol))
                            || (checkCorner(row, col) && checkAndUpdateCornerMap(symbol));
        if(winnerResult){
            return player;
        }
        else {
            checkForDraw(); //if draw throw exception //TODO Update all methods for draw condition check
            return null;
        }
    }

    private boolean checkLeftDiagonal(int row, int col){
        return row == col;
    }

    private boolean checkRightDiagonal(int row, int col){
        return row + col == dimension-1;
    }
    private boolean checkCorner(int row, int col){
        return (row ==0 && col ==0)
                || (row == dimension -1 && col == dimension-1)
                || (row == 0 && col == dimension-1)
                || (row == dimension -1 && col == 0);
    }

    private boolean checkAndUpdateRowMap(int row, char symbol){
        HashMap<Character,Integer> rowMap = rowHashMapList.get(row);
        if(rowMap.containsKey(symbol)){
            rowMap.put(symbol, rowMap.get(symbol) + 1);
            if(rowMap.keySet().size()>1){ //map is not eligible for creating a winner as it contains more than 1 symbol, so symbol frequency would never become == dimension
                eligibleMapsForWinning--;
            }
            return rowMap.get(symbol) == dimension;
        }
        else{
            rowMap.put(symbol,1);
        }
        return false;
    }
    private boolean checkAndUpdateColMap(int col, char symbol){
        HashMap<Character,Integer> colMap = rowHashMapList.get(col);
        if(colMap.containsKey(symbol)){
            colMap.put(symbol, colMap.get(symbol) + 1);
            return colMap.get(symbol) == dimension;
        }
        else{
            colMap.put(symbol,1);
        }
        return false;
    }

    private boolean checkAndUpdateLeftDiagonalMap(char symbol){
        if(leftDiagonalMap.containsKey(symbol)){
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol) + 1);
            return leftDiagonalMap.get(symbol) == dimension;
        }
        else{
            leftDiagonalMap.put(symbol,1);
        }
        return false;
    }

    private boolean checkAndUpdateRightDiagonalMap(char symbol){
        if(rightDiagonalMap.containsKey(symbol)){
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol) + 1);
            return rightDiagonalMap.get(symbol) == dimension;
        }
        else{
            rightDiagonalMap.put(symbol,1);
        }
        return false;
    }

    private boolean checkAndUpdateCornerMap(char symbol){
        if(cornerMap.containsKey(symbol)){
            cornerMap.put(symbol, cornerMap.get(symbol) + 1);
            return cornerMap.get(symbol) == 4;
        }
        else{
            cornerMap.put(symbol,1);
        }
        return false;
    }

    private boolean checkForDraw(){
        return eligibleMapsForWinning==0;

    }
}

/*  Algorithm for checking winner

    Steps for checking winner:
        1.  Create N HashMaps for rows
        2.  Create N HashMaps for columns
        3.  Create 2 HashMaps for diagonals
        Basis on last move played by the player
        4.  Go to respective hashmaps, and update the frequency of that symbols
        5.  If the updated frequency becomes equal to N, then declare winner
        6.  Also check for all 4 corners

 */
