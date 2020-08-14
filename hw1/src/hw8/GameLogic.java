package hw8;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    public static final char DOT_X = 'x';
    public static final char DOT_O = 'o';
    public static final char DOT_EMPTY = '.';

    public static final int AI_WON = 0;
    public static final int HUMAN_WON = 1;

    public static char[][] map;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static int SIZE;
    public static int DOTS_TO_WIN;
    public static boolean isFinished;

    public static int whoWon = -1;  // 0=ai, 1=human, 2=nobody

    public static void go() {
        isFinished = true;

        printMap();

        if (checkWinLines(DOT_X)) {
            printMap();
            System.out.println("Победа за игроком!");
            whoWon = 1;
            return;
        }
        if (isNoTurns()) {
            printMap();
            System.out.println("Ничья!");
            whoWon = 2;
            return;
        }

        robotTurn();
        printMap();

        if (checkWinLines(DOT_O)) {
            System.out.println("Победа за компьютером!");
            whoWon = 0;
            return;
        }
        if (isNoTurns()) {
            System.out.println("Ничья!");
            whoWon = 2;
            return;
        }

        isFinished = false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i=0; i < SIZE; i++) {
            for (int j=0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void humanTurn(int x, int y) {
        if (isCellValid(x, y)) {
            map[y][x] = DOT_X;
            go();
        }
    }

    public static void robotTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        }
        while (!isCellValid(x, y));

        map[y][x] = DOT_O;
    }

    public static boolean checkWinLines(char dot) {
        return checkWinLines(dot, DOTS_TO_WIN);
    }

    public static boolean checkWinLines(char c, int dotsToWin) {
        // check vertical and horizontal lines
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, -1, -1, dotsToWin, c) ||
                        checkLine(i, j, +1, 0, dotsToWin, c) ||
                        checkLine(i, j, +1, +1, dotsToWin, c) ||
                        checkLine(i, j, 0, +1, dotsToWin, c)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkLine(int cy, int cx, int vy, int vx, char dot) {
        return checkLine(cy, cx, vy, vx, DOTS_TO_WIN, dot);
    }

    public static boolean checkLine(int x, int y, int dx, int dy, int dotsToWin, char c) {
        if ((x + dx*(dotsToWin-1) > SIZE-1) ||
                (x + dx*(dotsToWin-1) < 0) ||
                (y + dy*(dotsToWin-1) > SIZE-1) ||
                (y + dy*(dotsToWin-1) < 0)) {
            return false;
        }

        for (int i=0; i < dotsToWin; i++) {
            if (map[y + i * dy][x + i * dx] != c) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNoTurns() {
        for (char[] chars : map) {
            for (char c : chars) {
                if (c == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
