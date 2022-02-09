package day05.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int num = Integer.parseInt(br.readLine());
			String[]a;
			if(num%2==1) {
				a = new String[num/2+1];	//앞
			}else {
				a = new String[num/2];	
				
			}
			String[] b = new String[num/2];	//뒤
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < a.length; i++) {
				a[i] = st.nextToken();
			}
			for (int i = 0; i < b.length; i++) {
				b[i] = st.nextToken();
			}
			
			System.out.printf("#%d ",t);
			for(int i=0; i<b.length;i++) {
				System.out.printf("%s ",a[i]);
				System.out.printf("%s ",b[i]);
			}
			
			if(num%2==1) {
				System.out.printf("%s ",a[num/2]);
			}System.out.println();
			
		}
	}
}
