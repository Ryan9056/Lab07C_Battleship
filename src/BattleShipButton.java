import javax.swing.*;

public class BattleShipButton extends JButton {

        private int row;
        private int col;

        public BattleShipButton(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }




    }

