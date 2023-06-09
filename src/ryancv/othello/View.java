package ryancv.othello;
import com.mrjaffesclass.apcs.messenger.*;
import java.awt.Color;
import javax.swing.JButton;
/**
 * MVC Template
 * This is a template of an MVC framework used by APCS for the 
 * LandMine project (and others)
 * @author Roger Jaffe
 * @version 1.0
 * 
 */
public class View extends javax.swing.JFrame implements MessageHandler {

  private final Messenger mvcMessaging;
  private final JButton[][] buttons;
  /**
   * Creates a new view
   * @param messages mvcMessaging object
   */
  public View(Messenger messages) {
    mvcMessaging = messages;   // Save the calling controller instance
    
    initComponents();           // Create and init the GUI components
    buttons = new JButton[][] { { jButton_00, jButton_01, jButton_02, jButton_03, jButton_04, jButton_05, jButton_06, jButton_07 },
                                { jButton_10, jButton_11, jButton_12, jButton_13, jButton_14, jButton_15, jButton_16, jButton_17 },
                                { jButton_20, jButton_21, jButton_22, jButton_23, jButton_24, jButton_25, jButton_26, jButton_27 },
                                { jButton_30, jButton_31, jButton_32, jButton_33, jButton_34, jButton_35, jButton_36, jButton_37 },
                                { jButton_40, jButton_41, jButton_42, jButton_43, jButton_44, jButton_45, jButton_46, jButton_47 },
                                { jButton_50, jButton_51, jButton_52, jButton_53, jButton_54, jButton_55, jButton_56, jButton_57 },
                                { jButton_60, jButton_61, jButton_62, jButton_63, jButton_64, jButton_65, jButton_66, jButton_67 },
                                { jButton_70, jButton_71, jButton_72, jButton_73, jButton_74, jButton_75, jButton_76, jButton_77 }};
  }
  
  /**
   * Initialize the model here and subscribe
   * to any required messages
   */
  public void init() {
    // Subscribe to messages here
    this.mvcMessaging.subscribe("boardChange", this);
    this.mvcMessaging.subscribe("gameOver", this);
    this.mvcMessaging.subscribe("turnChange", this);
    this.mvcMessaging.subscribe("legalMoves", this);
    this.mvcMessaging.subscribe("discCount", this);
  }
  
  private Color getColor(int num) {
      if(num == 1) return Color.black;
      if(num == -1) return Color.white;
      return Color.green.darker().darker();
  }
  
  
  private void updateButton(int row, int col, JButton button, int[][] board) {
      button.setForeground(getColor(board[row][col]));
      button.setBackground(getColor(board[row][col]));
      button.setOpaque(true);
      button.setBorderPainted(false);
      button.setToolTipText(null);
  }
  
  private void updateLegal(int row, int col , JButton button, boolean[][] legals) {
      if(legals[row][col]) button.setBackground(button.getBackground().brighter().brighter());
  }
  
    @Override
    public void messageHandler(String messageName, Object messagePayload) {
      switch (messageName) {
          case "boardChange":
              {
                  int[][] board = (int[][]) messagePayload;
                  for(int i = 0; i < buttons.length; i++) {
                      for(int j = 0; j < buttons.length; j++) {
                          updateButton(i, j, buttons[i][j], board);
                      }
                  }     break;
              }
          case "legalMoves":
              {
                  boolean[][] board = (boolean[][]) messagePayload;
                  for(int i = 0; i < buttons.length; i++) {
                      for(int j = 0; j < buttons.length; j++) {
                          updateLegal(i, j, buttons[i][j], board);
                      }
                  }     break;
              }
          case "turnChange":
              jLabel1.setText(((boolean) messagePayload ? "Black to move" : "White to move"));
              break;
          case "gameOver":
              int winner = (int) messagePayload;
              switch (winner) {
                  case 1:
                      jLabel1.setText("Black Wins!");
                      break;
                  case -1:
                      jLabel1.setText("White Wins!");
                      break;
                  default:
                      jLabel1.setText("Its a draw!");
                      break;
              } break;
          case "discCount":
              int blackDiscs = ((int[]) messagePayload)[0];
              int whiteDiscs = ((int[]) messagePayload)[1];
              jLabel3.setText("Black Pieces: " + blackDiscs);
              jLabel2.setText("White Pieces: " + whiteDiscs);
              break;
          default:
              break;
      }
    }

  /**
   * Instantiate an object with the field number that was clicked (1 or 2) and
   * the direction that the number should go (up or down)messfageHandler
   * @param fieldNumber 1 or 2 for the field being modified
   * @param direction this.UP (1) or this.DOWN (-1), constants defined above
   * @return the HashMap payload to be sent with the message
   */

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton_06 = new javax.swing.JButton();
        jButton_15 = new javax.swing.JButton();
        jButton_31 = new javax.swing.JButton();
        jButton_37 = new javax.swing.JButton();
        jButton_30 = new javax.swing.JButton();
        jButton_32 = new javax.swing.JButton();
        jButton_34 = new javax.swing.JButton();
        jButton_20 = new javax.swing.JButton();
        jButton_16 = new javax.swing.JButton();
        jButton_21 = new javax.swing.JButton();
        jButton_11 = new javax.swing.JButton();
        jButton_23 = new javax.swing.JButton();
        jButton_60 = new javax.swing.JButton();
        jButton_00 = new javax.swing.JButton();
        jButton_61 = new javax.swing.JButton();
        jButton_22 = new javax.swing.JButton();
        jButton_63 = new javax.swing.JButton();
        jButton_17 = new javax.swing.JButton();
        jButton_62 = new javax.swing.JButton();
        jButton_24 = new javax.swing.JButton();
        jButton_64 = new javax.swing.JButton();
        jButton_01 = new javax.swing.JButton();
        jButton_65 = new javax.swing.JButton();
        jButton_67 = new javax.swing.JButton();
        jButton_66 = new javax.swing.JButton();
        jButton_74 = new javax.swing.JButton();
        jButton_75 = new javax.swing.JButton();
        jButton_77 = new javax.swing.JButton();
        jButton_76 = new javax.swing.JButton();
        jButton_70 = new javax.swing.JButton();
        jButton_71 = new javax.swing.JButton();
        jButton_73 = new javax.swing.JButton();
        jButton_72 = new javax.swing.JButton();
        jButton_44 = new javax.swing.JButton();
        jButton_52 = new javax.swing.JButton();
        jButton_45 = new javax.swing.JButton();
        jButton_47 = new javax.swing.JButton();
        jButton_46 = new javax.swing.JButton();
        jButton_54 = new javax.swing.JButton();
        jButton_55 = new javax.swing.JButton();
        jButton_57 = new javax.swing.JButton();
        jButton_40 = new javax.swing.JButton();
        jButton_56 = new javax.swing.JButton();
        jButton_41 = new javax.swing.JButton();
        jButton_50 = new javax.swing.JButton();
        jButton_43 = new javax.swing.JButton();
        jButton_25 = new javax.swing.JButton();
        jButton_10 = new javax.swing.JButton();
        jButton_27 = new javax.swing.JButton();
        jButton_03 = new javax.swing.JButton();
        jButton_26 = new javax.swing.JButton();
        jButton_35 = new javax.swing.JButton();
        jButton_12 = new javax.swing.JButton();
        jButton_51 = new javax.swing.JButton();
        jButton_02 = new javax.swing.JButton();
        jButton_42 = new javax.swing.JButton();
        jButton_36 = new javax.swing.JButton();
        jButton_53 = new javax.swing.JButton();
        jButton_14 = new javax.swing.JButton();
        jButton_33 = new javax.swing.JButton();
        jButton_04 = new javax.swing.JButton();
        jButton_13 = new javax.swing.JButton();
        jButton_05 = new javax.swing.JButton();
        jButton_07 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Othello - RyanV");
        setFocusable(false);
        setName(""); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Black to Move");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("White Pieces");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Black Pieces");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Othello");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel5.setText("By Ryan V");

        jButton1.setBackground(new java.awt.Color(160, 220, 160));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton1.setText("New Game");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setMaximumSize(new java.awt.Dimension(150, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(150, 23));
        jButton1.setOpaque(true);
        jButton1.setPreferredSize(new java.awt.Dimension(150, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGame(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jButton_06.setBackground(new java.awt.Color(79, 110, 63));
        jButton_06.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_06.setToolTipText("");
        jButton_06.setFocusPainted(false);
        jButton_06.setFocusable(false);
        jButton_06.setName("06"); // NOI18N
        jButton_06.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_06.setRequestFocusEnabled(false);
        jButton_06.setRolloverEnabled(false);
        jButton_06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_15.setBackground(new java.awt.Color(79, 110, 63));
        jButton_15.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_15.setToolTipText("");
        jButton_15.setFocusPainted(false);
        jButton_15.setFocusable(false);
        jButton_15.setName("15"); // NOI18N
        jButton_15.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_15.setRequestFocusEnabled(false);
        jButton_15.setRolloverEnabled(false);
        jButton_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_31.setBackground(new java.awt.Color(79, 110, 63));
        jButton_31.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_31.setToolTipText("");
        jButton_31.setFocusPainted(false);
        jButton_31.setFocusable(false);
        jButton_31.setName("31"); // NOI18N
        jButton_31.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_31.setRequestFocusEnabled(false);
        jButton_31.setRolloverEnabled(false);
        jButton_31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_37.setBackground(new java.awt.Color(79, 110, 63));
        jButton_37.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_37.setToolTipText("");
        jButton_37.setFocusPainted(false);
        jButton_37.setFocusable(false);
        jButton_37.setName("37"); // NOI18N
        jButton_37.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_37.setRequestFocusEnabled(false);
        jButton_37.setRolloverEnabled(false);
        jButton_37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_30.setBackground(new java.awt.Color(79, 110, 63));
        jButton_30.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_30.setToolTipText("");
        jButton_30.setFocusPainted(false);
        jButton_30.setFocusable(false);
        jButton_30.setName("30"); // NOI18N
        jButton_30.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_30.setRequestFocusEnabled(false);
        jButton_30.setRolloverEnabled(false);
        jButton_30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_32.setBackground(new java.awt.Color(79, 110, 63));
        jButton_32.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_32.setToolTipText("");
        jButton_32.setFocusPainted(false);
        jButton_32.setFocusable(false);
        jButton_32.setName("32"); // NOI18N
        jButton_32.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_32.setRequestFocusEnabled(false);
        jButton_32.setRolloverEnabled(false);
        jButton_32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_34.setBackground(new java.awt.Color(79, 110, 63));
        jButton_34.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_34.setForeground(new java.awt.Color(255, 255, 255));
        jButton_34.setToolTipText("");
        jButton_34.setFocusPainted(false);
        jButton_34.setFocusable(false);
        jButton_34.setName("34"); // NOI18N
        jButton_34.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_34.setRequestFocusEnabled(false);
        jButton_34.setRolloverEnabled(false);
        jButton_34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_20.setBackground(new java.awt.Color(79, 110, 63));
        jButton_20.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_20.setToolTipText("");
        jButton_20.setFocusPainted(false);
        jButton_20.setFocusable(false);
        jButton_20.setName("20"); // NOI18N
        jButton_20.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_20.setRequestFocusEnabled(false);
        jButton_20.setRolloverEnabled(false);
        jButton_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_16.setBackground(new java.awt.Color(79, 110, 63));
        jButton_16.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_16.setToolTipText("");
        jButton_16.setFocusPainted(false);
        jButton_16.setFocusable(false);
        jButton_16.setName("16"); // NOI18N
        jButton_16.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_16.setRequestFocusEnabled(false);
        jButton_16.setRolloverEnabled(false);
        jButton_16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_21.setBackground(new java.awt.Color(79, 110, 63));
        jButton_21.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_21.setToolTipText("");
        jButton_21.setFocusPainted(false);
        jButton_21.setFocusable(false);
        jButton_21.setName("21"); // NOI18N
        jButton_21.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_21.setRequestFocusEnabled(false);
        jButton_21.setRolloverEnabled(false);
        jButton_21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_11.setBackground(new java.awt.Color(79, 110, 63));
        jButton_11.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_11.setToolTipText("");
        jButton_11.setFocusPainted(false);
        jButton_11.setFocusable(false);
        jButton_11.setName("11"); // NOI18N
        jButton_11.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_11.setRequestFocusEnabled(false);
        jButton_11.setRolloverEnabled(false);
        jButton_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_23.setBackground(new java.awt.Color(79, 110, 63));
        jButton_23.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_23.setToolTipText("");
        jButton_23.setFocusPainted(false);
        jButton_23.setFocusable(false);
        jButton_23.setName("23"); // NOI18N
        jButton_23.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_23.setRequestFocusEnabled(false);
        jButton_23.setRolloverEnabled(false);
        jButton_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_60.setBackground(new java.awt.Color(79, 110, 63));
        jButton_60.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_60.setToolTipText("");
        jButton_60.setFocusPainted(false);
        jButton_60.setFocusable(false);
        jButton_60.setName("60"); // NOI18N
        jButton_60.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_60.setRequestFocusEnabled(false);
        jButton_60.setRolloverEnabled(false);
        jButton_60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_00.setBackground(new java.awt.Color(79, 110, 63));
        jButton_00.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_00.setToolTipText("");
        jButton_00.setFocusPainted(false);
        jButton_00.setFocusable(false);
        jButton_00.setName("00"); // NOI18N
        jButton_00.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_00.setRequestFocusEnabled(false);
        jButton_00.setRolloverEnabled(false);
        jButton_00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_61.setBackground(new java.awt.Color(79, 110, 63));
        jButton_61.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_61.setToolTipText("");
        jButton_61.setFocusPainted(false);
        jButton_61.setFocusable(false);
        jButton_61.setName("61"); // NOI18N
        jButton_61.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_61.setRequestFocusEnabled(false);
        jButton_61.setRolloverEnabled(false);
        jButton_61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_22.setBackground(new java.awt.Color(79, 110, 63));
        jButton_22.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_22.setToolTipText("");
        jButton_22.setFocusPainted(false);
        jButton_22.setFocusable(false);
        jButton_22.setName("22"); // NOI18N
        jButton_22.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_22.setRequestFocusEnabled(false);
        jButton_22.setRolloverEnabled(false);
        jButton_22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_63.setBackground(new java.awt.Color(79, 110, 63));
        jButton_63.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_63.setToolTipText("");
        jButton_63.setFocusPainted(false);
        jButton_63.setFocusable(false);
        jButton_63.setName("63"); // NOI18N
        jButton_63.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_63.setRequestFocusEnabled(false);
        jButton_63.setRolloverEnabled(false);
        jButton_63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_17.setBackground(new java.awt.Color(79, 110, 63));
        jButton_17.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_17.setToolTipText("");
        jButton_17.setFocusPainted(false);
        jButton_17.setFocusable(false);
        jButton_17.setName("17"); // NOI18N
        jButton_17.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_17.setRequestFocusEnabled(false);
        jButton_17.setRolloverEnabled(false);
        jButton_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_62.setBackground(new java.awt.Color(79, 110, 63));
        jButton_62.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_62.setToolTipText("");
        jButton_62.setFocusPainted(false);
        jButton_62.setFocusable(false);
        jButton_62.setName("62"); // NOI18N
        jButton_62.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_62.setRequestFocusEnabled(false);
        jButton_62.setRolloverEnabled(false);
        jButton_62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_24.setBackground(new java.awt.Color(79, 110, 63));
        jButton_24.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_24.setToolTipText("");
        jButton_24.setFocusPainted(false);
        jButton_24.setFocusable(false);
        jButton_24.setName("24"); // NOI18N
        jButton_24.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_24.setRequestFocusEnabled(false);
        jButton_24.setRolloverEnabled(false);
        jButton_24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_64.setBackground(new java.awt.Color(79, 110, 63));
        jButton_64.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_64.setToolTipText("");
        jButton_64.setFocusPainted(false);
        jButton_64.setFocusable(false);
        jButton_64.setName("64"); // NOI18N
        jButton_64.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_64.setRequestFocusEnabled(false);
        jButton_64.setRolloverEnabled(false);
        jButton_64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_01.setBackground(new java.awt.Color(79, 110, 63));
        jButton_01.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_01.setToolTipText("");
        jButton_01.setFocusPainted(false);
        jButton_01.setFocusable(false);
        jButton_01.setName("01"); // NOI18N
        jButton_01.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_01.setRequestFocusEnabled(false);
        jButton_01.setRolloverEnabled(false);
        jButton_01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_65.setBackground(new java.awt.Color(79, 110, 63));
        jButton_65.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_65.setToolTipText("");
        jButton_65.setFocusPainted(false);
        jButton_65.setFocusable(false);
        jButton_65.setName("65"); // NOI18N
        jButton_65.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_65.setRequestFocusEnabled(false);
        jButton_65.setRolloverEnabled(false);
        jButton_65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_67.setBackground(new java.awt.Color(79, 110, 63));
        jButton_67.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_67.setToolTipText("");
        jButton_67.setFocusPainted(false);
        jButton_67.setFocusable(false);
        jButton_67.setName("67"); // NOI18N
        jButton_67.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_67.setRequestFocusEnabled(false);
        jButton_67.setRolloverEnabled(false);
        jButton_67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_66.setBackground(new java.awt.Color(79, 110, 63));
        jButton_66.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_66.setToolTipText("");
        jButton_66.setFocusPainted(false);
        jButton_66.setFocusable(false);
        jButton_66.setName("66"); // NOI18N
        jButton_66.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_66.setRequestFocusEnabled(false);
        jButton_66.setRolloverEnabled(false);
        jButton_66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_74.setBackground(new java.awt.Color(79, 110, 63));
        jButton_74.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_74.setToolTipText("");
        jButton_74.setFocusPainted(false);
        jButton_74.setFocusable(false);
        jButton_74.setName("74"); // NOI18N
        jButton_74.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_74.setRequestFocusEnabled(false);
        jButton_74.setRolloverEnabled(false);
        jButton_74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_75.setBackground(new java.awt.Color(79, 110, 63));
        jButton_75.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_75.setToolTipText("");
        jButton_75.setFocusPainted(false);
        jButton_75.setFocusable(false);
        jButton_75.setName("75"); // NOI18N
        jButton_75.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_75.setRequestFocusEnabled(false);
        jButton_75.setRolloverEnabled(false);
        jButton_75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_77.setBackground(new java.awt.Color(79, 110, 63));
        jButton_77.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_77.setToolTipText("");
        jButton_77.setFocusPainted(false);
        jButton_77.setFocusable(false);
        jButton_77.setName("77"); // NOI18N
        jButton_77.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_77.setRequestFocusEnabled(false);
        jButton_77.setRolloverEnabled(false);
        jButton_77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_76.setBackground(new java.awt.Color(79, 110, 63));
        jButton_76.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_76.setToolTipText("");
        jButton_76.setFocusPainted(false);
        jButton_76.setFocusable(false);
        jButton_76.setName("76"); // NOI18N
        jButton_76.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_76.setRequestFocusEnabled(false);
        jButton_76.setRolloverEnabled(false);
        jButton_76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_70.setBackground(new java.awt.Color(79, 110, 63));
        jButton_70.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_70.setToolTipText("");
        jButton_70.setFocusPainted(false);
        jButton_70.setFocusable(false);
        jButton_70.setName("70"); // NOI18N
        jButton_70.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_70.setRequestFocusEnabled(false);
        jButton_70.setRolloverEnabled(false);
        jButton_70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_71.setBackground(new java.awt.Color(79, 110, 63));
        jButton_71.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_71.setToolTipText("");
        jButton_71.setFocusPainted(false);
        jButton_71.setFocusable(false);
        jButton_71.setName("71"); // NOI18N
        jButton_71.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_71.setRequestFocusEnabled(false);
        jButton_71.setRolloverEnabled(false);
        jButton_71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_73.setBackground(new java.awt.Color(79, 110, 63));
        jButton_73.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_73.setToolTipText("");
        jButton_73.setFocusPainted(false);
        jButton_73.setFocusable(false);
        jButton_73.setName("73"); // NOI18N
        jButton_73.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_73.setRequestFocusEnabled(false);
        jButton_73.setRolloverEnabled(false);
        jButton_73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_72.setBackground(new java.awt.Color(79, 110, 63));
        jButton_72.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_72.setToolTipText("");
        jButton_72.setFocusPainted(false);
        jButton_72.setFocusable(false);
        jButton_72.setName("72"); // NOI18N
        jButton_72.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_72.setRequestFocusEnabled(false);
        jButton_72.setRolloverEnabled(false);
        jButton_72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_44.setBackground(new java.awt.Color(79, 110, 63));
        jButton_44.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_44.setToolTipText("");
        jButton_44.setFocusPainted(false);
        jButton_44.setFocusable(false);
        jButton_44.setName("44"); // NOI18N
        jButton_44.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_44.setRequestFocusEnabled(false);
        jButton_44.setRolloverEnabled(false);
        jButton_44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_52.setBackground(new java.awt.Color(79, 110, 63));
        jButton_52.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_52.setToolTipText("");
        jButton_52.setFocusPainted(false);
        jButton_52.setFocusable(false);
        jButton_52.setName("52"); // NOI18N
        jButton_52.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_52.setRequestFocusEnabled(false);
        jButton_52.setRolloverEnabled(false);
        jButton_52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_45.setBackground(new java.awt.Color(79, 110, 63));
        jButton_45.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_45.setToolTipText("");
        jButton_45.setFocusPainted(false);
        jButton_45.setFocusable(false);
        jButton_45.setName("45"); // NOI18N
        jButton_45.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_45.setRequestFocusEnabled(false);
        jButton_45.setRolloverEnabled(false);
        jButton_45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_47.setBackground(new java.awt.Color(79, 110, 63));
        jButton_47.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_47.setToolTipText("");
        jButton_47.setFocusPainted(false);
        jButton_47.setFocusable(false);
        jButton_47.setName("47"); // NOI18N
        jButton_47.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_47.setRequestFocusEnabled(false);
        jButton_47.setRolloverEnabled(false);
        jButton_47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_46.setBackground(new java.awt.Color(79, 110, 63));
        jButton_46.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_46.setToolTipText("");
        jButton_46.setFocusPainted(false);
        jButton_46.setFocusable(false);
        jButton_46.setName("46"); // NOI18N
        jButton_46.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_46.setRequestFocusEnabled(false);
        jButton_46.setRolloverEnabled(false);
        jButton_46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_54.setBackground(new java.awt.Color(79, 110, 63));
        jButton_54.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_54.setToolTipText("");
        jButton_54.setFocusPainted(false);
        jButton_54.setFocusable(false);
        jButton_54.setName("54"); // NOI18N
        jButton_54.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_54.setRequestFocusEnabled(false);
        jButton_54.setRolloverEnabled(false);
        jButton_54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_55.setBackground(new java.awt.Color(79, 110, 63));
        jButton_55.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_55.setToolTipText("");
        jButton_55.setFocusPainted(false);
        jButton_55.setFocusable(false);
        jButton_55.setName("55"); // NOI18N
        jButton_55.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_55.setRequestFocusEnabled(false);
        jButton_55.setRolloverEnabled(false);
        jButton_55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_57.setBackground(new java.awt.Color(79, 110, 63));
        jButton_57.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_57.setToolTipText("");
        jButton_57.setFocusPainted(false);
        jButton_57.setFocusable(false);
        jButton_57.setName("57"); // NOI18N
        jButton_57.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_57.setRequestFocusEnabled(false);
        jButton_57.setRolloverEnabled(false);
        jButton_57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_40.setBackground(new java.awt.Color(79, 110, 63));
        jButton_40.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_40.setToolTipText("");
        jButton_40.setFocusPainted(false);
        jButton_40.setFocusable(false);
        jButton_40.setName("40"); // NOI18N
        jButton_40.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_40.setRequestFocusEnabled(false);
        jButton_40.setRolloverEnabled(false);
        jButton_40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_56.setBackground(new java.awt.Color(79, 110, 63));
        jButton_56.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_56.setToolTipText("");
        jButton_56.setFocusPainted(false);
        jButton_56.setFocusable(false);
        jButton_56.setName("56"); // NOI18N
        jButton_56.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_56.setRequestFocusEnabled(false);
        jButton_56.setRolloverEnabled(false);
        jButton_56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_41.setBackground(new java.awt.Color(79, 110, 63));
        jButton_41.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_41.setToolTipText("");
        jButton_41.setFocusPainted(false);
        jButton_41.setFocusable(false);
        jButton_41.setName("41"); // NOI18N
        jButton_41.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_41.setRequestFocusEnabled(false);
        jButton_41.setRolloverEnabled(false);
        jButton_41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_50.setBackground(new java.awt.Color(79, 110, 63));
        jButton_50.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_50.setToolTipText("");
        jButton_50.setFocusPainted(false);
        jButton_50.setFocusable(false);
        jButton_50.setName("50"); // NOI18N
        jButton_50.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_50.setRequestFocusEnabled(false);
        jButton_50.setRolloverEnabled(false);
        jButton_50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_43.setBackground(new java.awt.Color(79, 110, 63));
        jButton_43.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_43.setToolTipText("");
        jButton_43.setFocusPainted(false);
        jButton_43.setFocusable(false);
        jButton_43.setName("43"); // NOI18N
        jButton_43.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_43.setRequestFocusEnabled(false);
        jButton_43.setRolloverEnabled(false);
        jButton_43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_25.setBackground(new java.awt.Color(79, 110, 63));
        jButton_25.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_25.setToolTipText("");
        jButton_25.setFocusPainted(false);
        jButton_25.setFocusable(false);
        jButton_25.setName("25"); // NOI18N
        jButton_25.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_25.setRequestFocusEnabled(false);
        jButton_25.setRolloverEnabled(false);
        jButton_25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_10.setBackground(new java.awt.Color(79, 110, 63));
        jButton_10.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_10.setToolTipText("");
        jButton_10.setFocusPainted(false);
        jButton_10.setFocusable(false);
        jButton_10.setName("10"); // NOI18N
        jButton_10.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_10.setRequestFocusEnabled(false);
        jButton_10.setRolloverEnabled(false);
        jButton_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_27.setBackground(new java.awt.Color(79, 110, 63));
        jButton_27.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_27.setToolTipText("");
        jButton_27.setFocusPainted(false);
        jButton_27.setFocusable(false);
        jButton_27.setName("27"); // NOI18N
        jButton_27.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_27.setRequestFocusEnabled(false);
        jButton_27.setRolloverEnabled(false);
        jButton_27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_03.setBackground(new java.awt.Color(79, 110, 63));
        jButton_03.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_03.setToolTipText("");
        jButton_03.setFocusPainted(false);
        jButton_03.setFocusable(false);
        jButton_03.setName("03"); // NOI18N
        jButton_03.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_03.setRequestFocusEnabled(false);
        jButton_03.setRolloverEnabled(false);
        jButton_03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_26.setBackground(new java.awt.Color(79, 110, 63));
        jButton_26.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_26.setToolTipText("");
        jButton_26.setFocusPainted(false);
        jButton_26.setFocusable(false);
        jButton_26.setName("26"); // NOI18N
        jButton_26.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_26.setRequestFocusEnabled(false);
        jButton_26.setRolloverEnabled(false);
        jButton_26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_35.setBackground(new java.awt.Color(79, 110, 63));
        jButton_35.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_35.setToolTipText("");
        jButton_35.setFocusPainted(false);
        jButton_35.setFocusable(false);
        jButton_35.setName("35"); // NOI18N
        jButton_35.setOpaque(true);
        jButton_35.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_35.setRequestFocusEnabled(false);
        jButton_35.setRolloverEnabled(false);
        jButton_35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_12.setBackground(new java.awt.Color(79, 110, 63));
        jButton_12.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_12.setToolTipText("");
        jButton_12.setFocusPainted(false);
        jButton_12.setFocusable(false);
        jButton_12.setName("12"); // NOI18N
        jButton_12.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_12.setRequestFocusEnabled(false);
        jButton_12.setRolloverEnabled(false);
        jButton_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_51.setBackground(new java.awt.Color(79, 110, 63));
        jButton_51.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_51.setToolTipText("");
        jButton_51.setFocusPainted(false);
        jButton_51.setFocusable(false);
        jButton_51.setName("51"); // NOI18N
        jButton_51.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_51.setRequestFocusEnabled(false);
        jButton_51.setRolloverEnabled(false);
        jButton_51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_02.setBackground(new java.awt.Color(79, 110, 63));
        jButton_02.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_02.setToolTipText("");
        jButton_02.setFocusPainted(false);
        jButton_02.setFocusable(false);
        jButton_02.setName("02"); // NOI18N
        jButton_02.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_02.setRequestFocusEnabled(false);
        jButton_02.setRolloverEnabled(false);
        jButton_02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_42.setBackground(new java.awt.Color(79, 110, 63));
        jButton_42.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_42.setToolTipText("");
        jButton_42.setFocusPainted(false);
        jButton_42.setFocusable(false);
        jButton_42.setName("42"); // NOI18N
        jButton_42.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_42.setRequestFocusEnabled(false);
        jButton_42.setRolloverEnabled(false);
        jButton_42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_36.setBackground(new java.awt.Color(79, 110, 63));
        jButton_36.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_36.setToolTipText("");
        jButton_36.setFocusPainted(false);
        jButton_36.setFocusable(false);
        jButton_36.setName("36"); // NOI18N
        jButton_36.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_36.setRequestFocusEnabled(false);
        jButton_36.setRolloverEnabled(false);
        jButton_36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_53.setBackground(new java.awt.Color(79, 110, 63));
        jButton_53.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_53.setToolTipText("");
        jButton_53.setFocusPainted(false);
        jButton_53.setFocusable(false);
        jButton_53.setName("53"); // NOI18N
        jButton_53.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_53.setRequestFocusEnabled(false);
        jButton_53.setRolloverEnabled(false);
        jButton_53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_14.setBackground(new java.awt.Color(79, 110, 63));
        jButton_14.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_14.setToolTipText("");
        jButton_14.setFocusPainted(false);
        jButton_14.setFocusable(false);
        jButton_14.setName("14"); // NOI18N
        jButton_14.setOpaque(true);
        jButton_14.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_14.setRequestFocusEnabled(false);
        jButton_14.setRolloverEnabled(false);
        jButton_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_33.setBackground(new java.awt.Color(79, 110, 63));
        jButton_33.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_33.setToolTipText("");
        jButton_33.setFocusPainted(false);
        jButton_33.setFocusable(false);
        jButton_33.setName("33"); // NOI18N
        jButton_33.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_33.setRequestFocusEnabled(false);
        jButton_33.setRolloverEnabled(false);
        jButton_33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_04.setBackground(new java.awt.Color(79, 110, 63));
        jButton_04.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_04.setToolTipText("");
        jButton_04.setAutoscrolls(true);
        jButton_04.setFocusPainted(false);
        jButton_04.setFocusable(false);
        jButton_04.setName("04"); // NOI18N
        jButton_04.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_04.setRequestFocusEnabled(false);
        jButton_04.setRolloverEnabled(false);
        jButton_04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_13.setBackground(new java.awt.Color(79, 110, 63));
        jButton_13.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_13.setToolTipText("");
        jButton_13.setFocusPainted(false);
        jButton_13.setFocusable(false);
        jButton_13.setName("13"); // NOI18N
        jButton_13.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_13.setRequestFocusEnabled(false);
        jButton_13.setRolloverEnabled(false);
        jButton_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_05.setBackground(new java.awt.Color(79, 110, 63));
        jButton_05.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_05.setToolTipText("");
        jButton_05.setFocusPainted(false);
        jButton_05.setFocusable(false);
        jButton_05.setName("05"); // NOI18N
        jButton_05.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_05.setRequestFocusEnabled(false);
        jButton_05.setRolloverEnabled(false);
        jButton_05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        jButton_07.setBackground(new java.awt.Color(79, 110, 63));
        jButton_07.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButton_07.setToolTipText("");
        jButton_07.setFocusPainted(false);
        jButton_07.setFocusable(false);
        jButton_07.setName("07"); // NOI18N
        jButton_07.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_07.setRequestFocusEnabled(false);
        jButton_07.setRolloverEnabled(false);
        jButton_07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton_50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_03, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton_32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton_00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton_03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton_32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_70, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClick
        JButton button = (JButton) evt.getSource();
        this.mvcMessaging.notify("moveMade", button.getName());
    }//GEN-LAST:event_onClick

    private void newGame(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGame
        this.mvcMessaging.notify("newGame");
    }//GEN-LAST:event_newGame

  /**
   * @param args the command line arguments
   */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_00;
    private javax.swing.JButton jButton_01;
    private javax.swing.JButton jButton_02;
    private javax.swing.JButton jButton_03;
    private javax.swing.JButton jButton_04;
    private javax.swing.JButton jButton_05;
    private javax.swing.JButton jButton_06;
    private javax.swing.JButton jButton_07;
    private javax.swing.JButton jButton_10;
    private javax.swing.JButton jButton_11;
    private javax.swing.JButton jButton_12;
    private javax.swing.JButton jButton_13;
    private javax.swing.JButton jButton_14;
    private javax.swing.JButton jButton_15;
    private javax.swing.JButton jButton_16;
    private javax.swing.JButton jButton_17;
    private javax.swing.JButton jButton_20;
    private javax.swing.JButton jButton_21;
    private javax.swing.JButton jButton_22;
    private javax.swing.JButton jButton_23;
    private javax.swing.JButton jButton_24;
    private javax.swing.JButton jButton_25;
    private javax.swing.JButton jButton_26;
    private javax.swing.JButton jButton_27;
    private javax.swing.JButton jButton_30;
    private javax.swing.JButton jButton_31;
    private javax.swing.JButton jButton_32;
    private javax.swing.JButton jButton_33;
    private javax.swing.JButton jButton_34;
    private javax.swing.JButton jButton_35;
    private javax.swing.JButton jButton_36;
    private javax.swing.JButton jButton_37;
    private javax.swing.JButton jButton_40;
    private javax.swing.JButton jButton_41;
    private javax.swing.JButton jButton_42;
    private javax.swing.JButton jButton_43;
    private javax.swing.JButton jButton_44;
    private javax.swing.JButton jButton_45;
    private javax.swing.JButton jButton_46;
    private javax.swing.JButton jButton_47;
    private javax.swing.JButton jButton_50;
    private javax.swing.JButton jButton_51;
    private javax.swing.JButton jButton_52;
    private javax.swing.JButton jButton_53;
    private javax.swing.JButton jButton_54;
    private javax.swing.JButton jButton_55;
    private javax.swing.JButton jButton_56;
    private javax.swing.JButton jButton_57;
    private javax.swing.JButton jButton_60;
    private javax.swing.JButton jButton_61;
    private javax.swing.JButton jButton_62;
    private javax.swing.JButton jButton_63;
    private javax.swing.JButton jButton_64;
    private javax.swing.JButton jButton_65;
    private javax.swing.JButton jButton_66;
    private javax.swing.JButton jButton_67;
    private javax.swing.JButton jButton_70;
    private javax.swing.JButton jButton_71;
    private javax.swing.JButton jButton_72;
    private javax.swing.JButton jButton_73;
    private javax.swing.JButton jButton_74;
    private javax.swing.JButton jButton_75;
    private javax.swing.JButton jButton_76;
    private javax.swing.JButton jButton_77;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
