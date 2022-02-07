package day03.ws;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA5215_burgerdiet {
	static int N, likcal, maxjumsu;
	static int[] jumsu, kcal;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			maxjumsu =0;
			N = sc.nextInt();
			likcal = sc.nextInt();

			jumsu = new int[N];
			kcal = new int[N];

			for (int i = 0; i < N; i++) {
				jumsu[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}
			System.out.println(Arrays.toString(jumsu));
			System.out.println(Arrays.toString(kcal));
			combination(0, 0, 0);
			System.out.printf("#%d %d\n", t+1, maxjumsu);
		}
	}

	private static void combination(int cnt, int j, int k) {	//인덱스, 점수의 합, 칼로리의 합

		if (k > likcal)	//리미트칼로리 넘으면 끝
			return;
		if (cnt == N) {
			if (j > maxjumsu) {
				maxjumsu = j; // 최대값 구하고
			}
			return;
		}

		combination(cnt + 1, j + jumsu[cnt], k + kcal[cnt]);	//선택하는 경우 
		combination(cnt + 1, j, k);	//선택하지 않는 경우
	}
}
