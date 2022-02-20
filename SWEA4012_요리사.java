package day10.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4012_요리사 {
	static int[][] food;
	static boolean[] isSelected;
	static int N, R;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//day10//ws//4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());		//nCr
			R = N / 2;

			food = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			isSelected = new boolean[N];
			/*
			 * [true, true, false, false]  0 1
			 * [true, false, true, false]  0 2
			 * [true, false, false, true]  0 3
			 * [false, true, true, false]  1 2
			 * [false, true, false, true]  1 3
			 * [false, false, true, true]  2 3
			 */

			min = Integer.MAX_VALUE;
			combination(0, 0);

			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	public static void combination(int cnt, int start) {
		int sum1 = 0, sum2 = 0;		

		if (cnt == R) {						
			for (int i = 0; i < N; i++) {			
				for (int j = 0; j < N; j++) {
					if (isSelected[i]&&isSelected[j]&&i!=j) {//i도 j도 둘 다 true일때만
							sum1 += food[i][j];		
					} 
					if(!isSelected[i]&&!isSelected[j]&&i!=j) {//i도 j도 둘 다 false일때만
							sum2 += food[i][j];		
					}
				}
			}
			min = Math.min(Math.abs(sum1 - sum2), min);
			return;
		}
		for (int i = start; i < N; i++) {
			isSelected[i] = true;
			combination(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}

}
