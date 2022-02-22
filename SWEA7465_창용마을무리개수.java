package day14.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7465_창용마을무리개수 {
	static int N;
	static int [] parents;
	static int[] roots;
	
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
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			roots = new int [N+1];			//루트 갯수 세어줄 배열
			
			for(int i=1; i<=N; i++) {
				roots[ findSet(i)] ++;			//찾은 루트의 값을 1개씩 증가
			}
			
			int ans=0;
			for(int i=1; i<=N; i++) {
				if(roots[i]!=0) ans++;			// 0이 아닌 루트의 갯수 세어주기
			}
			
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void makeSet() {
		parents = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			parents[i] = i;
		}
	}
	//a의 집합 찾기 : a 의 대표자 찾기
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);	//path compression
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
