package IMTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ2628_종이자르기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R= Integer.parseInt(st.nextToken());
		int C= Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> X= new LinkedList<>();
		LinkedList<Integer> Y= new LinkedList<>();
		
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			int type=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			
			if(type==0) Y.add(N);
			else X.add(N);
		}
		X.add(R);
		Y.add(C);
		
		X.sort(null);
		Y.sort(null);
		
		int maxX=X.get(0); 
		int maxY=Y.get(0);
		
		for(int i=1; i<X.size(); i++) {
			maxX=Math.max(maxX,X.get(i)-X.get(i-1));

		}
		for(int i=1; i<Y.size(); i++) {
			maxY=Math.max(maxY,Y.get(i)-Y.get(i-1));

		}
		
		System.out.println(maxX*maxY);
		
	}

}
 