package day06.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1158_요세푸스 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");

		int size = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= size; i++) {
			q.add(i);
		}
		
		sb.append("<");
		while(q.size()>1) {
			for(int i=1; i<=num; i++) {
				if(i<num)
					q.add(q.poll());	//뒤로 보내기
				else
				sb.append(q.poll()+", ");	//num번째 숫자 가져오기
			}
		}
		sb.append(q.poll()+">");
		System.out.println(sb);

	}

}
