package day09.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int R=0;
		int count =0;
		
		while(true) {
			if(N%5==0) {			//5로 딱 떨어질때만 
				count+=N/5;
				System.out.println(count);
				break;
			}else  {
				if(N<3) {
					System.out.println(-1);
					break;
				}
				N-=3;
				count++;
			} 
		}
		
		
//		count= N/5;			//11의 경우, 5+3*2로 가능하나 5로 나눠버리면 -1출력
//		R=N%5;
//		
//		while(true) {
//			if(R==0) {
//				System.out.println(count); break;
//			}
//			if(R<3) {
//				System.out.println(-1); break;
//			}
//			R-=3;
//			count++;
//		}
			
	}

}
