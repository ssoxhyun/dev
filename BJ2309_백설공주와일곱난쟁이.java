package day07.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2309_백설공주와일곱난쟁이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 조합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		int[] narr = new int[7];
		int sum=0;
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		int idx=0;
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum-(arr[i]+arr[j])==100) {
					for(int k=0; k<9; k++) {
						if(k==i||k==j) continue;
						narr[idx]=arr[k];
						idx++;
					}
				}
			}
		}
		Arrays.sort(narr);
		for(int i=0; i<7; i++) {
			System.out.println(narr[i]);
		}
		
		
		
	}

}
