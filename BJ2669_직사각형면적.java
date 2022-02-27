package IMTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2669_직사각형면적 {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		arr = new int[100][100];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int leftX = Integer.parseInt(st.nextToken());
			int leftY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken());
			int rightY = Integer.parseInt(st.nextToken());

			for (int x = leftX; x < rightX; x++) {
				for (int y = leftY; y < rightY; y++) {
					arr[x][y] = 1;

				}
			}

		}
		int cnt = 0;
		for (int[] r : arr) {
			for (int c : r) {
				if (c == 1)
					cnt++;
			}
		}

		System.out.println(cnt);
	}

}
