package day14.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289_서로소집합 {
	static int N;
	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); // 연산의 개수

			makeSet();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int temp = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (temp == 0) {					// 0이면 합집합
					if(union(a, b)) union(a, b);
				} else {							// 1이면 같은집합인지 확인
					if (findSet(a) == findSet(b))
						sb.append(1);	//같은집합
					else
						sb.append(0);	//다른집합
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 자신의 부모노드를 자신의 값으로 세팅
	public static void makeSet() {
		parents = new int[N+1];				//인덱스값 맞추기 위해 

		for (int i = 1; i < N+1; i++) {
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
		//합쳐지면 true반환
		int aRoot=findSet(a);
		int bRoot=findSet(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot]= aRoot;
		return true;
		
	}

}
