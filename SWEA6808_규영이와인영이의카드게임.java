package day08.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA6808_규영이와인영이의카드게임 {
	static int W,L;
	static int[] input; //input : 입력수배열(규영이 카드)
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src//day08//ws//6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc= Integer.parseInt(st.nextToken());
		
		for(int t=0; t<tc; t++) {
			isSelected= new boolean[19];
			input= new int[9];
			st= new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				int num=Integer.parseInt(st.nextToken());
				input[i]=num;
				isSelected[num]=true;
			}
			
			W=0;		//규영 이김
			L=0;		//규영 짐
			
			permutation(0, 0, 0);
			
			System.out.printf("#%d %d %d \n",t+1,W,L);
		
			
			
			
		}

	}
	public static void permutation(int cnt,int GyuScore, int InScore) {	//cnt : 인덱스로 쓰지만 "직전까지 뽑은 수의 개수"라고 생각하면 좋음
		
		//기저파트
		if(cnt ==9) {
			if(GyuScore>InScore) {
				W++;
			}else {
				L++;
			}
			
			return;
		}
		
		for(int i=1; i<19; i++) {
			
			if(isSelected[i]) continue;			//규영이가 가지고 있으면, pass
			isSelected[i]=true;
			
			int sum= input[cnt]+i;	//카드의 합	
			
			if(input[cnt]>=i) {	//규영이의 카드가 더 크면  규영 + 카드합
				permutation(cnt+1, GyuScore+sum, InScore);
			}
			else {
				permutation(cnt+1, GyuScore, InScore+sum);
			}
			isSelected[i]=false;
		}
	}
}
