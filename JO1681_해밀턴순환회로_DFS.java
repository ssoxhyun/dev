package day16.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class JO1681_해밀턴순환회로_DFS {
//JO1681_해밀턴 순환회로
	static int[][] arr;
	static boolean[] visited;
	static int min;
	static int num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		

		arr = new int[num][num];
		visited= new boolean [num];
		min = Integer.MAX_VALUE;

		StringTokenizer st = null;
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < num; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0]=true;			//시작점 방문
		DFS(1,0,0);					//시작점 방문하고 시작하니까 +1
		
		System.out.println(min);

		

	}
	public static void DFS(int cnt, int idx, int cost) {
		
		if(cost> min) return;		//가지치기
		
		if(cnt==num) {				//기저	
			if(arr[idx][0]==0) return;		//다시 회사로 돌아가는 길 없을경우 리턴
			cost += arr[idx][0];	//회사로 돌아가기 
			min = Math.min(min,cost);
			return;
		}
		
		
		for(int i=0;i<num;i++) {	//재귀
			if(!visited[i] && arr[idx][i]!=0) {
				visited[i] = true;
				DFS(cnt+1, i, cost+arr[idx][i]);
				visited[i] = false;
			}
		}
	}
}


