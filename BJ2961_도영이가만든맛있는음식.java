package day08.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2961_도영이가만든맛있는음식 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] food = new int[N][2];
		int min=Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < 1 << N; i++) {
			int S=1, B=0;
			for(int j=0; j<N; j++) {
				if((i&1<<j)!=0) {
					S*=food[j][0];
					B+=food[j][1];
				}
			}
			min = Math.min(min,Math.abs(S-B));
		}
		System.out.println(min);
	}

}
