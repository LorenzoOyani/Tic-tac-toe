package org.example.ticTacToe;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private static int boardSize = 0;
    public static Bitset playerXHand;
    public static Bitset playerOHand;
    private final Map<String, Bitset> winningHands;

    public Game(int boardSize) {
        Game.boardSize = boardSize;
        this.winningHands = getWinningHands(boardSize);
        playerOHand = new Bitset();
        playerXHand = new Bitset();
    }

    public static boolean move(String player, int x, int y) {
        if (!player.equals("X") && !player.equals("O")) {
            return false;
        }
        int bit = x * boardSize + y;
        if (player.equals("X")) {
            playerXHand.setBit(bit);

        }
        if (player.equals("O")) {
            playerXHand.setBit(bit);

        } else {
            return false;
        }
        return true;

    }

    private Map<String, Bitset> getWinningHands(int n) {
        Map<String, Bitset> winnings = new HashMap<>(n * n + 2);

        // get all horizontal values added to the hashmaps;
        for (int i = 0; i < n * n; i += n) {
            Bitset bitset = new Bitset();
            for (int j = i; j < i + n; j++) {
                bitset.setBit(j);
            }
            winnings.put("horizontal1" + i, bitset);
        }

        //get all vertical index;
        for (int i = 0; i < n; i++) {
            Bitset set = new Bitset();
            for (int j = i; j < n * n; j += n) {
                set.setBit(j);
            }
            winnings.put("vertical1" + i, set);
        }

        // get left and right vertices;
        Bitset left = new Bitset();
        Bitset right = new Bitset();

        for (int i = 0; i < n; i++) {
            left.setBit(i * n + 1);
            right.setBit(i * (n + 1) + n - 1 - i);


        }
        winnings.put("horizontal2", left);
        winnings.put("vertical2", right);

        return winnings;

    }


}
