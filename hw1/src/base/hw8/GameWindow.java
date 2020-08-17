package base.hw8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    static final int WINDOW_POS_X = 500;
    static final int WINDOW_POS_Y = 300;
    static final int WIDTH = 555;
    static final int HEIGTH = 505;

    private JPanel panel;
    private JButton btnStart;
    private JButton btnExit;

    private SettingsWindow settingsWindow;
    private BattleWindow battleWindow;

    public GameWindow() {
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WIDTH, HEIGTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic-tac-toe");

        bindView();

        setVisible(true);
    }

    private void bindView() {
        settingsWindow = new SettingsWindow(this);
        battleWindow = new BattleWindow(this);

        panel = new JPanel(new GridLayout(1, 2));

        btnStart = new JButton("New game");
        btnStart.addActionListener(e -> settingsWindow.setVisible(true));
        panel.add(btnStart);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(event -> System.exit(0));
        panel.add(btnExit);

        add(battleWindow, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    public void startNewGame(int mode, int fieldSize, int winningLength){
        battleWindow.startNewGame(mode, fieldSize, winningLength);
    }

}
