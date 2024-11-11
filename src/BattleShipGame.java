import javax.swing.*;
import java.util.Random;

public class BattleShipGame {
    BattleShipButton[][] board;
    int[][] gameBoard = new int[10][10];;

    int hit = 0;
    int miss = 0;
    int strike = 0;
    Random random = new Random();
    int shiprow;
    int shipcol;
    int dir;


    public BattleShipGame(BattleShipButton[][] board) {
        this.board = board;
    }

    public int getHit() {
        return hit;
    }

    public int getMiss() {
        return miss;
    }

    public int getStrike() {
        return strike;
    }

    private void playAgain()
    {
        int choice = JOptionPane.showConfirmDialog(null, "Would you like to play again?",null,JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            for( int row = 0; row < 10; row++)
                for(int col= 0; col < 10; col++)
                {
                    board[row][col].setText(" ");

                }

            generateBoard();
            miss = 0;
            hit = 0;
            strike = 0;


        } else if (choice == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }

    public void generateBoard() {

        boolean loop = true;



        for( int row = 0; row < 10; row++)
            for(int col= 0; col < 10; col++)
            {
                gameBoard[row][col] = 0;
            }


        while (loop) {
            shiprow = random.nextInt(10);
            shipcol = random.nextInt(10);
            dir = random.nextInt(2);

            if (dir == 0) {
                if (CheckVert(shiprow,shipcol,5)) {
                    gameBoard[shiprow][shipcol] = 1;
                    gameBoard[shiprow][shipcol+1] = 1;
                    gameBoard[shiprow][shipcol+2] = 1;
                    gameBoard[shiprow][shipcol+3] = 1;
                    gameBoard[shiprow][shipcol+4] = 1;
                    loop = false;
                }
            }

            if (dir == 1) {
                if (CheckHori(shiprow,shipcol,5)) {
                    gameBoard[shiprow][shipcol] = 1;
                    gameBoard[shiprow+1][shipcol] = 1;
                    gameBoard[shiprow+2][shipcol] = 1;
                    gameBoard[shiprow+3][shipcol] = 1;
                    gameBoard[shiprow+4][shipcol] = 1;
                    loop = false;
                }
            }

        }

        loop = true;

        while (loop) {
            shiprow = random.nextInt(10);
            shipcol = random.nextInt(10);
            dir = random.nextInt(2);

            if (dir == 0) {
                if (CheckVert(shiprow,shipcol,4)) {
                    gameBoard[shiprow][shipcol] = 1;
                    gameBoard[shiprow][shipcol+1] = 1;
                    gameBoard[shiprow][shipcol+2] = 1;
                    gameBoard[shiprow][shipcol+3] = 1;
                    loop = false;
                }
            }

            if (dir == 1) {
                if (CheckHori(shiprow,shipcol,4)) {
                    gameBoard[shiprow][shipcol] = 1;
                    gameBoard[shiprow+1][shipcol] = 1;
                    gameBoard[shiprow+2][shipcol] = 1;
                    gameBoard[shiprow+3][shipcol] = 1;
                    loop = false;
                }
            }

        }

        loop = true;

        while (loop) {
            shiprow = random.nextInt(10);
            shipcol = random.nextInt(10);
            dir = random.nextInt(2);

            if (dir == 0) {
                if (CheckVert(shiprow,shipcol,3)) {
                    gameBoard[shiprow][shipcol] = 1;
                    gameBoard[shiprow][shipcol+1] = 1;
                    gameBoard[shiprow][shipcol+2] = 1;
                    loop = false;
                }
            }

            if (dir == 1) {
                if (CheckHori(shiprow,shipcol,3)) {
                    gameBoard[shiprow][shipcol] = 1;
                    gameBoard[shiprow+1][shipcol] = 1;
                    gameBoard[shiprow+2][shipcol] = 1;
                    loop = false;
                }
            }

        }

        loop = true;

        while (loop) {
            shiprow = random.nextInt(10);
            shipcol = random.nextInt(10);
            dir = random.nextInt(2);

            if (dir == 0) {
                if (CheckVert(shiprow,shipcol,3)) {
                    gameBoard[shiprow][shipcol] = 1;
                    gameBoard[shiprow][shipcol+1] = 1;
                    gameBoard[shiprow][shipcol+2] = 1;
                    loop = false;
                }
            }

            if (dir == 1) {
                if (CheckHori(shiprow,shipcol,3)) {
                    gameBoard[shiprow][shipcol] = 1;
                    gameBoard[shiprow+1][shipcol] = 1;
                    gameBoard[shiprow+2][shipcol] = 1;
                    loop = false;
                }
            }

        }

        loop = true;

        while (loop) {
            shiprow = random.nextInt(10);
            shipcol = random.nextInt(10);
            dir = random.nextInt(2);

            if (dir == 0) {
                if (CheckVert(shiprow,shipcol,2)) {
                    gameBoard[shiprow][shipcol] = 1;
                    gameBoard[shiprow][shipcol+1] = 1;
                    loop = false;
                }
            }

            if (dir == 1) {
                if (CheckHori(shiprow,shipcol,2)) {
                    gameBoard[shiprow][shipcol] = 1;
                    gameBoard[shiprow+1][shipcol] = 1;
                    loop = false;
                }
            }

        }

        for( int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                System.out.print(gameBoard[row][col] + " ");
            }
            System.out.println();
        }

    }

    public boolean CheckVert(int row, int col, int length) {
        if (gameBoard[row][col] == 0) {
            if (shipcol+1 < gameBoard.length) {
                if (gameBoard[row][col + 1] == 0) {
                    if (shipcol+2 < gameBoard.length && length > 2) {
                        if (gameBoard[row][col+2] == 0) {
                            if (shipcol+3 < gameBoard.length && length > 3) {
                                if (gameBoard[row][col+3] == 0) {
                                    if (shipcol+4 < gameBoard.length && length > 4) {
                                        if (gameBoard[row][col+4] == 0) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else if (length == 4) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else if (length == 3) {
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else if (length == 2) {
                        return true;
                        } else {
                            return false;
                            }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean CheckHori(int row, int col, int length) {
        if (gameBoard[row][col] == 0) {
            if (shiprow+1 < gameBoard.length) {
                if (gameBoard[row+1][col] == 0) {
                    if (shiprow+2 < gameBoard.length && length > 2) {
                        if (gameBoard[row+2][col] == 0) {
                            if (shiprow+3 < gameBoard.length && length > 3) {
                                if (gameBoard[row+3][col] == 0) {
                                    if (shiprow+4 < gameBoard.length && length > 4) {
                                        if (gameBoard[row+4][col] == 0) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else if (length == 4) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else if (length == 3) {
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else if (length == 2) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void Game(int row, int col){

        boolean win = true;

        if (gameBoard[row][col] == 1) {
            JOptionPane.showMessageDialog(null, "Hit", null, JOptionPane.INFORMATION_MESSAGE);
            gameBoard[row][col] = 0;
            board[row][col].setText("X");
            hit++;
            miss = 0;
        } else {
            JOptionPane.showMessageDialog(null, "Miss", null, JOptionPane.INFORMATION_MESSAGE);
            board[row][col].setText("O");
            miss++;
            if (miss == 3) {
                miss = 0;
                strike++;
            }

            if (strike == 3) {
                JOptionPane.showMessageDialog(null, "You Lost", null, JOptionPane.INFORMATION_MESSAGE);
                playAgain();
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (gameBoard[i][j] != 0) {
                    win = false;
                }
            }
        }
        if (win) {
            JOptionPane.showMessageDialog(null, "You Win", null, JOptionPane.INFORMATION_MESSAGE);
            playAgain();
        }


    }

    public boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        String text = board[row][col].getText();
        if(text.equals("X") || text.equals("O")) {
            JOptionPane.showMessageDialog(null, "Invalid Move", null, JOptionPane.INFORMATION_MESSAGE);
        } else {
            retVal = true;
        }


        return retVal;

    }


}
