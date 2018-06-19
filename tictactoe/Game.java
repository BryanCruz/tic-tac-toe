package game;

import java.util.Scanner;
import backend.Board;

public class Game {
	public static void main(String[] args) {
		Board board = new Board();

		Scanner scanner = new Scanner(System.in);

		while(!board.getGameOver()) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();

			if (i >= 0 && i < 3 && j >= 0 && j < 3 && board.getCells()[i][j] == '-') {
				board.play(i, j);
			}
		}

		if (board.checkWin()) {
			System.out.printf("Player %d win!!\n", board.getWinner());
		}
		else {
			System.out.println("Tie!!");
		}
	}
}
