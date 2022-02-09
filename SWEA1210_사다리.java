package day05.hw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1210_사다리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//day05//hw//1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			int x = 99, y = 0;
			int flag = 0;			//0:상 , 1:우, 2:좌

			// input값
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[99][j] == 2) {
						y = j;
					}
				}
			}


			while (x != 0) {
				if (flag == 0) { // 상
					if (y - 1 >= 0 && arr[x][y - 1] == 1) {
						y--;
						flag = 2;
					} else if (y + 1 <= 99 && arr[x][y + 1] == 1) {
						y++;
						flag = 1;
					} else {
						x--;
					}
				} else if (flag == 1) { // 우
					if (y + 1 <= 99 && arr[x][y + 1] == 1) {
						y++;
					} else {
						x--;
						flag = 0;
					}
				} else { // 좌
					if (y - 1 >= 0 && arr[x][y - 1] == 1) {
						y--;
					} else {
						x--;
						flag = 0;
					}
				}
			}

			System.out.printf("#%d %d\n", t, y);

		}

	}
}
