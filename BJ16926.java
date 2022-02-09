package day05.ws;

import java.util.Scanner;

public class BJ16926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 행
		int M = sc.nextInt(); // 열
		int R = sc.nextInt(); // 회전

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int square = Math.min(M, N) / 2; // 회전해야 하는 사각형 갯수

		for (int r = 0; r < R; r++) { // 회전횟수체크
			for (int i = 0; i < square; i++) {
				// 사각형갯수 체크
				int temp = arr[i][i]; 

				for (int j = i + 1; j < M - i; j++)		//좌
					arr[i][j - 1] = arr[i][j];

				for (int j = i + 1; j < N - i; j++)		//상
					arr[j - 1][M - 1 - i] = arr[j][M - 1 - i];

				for (int j = M - 2 - i; j >= i; j--)
					arr[N - 1 - i][j + 1] = arr[N - 1 - i][j];

				for (int j = N - 2 - i; j >= i; j--)
					arr[j + 1][i] = arr[j][i];

				arr[i + 1][i] = temp;
			}
		}

		for (int[] r : arr) {
			for (int c : r) {
				System.out.print(c + " ");
			}
			System.out.println();
		}

	}

}
