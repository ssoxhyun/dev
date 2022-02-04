package day02.hw;

import java.util.Scanner;

public class swea_2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int cha = N-M;
			int max = 0, sum = 0;

			int[][] arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			for(int i=0; i<=cha; i++) {
				for(int j=0; j<=cha; j++) {
					sum=0;
					for(int r=i; r<i+M;r++) {
						for(int c=j; c<j+M;c++) {
							sum+=arr[r][c];
							
						}
					}
					if(max<sum) max=sum;
				}
			}
			
			System.out.printf("#%d %d\n",t+1,max);
		}
	}
}
