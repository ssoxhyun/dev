package day02.ws;

import java.util.Scanner;

public class swea2805_farm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			int size = sc.nextInt();
			int[][] arr = new int[size][size];
			sc.nextLine();
			
			
			for (int r = 0; r < size; r++) {
				String a = sc.nextLine();
				for (int c = 0; c < size; c++) {
					arr[r][c] = (a.charAt(c)) - '0';
				}
			}

			int half = (size / 2);
			int sum = 0;
			
			int start = half; // 더하는 곳 시작
			int end = half; // 더하는 곳 끝
			
			for (int i = 0; i < size; i++) {
				if (i < half) {
					for (int j = start; j <= end; j++) {
						sum += arr[i][j];

					}
					start--;
					end++;

				}
				if (i == half) {
					for (int j = 0; j < size; j++)
						sum += arr[i][j];
				}
				if (i > half) {
					start++;
					end--;
					for (int j = start; j <= end; j++) {
						sum += arr[i][j];
					}
					
				}
			}
			System.out.printf("#%d %d\n", t + 1, sum);
		}
		sc.close();
	}

}
