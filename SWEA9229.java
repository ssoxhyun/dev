package day04.hw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//swea9229

public class SWEA9229 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//day04//hw//9229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++  ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	//과자갯수
			int M = Integer.parseInt(st.nextToken());	//제한무게
			
			//과자배열 생성
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {					
				arr[i]=Integer.parseInt(st.nextToken());
			}
			int max=0;
			int num=0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					num  = arr[i]+arr[j];
					if(num>max && num<=M) max=num;		
					
				}
			}
			if(max==0) {
				System.out.printf("#%d %d\n",t,-1);
			}else {
				System.out.printf("#%d %d\n",t,max);
			}
			
			
		}
	}
	
}
