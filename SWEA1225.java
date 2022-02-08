package day04.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		System.setIn(new FileInputStream("src//day04//ws//1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t<10; t++) {
			int tc = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			} // q에 인풋값 집어넣기.

			int del = 0; // 삭제되는 값
			int add = 0; // 추가되는 값

			while (true) {
				for (int i = 1; i <=5; i++) {

					del = q.poll(); // 앞에꺼 빼서
					add = del - i;
					if (add > 0) {
						q.offer(add);
					} else { // 뒤에 추가될 값 add가 0과 같거나 작으면
						add = 0;
						q.offer(add);//
						break;
					}

				}
				if (add <= 0)
					break;
			}
			System.out.printf("#%d ", tc);
			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}

	}

}
