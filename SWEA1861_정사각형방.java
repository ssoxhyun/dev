package day07.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA1861_정사각형방 {
	static int[][] arr;
	static int[][] visit;		//방문체크
	static int size;
	static int len, maxlen;
	static int room;

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("src//day07//ws//1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			len = 0;
			maxlen = 0;
			room = 0;

			// 배열생성
			size = Integer.parseInt(br.readLine());
			arr = new int[size][size];
			visit = new int[size][size];

			// 인풋값입력
			for (int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < size; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					len = 0;
					move(i, j, 1,arr); // 아무데도 못가도 1이다.
				}
			}
			System.out.printf("#%d %d %d\n", t, room, maxlen);
		}

	}

	public static void move(int x, int y, int count,int[][]arr) {
		int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
		int[] dy = { 0, 1, 0, -1 };
		if(visit[x][y]==1) return; 
		boolean go = false;
		visit[x][y]=1;
		for (int i = 0; i < 4; i++) { // 4방 탐색 후, 1이 큰 값이 있으면 재귀
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= size || ny < 0 || ny >= size)// 범위 체크
				continue;
			if (arr[nx][ny] == arr[x][y] + 1) {
				go = true;
				move(nx, ny, count + 1,arr);
			}
		}
		

		if (!go && len < count) { // 갈수있는 방의 갯수 넘겨줌.
			len = count;
		}
		if (len == maxlen && arr[x][y] < room) { // 길이가 같으면, 더 작은 방 넘기기
			room = arr[x][y];
		}
		if (len > maxlen) {			//길이가 더 크면, maxlen 업데이트
			room = arr[x][y];
			maxlen = len;
		}
	}

}
