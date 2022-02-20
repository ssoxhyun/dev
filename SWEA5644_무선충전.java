package day10.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 0216.zip 교수님 코드 참조 
 */
public class SWEA5644_무선충전 {
	static class BCpos implements Comparable<BCpos> {
		int x, y, size, weight;

		BCpos(int x, int y, int size, int weight) {
			this.x = x;
			this.y = y;
			this.size = size; // 충전범위
			this.weight = weight; // 가중치
		}

		@Override
		public String toString() {
			return "BCpos [x=" + x + ", y=" + y + ", size=" + size + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(BCpos o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
	}

	static List<BCpos> getBCList(int x, int y, BCpos[] BC) { // (x,y) 위치에서 사용 가능한 BC리스트 리턴
		List<BCpos> list = new ArrayList<>();
		for (int i = 0; i < BC.length; i++) {
			if (Math.abs(x - BC[i].x) + Math.abs(y - BC[i].y) <= BC[i].size)
				list.add(BC[i]);
		}
		return list;
	}

	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("src//day10//ws//5644.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 총 이동횟수
			int bc_num = Integer.parseInt(st.nextToken()); // BC 개수

			int[] moveA = new int[M];
			int[] moveB = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) { // A의 이동명령
				moveA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) { // B의 이동명령
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			BCpos[] BC = new BCpos[bc_num]; // BC정보
			for (int i = 0; i < bc_num; i++) {
				st = new StringTokenizer(br.readLine());
				BC[i] = new BCpos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			int Ax = 1, Ay = 1;
			int Bx = 10, By = 10;
			int sum = 0;

			for (int i = 0; i <= M; i++) {
				List<BCpos> bcA = getBCList(Ax, Ay, BC); // A의 현재 위치 기준 충전기 범위안에 몇개 들어있는지
				List<BCpos> bcB = getBCList(Bx, By, BC);

				if (bcA.size() != 0 && bcB.size() == 0) { // A만 충전범위
					sum += Collections.max(bcA).weight;
				}
				if (bcA.size() == 0 && bcB.size() != 0) { // B만 충전범위
					sum += Collections.max(bcB).weight;
				}
				if (bcA.size() != 0 && bcB.size() != 0) { // 둘 다 충전범위 안에 있는 경우
					int max = 0;
					for (int j = 0; j < bcA.size(); j++) { // 2중 for문을 돌면서 2개의 범위 안 충전기의 가중치를 다 더해주고, 가장 큰 값을 max에 넣는다.
															// 조합?
						for (int k = 0; k < bcB.size(); k++) {
							int tmp = bcA.get(j).weight + bcB.get(k).weight;
							if (bcA.get(j) == bcB.get(k))
								tmp /= 2; // 둘이 하나의 BC를 공유할경우
							max = Math.max(max, tmp);
						}
					}
					sum += max;
				}
				if (i == M)
					break;

				Ax +=dx[moveA[i]];
				Ay +=dy[moveA[i]];
				Bx +=dx[moveB[i]];
				By +=dy[moveB[i]];
			}
			System.out.printf("#%d %d \n", t, sum);

		}
	}

}
