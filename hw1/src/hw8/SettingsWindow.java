package hw8;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {

    private final int WINDOW_POS_X = GameWindow.WINDOW_POS_X + 50;
    private final int WINDOW_POS_Y = GameWindow.WINDOW_POS_Y + 50;
    private final int WIDTH = GameWindow.WIDTH - 100;
    private final int HEIGTH = GameWindow.HEIGTH - 100;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    static final int GAME_MODE_H_VS_A = 0;
    static final int GAME_MODE_H_VS_H = 1;

    private ButtonGroup btnGroupGameMode;
    private JRadioButton jrbHumanVsAi;
    private JRadioButton jrbHumanVsHuman;
    private JSlider jsFieldSize;
    private JSlider jsWinningLength;

    private GameWindow gameWindow;

    public SettingsWindow(GameWindow gw) {
        this.gameWindow = gw;

        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WIDTH, HEIGTH);
        setTitle("Setup your game");

        bindView();

        setVisible(false);
    }

    private void bindView() {
        setLayout(new GridLayout(8,1 ));

        add(new JLabel("Choose game mode:"));
        btnGroupGameMode = new ButtonGroup();
        jrbHumanVsAi = new JRadioButton("HumanVsAi", true);
        btnGroupGameMode.add(jrbHumanVsAi);
        add(jrbHumanVsAi);
        jrbHumanVsHuman = new JRadioButton("HumanVsHuman");
        btnGroupGameMode.add(jrbHumanVsHuman);
        add(jrbHumanVsHuman);

        add(new JLabel("Choose field size:"));
        jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        jsFieldSize.setMajorTickSpacing(1);
        jsFieldSize.setPaintTicks(true);
        jsFieldSize.setPaintLabels(true);
        add(jsFieldSize);
        jsFieldSize.addChangeListener(e -> jsWinningLength.setMaximum(jsFieldSize.getValue()));

        add(new JLabel("Choose number of dots to win:"));
        jsWinningLength = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        jsWinningLength.setMajorTickSpacing(1);
        jsWinningLength.setPaintTicks(true);
        jsWinningLength.setPaintLabels(true);
        add(jsWinningLength);

        JButton buttonStartGame = new JButton("Start");
        add(buttonStartGame);
        buttonStartGame.addActionListener(e -> {
            int mode = jrbHumanVsAi.isSelected() ? GAME_MODE_H_VS_A : GAME_MODE_H_VS_H;
            int fieldSize = jsFieldSize.getValue();
            int winningLength = jsWinningLength.getValue();

            GameLogic.SIZE = fieldSize;
            GameLogic.DOTS_TO_WIN = winningLength;
            GameLogic.GAME_MODE = mode;
            GameLogic.initMap();
            GameLogic.isFinished = false;

            gameWindow.startNewGame(mode, fieldSize, winningLength);

            setVisible(false);
        });

    }
}
