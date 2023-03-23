package ryancv.othello;

import com.mrjaffesclass.apcs.messenger.*;
import java.util.HashMap;

public class Model implements MessageHandler {

    // Messaging system for the MVC
    private final Messenger mvcMessaging;

    //Data
    private boolean whoseMove;
    int[][] board;
    boolean[][] legalMoves;


    public Model(Messenger messages) {
      mvcMessaging = messages;
      this.board = new int[8][8];
      this.legalMoves = new boolean[8][8];
    }

    /**
     * Initialize the model here and subscribe to any required messages
     */
    public void init() {
        newGame();
        this.mvcMessaging.subscribe("moveMade", this);
        this.mvcMessaging.subscribe("newGame", this);
    }

    private void newGame() {
        for (int[] board1 : this.board) {
            for (int j = 0; j < this.board[0].length; j++) {
                board1[j] = 0;
            }
        }
        for (boolean[] board1 : this.legalMoves) {
            for (int j = 0; j < this.legalMoves[0].length; j++) {
                board1[j] = false;
            }
        }
        this.board[3][3] = -1;
        this.board[4][4] = -1;
        this.board[3][4] = 1;
        this.board[4][3] = 1;
        this.legalMoves[2][3] = true;
        this.legalMoves[5][4] = true;
        this.legalMoves[4][5] = true;
        this.legalMoves[3][2] = true;
        this.whoseMove = true;
        this.mvcMessaging.notify("turnChange", this.whoseMove);
        this.mvcMessaging.notify("discCount", discs());
        this.mvcMessaging.notify("boardChange", this.board); 
        this.mvcMessaging.notify("legalMoves", this.legalMoves); 

    }
  
    private int isGameOver() {
        for(boolean[] legalRow : legalMoves) {
            for(boolean val : legalRow) {
                if(val) return -10;
            }
        }
	whoseMove ^= true;
	for(boolean[] legalRow : legalMoves) {
            for(boolean val : legalRow) {
                if(val) return -10;
            }
        }
	whoseMove ^= true;
        int[] discs = discs();
        int p1Count = discs[0];
        int p2Count = discs[1];
        if(p1Count > p2Count) {
            return 1;
        } else if (p2Count > p1Count) {
            return -1;
        }
        return 0;
    }
    
    private void updateBoard(int row, int col) {
        int[] pos = new int[2];
        HashMap<Integer, int[]> passed = new HashMap<>();
        int square = this.board[row][col];
        for(int[] dir : Constants.dirs) {
            pos[0] = row;
            pos[1] = col;
            passed = new HashMap<>();
            addVector(dir, pos);
            while(inBounds(pos) && getItem(pos) == square * -1) {
                passed.put(getItem(pos), new int[] {pos[0], pos[1]});
                addVector(dir, pos);
            }
            if(inBounds(pos) && getItem(pos) != 0) {
                updateSquares(pos, new int[] {row, col}, dir);
            }
        }
    }
    
    private void updateSquares(int[] to, int[] from, int[] dir ) {
        addVector(dir, from);
        while(from[0] != to[0] || from[1] != to[1]) {
            this.board[from[0]][from[1]] = this.board[from[0]][from[1]] * -1;
            addVector(dir, from);
        }
    }
    
    private int[] discs() {
        int blackCount = 0;
        int whiteCount = 0;
        for(int[] ro : this.board) {
           for(int num : ro) {
               if(num == 1) blackCount++;
               if(num == -1) whiteCount++;
           }
       }
        return new int[] {blackCount, whiteCount};
    }
    
    private void makeMove(int row, int col) {
        this.board[row][col] = (this.whoseMove) ? 1 : -1;
        updateBoard(row, col);
        for(int i = 0; i < Constants.boardSize; i++) {
            for(int j = 0; j < Constants.boardSize; j++) {
                legalMoves[i][j] = isLegalMove(i, j);
            }
        }
	boolean testLegal = false;
	for(boolean[] legalRow : legalMoves) {
            for(boolean val : legalRow) {
                if(val) testLegal = true;
            }
        }
	
	if(!testLegal) {
		whoseMove ^= whoseMove;
		for(int i = 0; i < Constants.boardSize; i++) {
			for(int j = 0; j < Constants.boardSize; j++) {
				legalMoves[i][j] = isLegalMove(i, j);
			}
		}
	}
	
	
	
       int blackCount = 0;
       int whiteCount = 0;
       
       int[] discs = {blackCount, whiteCount};
       this.mvcMessaging.notify("discCount", discs());
        this.mvcMessaging.notify("boardChange", this.board);
        this.mvcMessaging.notify("legalMoves", this.legalMoves);
        this.whoseMove ^= true;
   
        this.mvcMessaging.notify("turnChange", this.whoseMove);
        if(isGameOver() != -10) {
            mvcMessaging.notify("gameOver", isGameOver());
        }
    }
    
    public boolean isLegalMove(int row, int col) {
        int[] pos = new int[2];
        HashMap<Integer, int[]> passed = new HashMap<>();
        int player = whoseMove ? -1 : 1;
        if(this.board[row][col] != 0) return false;
        for(int[] dir : Constants.dirs) {
            pos[0] = row;
            pos[1] = col;
            passed = new HashMap<>();
            addVector(dir, pos);
            while(inBounds(pos) && getItem(pos) == player * -1) {
                passed.put(getItem(pos), dir);
                addVector(dir, pos);
            }
            if(inBounds(pos)) {
                passed.put(getItem(pos), dir);
            }
            if(passed.containsKey(player) && passed.containsKey(player * -1)) return true;
        }
        return false;
    }
    
    private int getItem(int[] pos) {
        return this.board[pos[0]][pos[1]];
    }
    
    private boolean inBounds(int[] pos) {
        return (pos[0] >= 0 && pos[0] < Constants.boardSize) && (pos[1] >= 0 && pos[1] < Constants.boardSize);
    }
    
    
    private void addVector(int[] vector, int[] pos) {
        pos[0] += vector[0];
        pos[1] += vector[1];
    }
    
    @Override
    public void messageHandler(String messageName, Object messagePayload) {
        if(messageName.equals("moveMade")) {
            String position = (String) messagePayload;
            Integer row = Integer.valueOf(position.substring(0, 1));
            Integer col = Integer.valueOf(position.substring(1, 2));
            if(board[row][col] == 0  && legalMoves[row][col]) {
               makeMove(row, col);
            }
        } else if (messageName.equals("newGame")) {
            newGame();
        }
    }
}
