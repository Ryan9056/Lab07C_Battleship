import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleShipFrame extends JFrame{
    JPanel mainPnl;
    JPanel BSPnl;  // Top
    JPanel controlPnl; // Bottom

    JLabel MISS;
    JLabel HIT;
    JLabel Strike;


    JButton quitBtn;

    BattleShipButton[][] board = new BattleShipButton[10][10];
    BattleShipGame game = new BattleShipGame(board);


    public BattleShipFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createBattleShip();
        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);
        add(BSPnl, BorderLayout.NORTH);
        add(mainPnl);
        setSize(1100, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    private void createBattleShip() {
        BSPnl = new JPanel();
        BSPnl.setPreferredSize(new Dimension(810, 500));
        BSPnl.setLayout(new GridLayout(10,10));



        for( int row = 0; row < 10; row++)
            for(int col= 0; col < 10; col++)
            {
                board[row][col] = new BattleShipButton(row, col);
                board[row][col].setText(" ");
                board[row][col].addActionListener(listener);
                BSPnl.add(board[row][col]);
            }
        game.generateBoard();

    }

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof BattleShipButton) {
                if (game.isValidMove(((BattleShipButton) e.getSource()).getRow(),((BattleShipButton) e.getSource()).getCol())) {
                    game.Game(((BattleShipButton) e.getSource()).getRow(),((BattleShipButton) e.getSource()).getCol());
                    MISS.setText("Miss Counter: " + game.getMiss());
                    HIT.setText("Hit Counter: " + game.getHit());
                    Strike.setText("Strikes: " + game.getStrike());
                }
            }
        }
    };

    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 4));

        MISS = new JLabel("Miss Counter: " + game.getMiss());
        HIT = new JLabel("Hit Counter: " + game.getHit());
        Strike = new JLabel("Strikes: " + game.getStrike());

        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Verdana", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(HIT);
        controlPnl.add(MISS);
        controlPnl.add(Strike);
        controlPnl.add(quitBtn);

    }


}
