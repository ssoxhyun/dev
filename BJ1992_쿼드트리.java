package day10.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1992_쿼드트리 {
	static int N;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new char[N][N];
		for (int i = 0; i < N; i++) {

			arr[i] = br.readLine().toCharArray();

		}

		getResult(0, 0,N);

	}

	public static void getResult(int x, int y,int size) {

		if (size < 1)
			return;

		char c = arr[x][y]; // 첫원소
		int flag = 0; // 0 : 다 0이거나 1인경우
		OUT: for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != c) {
					flag = 1; // 1 : 4등분 해야하는 경우
					System.out.print("(");
					getResult(x, y, size / 2);
					getResult(x, y + size / 2, size / 2);
					getResult(x + size / 2, y, size / 2);
					getResult(x + size / 2, y + size / 2, size / 2);
					System.out.print(")");
					break OUT;
				}
			}
		}

		if (flag == 0)
			System.out.print(c);
	}

}
