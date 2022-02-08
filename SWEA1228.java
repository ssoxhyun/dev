package day04.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("src//day04//ws//1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <=10; t++) {
			
			LinkedList<Integer> pw = new LinkedList<Integer>();

			int size = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < size; i++) {
				pw.add(Integer.parseInt(st.nextToken()));
			}

			int num = Integer.parseInt(br.readLine()); // 명령어의 개수

			String s = br.readLine();
			st = new StringTokenizer(s, " ");

			for (int i = 0; i < num; i++) {

				st.nextToken(); // 명령어I
				int x = Integer.parseInt(st.nextToken());	//시작위치
				int y = Integer.parseInt(st.nextToken());	//명령어개수

				for (int j = 0; j < y; j++) {
					pw.add(x, Integer.parseInt(st.nextToken()));
					x++;

				}
			}
			System.out.printf("#%d ",t);
			for (int i = 0; i < 10; i++) {
				System.out.printf("%d ",pw.get(i));
			}System.out.println();
		}

	}

}
