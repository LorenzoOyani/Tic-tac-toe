package org.example.ticTacToe;

import java.util.Scanner;

public class TopPlayer {
    private static final int SIZE = 3;


    public static void main(String[] args) {
        Game game = new Game(3);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("printing initial board state");
            printBoard(game);

            System.out.println("Enter your move (Player X or O) in format X and Y, where x and y indicates indexes");
            String[] line = sc.nextLine().split("");

            if (args.length != 3) {
                System.out.println(" Invalid input format, please try again");
                continue;
            }
            int x, y;
            String player = line[0];

            try {
                x = Integer.parseInt(line[1]);
                y = Integer.parseInt(line[2]);


            } catch (NumberFormatException e) {
                System.out.println("Invalid input format, please try again");
                continue;
            }
            if (!Game.move(player, x, y )) {
                System.out.println("Invalid move, please try again");
                continue;
            }
        }

    }

    public static void printBoard(Game game) {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                int index = x * SIZE + y;
                if (game.playerXHand.matches(new Game.playerOHand)) {
                    System.out.println("X");
                } else if (Game.playerOHand.matches(new Game.playerXHand.Bitset.setBit(index))) {
                    System.out.println("O");
                } else {
                    System.out.println("-");
                }
            }
            System.out.println();
        }
    }
}
