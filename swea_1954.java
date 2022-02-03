package ws;

import java.util.Scanner;
/*
 * n*n 배열에 달팽이 모양으로 숫자 찍기
 * SWEA 1954. 달팽이 숫자
 */

public class swea_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			int dx[] = { 0, 1, 0, -1 }, dy[] = { 1, 0, -1, 0 };	//우,하,좌,상
			int count = 1;
			int x = 0, y = 0;
			int d = 0; 
			while (count <= N * N) {
				arr[x][y] = count++;
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] != 0) { //경계 벗어나거나, 숫자가 이미 존재하면
					d = (d + 1) % 4;	//방향바꿈  
					nx = x + dx[d];
					ny = y + dy[d];
				}
				x = nx;
				y = ny;
			}
			System.out.printf("#%d\n",t);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++)
					System.out.print(arr[r][c] + " ");
				System.out.println();
			}
		}
	}

}
