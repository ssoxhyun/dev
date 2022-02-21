package day11.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1987_알파벳 {
	static char[][] arr;
	static List<Character> check;
	static int R, C, max;
	static int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		check = new ArrayList<Character>();
		search(0, 0, 1);

		System.out.println(max);

	}

	private static void search(int x, int y, int len) {
		
		boolean go = false;
		check.add(arr[x][y]);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx == R || ny == C) continue;
			if (check.contains(arr[nx][ny])) continue;
			
			go= true;
			search(nx,ny,len+1);
			check.remove(check.size()-1); 		
			
			
		}
		if(!go) {
			max=Math.max(len, max);
			return;
		}

	}

}
