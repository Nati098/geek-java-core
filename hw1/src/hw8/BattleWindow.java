package hw8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleWindow extends JPanel {
    private GameWindow gameWindow;
    private int cellWidth;
    private int cellHeight;

    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    public BattleWindow(GameWindow gw) {
        this.gameWindow = gw;

        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickBattleField(e);
            }
        });
    }


    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;

        repaint();
    }

    private void clickBattleField(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if(!GameLogic.isFinished){
            GameLogic.humanTurn(cellX, cellY);
        }

        repaint();

        if (isInit && GameLogic.isFinished) {
            showDialogWindow();
        }
    }

    private void showDialogWindow() {
        switch (GameLogic.whoWon) {
            case 0:
                JOptionPane.showMessageDialog(this, "Computer won!", "Game over", JOptionPane.PLAIN_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(this, "You won!", "Game over", JOptionPane.PLAIN_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(this, "Dead heat!", "Game over", JOptionPane.PLAIN_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Error! Smth went wrong!", "Game over", JOptionPane.PLAIN_MESSAGE);
                break;
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSize;
        cellWidth = panelWidth / fieldSize;

        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (GameLogic.map[i][j] == GameLogic.DOT_X) {
                    drawX(g, j, i);
                }
                if (GameLogic.map[i][j] == GameLogic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }
    }

    private void drawX(Graphics g, int x, int y) {
        int padding = 10;
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
        g.drawLine(cellWidth * x + padding, cellHeight * y + padding,
                cellWidth * (x + 1) - padding, cellHeight * (y + 1) - padding);
        g.drawLine(cellWidth * x + padding, cellHeight * (y + 1) - padding,
                cellWidth * (x + 1) - padding, cellHeight * y + padding);
    }

    private void drawO(Graphics g, int x, int y) {
        int padding = 10;
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.BLUE);
        g.drawOval(cellWidth * x + padding/2, cellHeight * y +  + padding/2,
                cellWidth - 10, cellHeight - 10);
    }


}
