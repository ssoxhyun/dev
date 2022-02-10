package day06.hw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// BJ2563_색종이

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[100][100]; // 도화지
		int num = Integer.parseInt(br.readLine());

		for (int t = 0; t < num; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x + 10; i++) {		//도화지에 해당하는 좌표부터 10*10만큼 1로 변환
				for (int j = y; j < y + 10; j++) {
					arr[i][j] = 1;
				}
			}
		}

		int cnt = 0;
		for (int[] r : arr) {
			for (int c : r) {
				if (c == 1)	//1의개수 세주기
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}
