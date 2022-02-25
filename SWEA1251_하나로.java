package day15.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1251_하나로 {
	static double tax;
	static int N;
	static int[] parents;
	static Edge[] edgelist;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src//day15//ws//1252.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine()); // 섬의개수
			pos[] arr = new pos[N];

			// X값
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = new pos(Integer.parseInt(st.nextToken()));
			}

			// Y값
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i].y = Integer.parseInt(st.nextToken());
			}
			// 세율
			tax = Double.parseDouble(br.readLine());

			edgelist = new Edge[N * N - N];	//자기->자기로 오는 간선 제외 다  넣어주기 
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					edgelist[idx] = new Edge(i, j, calc(arr[i], arr[j]));
					idx++;
				}
			}
			Arrays.sort(edgelist);// 간선비용 오름차순 정렬

			makeSet();

			double result = 0;
			int cnt = 0;

			for (Edge edge : edgelist) {
				if (union(edge.from, edge.to)) {
					result += edge.w;
					if (++cnt == N - 1)
						break;
				}
			}

			sb.append(String.format("%.0f", result)).append("\n");
		}
		System.out.println(sb);

	}

	static double calc(pos a, pos b) {
		double cost = 0.0;

		int line1 = Math.abs(a.x - b.x);
		int line2 = Math.abs(a.y - b.y);
		cost = (Math.pow(line1, 2) + Math.pow(line2, 2)) * tax;

		return cost;

	}

	// 자신의 부모노드를 자신의 값으로 세팅
	public static void makeSet() {
		parents = new int[N];

		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	// a의 집합 찾기 : a 의 대표자 찾기
	public static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]); // path compression
	}

	public static boolean union(int a, int b) {
		// 합쳐지면 true반환
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;

	}

	static class pos {
		int x;
		int y;

		public pos(int x) {
			super();
			this.x = x;
		}

		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "pos [x=" + x + ", y=" + y + "]";
		}

	}

	static class Edge implements Comparable<Edge> {

		public Edge(int from, int to, double w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w; // 가중치
		}

		int from, to;
		double w;

		@Override
		public int compareTo(Edge o) {
			return Double.compare (this.w , o.w); // 오름차순
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", w=" + w + "]";
		}

	}

}
