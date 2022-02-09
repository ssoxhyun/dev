package day05.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()); //학생수
		
		String s=br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		int cnt=1;	//학생번호 
		for(int i=0; i<num; i++) {
			int idx=Integer.parseInt(st.nextToken());
			if(idx==0) {
				list.add(cnt-1, cnt);
			}else {
				list.add(cnt-idx-1,cnt);
			}
			cnt++;
			
		}
		for(int i=0; i<num; i++) {
			System.out.printf("%d ",list.get(i));
		}
	}
}
