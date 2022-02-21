package day13.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준1759

public class BJ1759_암호만들기 {
	static int L, C;
	static char[] arr,code;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken());			//암호길이
		C = Integer.parseInt(st.nextToken());
		//문자갯수 
		st = new StringTokenizer(br.readLine()," ");
		arr = new char[C];
		for(int i=0; i<C; i++) {
			arr[i]=st.nextToken().charAt(0);
		}
		code = new char[L];
		
		Arrays.sort(arr);			//문자열이 앞에 나와야하니까 정렬 필수
		
		
		comb(0,0);
	}

	private static void comb(int cnt, int start) {
		
		if(cnt==L) {
			if(isPossible()) {
				System.out.println(code);
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			code[cnt]=arr[i];
			comb(cnt+1,i+1);
		}
	}

	private static boolean isPossible() {
		int m=0; //모음
		int j=0; //자음
		
		for(char c :code) {
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') m++;		//모음 개수 카운트
			else j++;											//자음 개수 카운트
		}
		
		if(m>=1&&j>=2) return true;			//모은 1개이상 자음 2개이상 일때 가능
		
		return false;
	}
	
	

}
