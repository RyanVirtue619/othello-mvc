package ryancv.othello;

import com.mrjaffesclass.apcs.messenger.*;

public class Model implements MessageHandler {

    // Messaging system for the MVC
    private final Messenger mvcMessaging;

    //Data
    private boolean whoseMove;
    private boolean gameOver;
    String[][] board;


    public Model(Messenger messages) {
      mvcMessaging = messages;
      this.board = new String[8][8];
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
        for (String[] board1 : this.board) {
            for (int j = 0; j < this.board[0].length; j++) {
                board1[j] = "";
            }
        }
        this.board[3][3] = "X";
        this.board[4][4] = "X";
        this.board[3][4] = "O";
        this.board[4][3] = "O";
        this.mvcMessaging.notify("boardChange", this.board); 
        this.whoseMove = true;
        this.gameOver = false;
    }
  
    private String isGameOver() {
        int p1Count = 0;
        int p2Count = 0;
        for (String[] board1 : this.board) {
            for (int j = 0; j < this.board[0].length; j++) {
                if(board1[j].equals("X")) {
                    p1Count++;
                } else if (board1[j].equals("O")) {
                    p2Count++;
                } else {
                    return "";
                }
            }
        }
        if(p1Count > p2Count) {
            return "X";
        } else if (p2Count > p1Count) {
            return "O";
        }
        return "draw";
    }
    
    private void makeMove(int row, int col) {
        this.board[row][col] = (this.whoseMove) ? "X" : "O";
        this.mvcMessaging.notify("boardChange", this.board);
        this.whoseMove ^= true;
        this.mvcMessaging.notify("turnChange", this.whoseMove);
        if(!isGameOver().equals("")) {
            gameOver = true;
            mvcMessaging.notify("gameOver", isGameOver());
        }
    }
    
    @Override
    public void messageHandler(String messageName, Object messagePayload) {
        if(messageName.equals("moveMade")) {
            String position = (String) messagePayload;
            Integer row = Integer.valueOf(position.substring(0, 1));
            Integer col = Integer.valueOf(position.substring(1, 2));
            if(this.board[row][col].equals("")) {
               makeMove(row, col);
            }
        }
    }
}
