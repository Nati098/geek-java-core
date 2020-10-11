package base.hw4;

import java.util.Random;
import java.util.Scanner;

public class XOGame {
    static final int SIZE = 5;  // 3
    static final int DOTS_TO_WIN = 4;  // 3

    static final char DOT_X = 'x';
    static final char DOT_O = 'o';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {

            humanTurn();

            if (checkWinLines(DOT_X)) {
                printMap();
                System.out.println("Победа за игроком!");
                break;
            }
            if (isNoTurns()) {
                printMap();
                System.out.println("Ничья!");
                break;
            }

            robotTurn();
            printMap();

            if (checkWinLines(DOT_O)) {
                System.out.println("Победа за компьютером!");
                break;
            }
            if (isNoTurns()) {
                System.out.println("Ничья!");
                break;
            }

        }

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
        System.out.println("  X ----->");
        System.out.print("Y  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| "+ (i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("V");
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.print("Ваш ход (X, Y): ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y));

        map[y][x] = DOT_X;
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

    public static boolean checkWinLines(char c) {
        // check vertical and horizontal lines
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, -1, -1, DOTS_TO_WIN, c) ||
                    checkLine(i, j, +1, 0, DOTS_TO_WIN, c) ||
                    checkLine(i, j, +1, +1, DOTS_TO_WIN, c) ||
                    checkLine(i, j, 0, +1, DOTS_TO_WIN, c)) {
                    return true;
                }
            }
        }

        return false;
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

/*
    // for task 2
    public static boolean checkWinLines(char c) {
        // check vertical and horizontal lines
        for (int i = 0; i < 3; i++) {
            if ((map[i][0] == c && map[i][1] == c && map[i][2] == c) ||
                    (map[0][i] == c && map[1][i] == c && map[2][i] == c)) {
                return true;
            }
        }

        // check diagonals
        if ((map[0][0] == c && map[1][1] == c && map[2][2] == c) ||
            (map[2][0] == c && map[1][1] == c && map[0][2] == c)) {
            return true;
        }

        return false;
    }
 */