package IMTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2635_수이어가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		LinkedList<Integer> ans= new LinkedList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=num; i++) {
			LinkedList<Integer> temp= new LinkedList<>();
			temp.add(num);
			temp.add(i); 
			
			int next = num-i;
			while(true) {
				if(next<0) break;
				
				temp.add(next);
				next=temp.get(temp.size()-2)-temp.get(temp.size()-1);
			}
			if(ans.size()<temp.size()) {
				ans=temp;
			}
		}
		System.out.println(ans.size());
		for(int i:ans) {
			System.out.print(i+" ");
		}
		
	}

}
