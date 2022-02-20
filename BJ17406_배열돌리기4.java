package day07.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17406_배열돌리기4 {
	static int[][] arr;
	static int[][] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken()); // 회전연산개수

		arr = new int[R][C]; 
		for (int i = 0; i < R ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;	//인덱스 맞추려고 1개씩 뺌
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken()); // 2*s+1의 정사각형이 생김.

			int size = 2 * s + 1;
			temp = new int[size][size];

			for (int i = 0; i < size; i++) { // 돌릴 사각형 temp에 저장
				for (int j = 0; j < size; j++) {
					temp[i][j] = arr[r - s + i][c - s + j];
				}
			}
			rotate(temp);

			for (int i = 0; i < size; i++) { // 돌린 결과인 temp를 다시  arr에 저장
				for (int j = 0; j < size; j++) {
					arr[r - s + i][c - s + j] = temp[i][j];
				}
			}
		
		

		int sum=0,min=Integer.MAX_VALUE;
		for (int i=0; i<R; i++) {
			sum=0;
			for(int j=0;j<C; j++) {
				sum+=arr[i][j];
			}
			if(min>sum) min=sum;
		}
		
		System.out.println(min);
	}

	public static void rotate(int[][] Arr) {
		int square = Arr.length / 2; // 회전해야 하는 사각형 갯수
		int N = Arr.length;

		for (int i = 0; i < square; i++) {
			// 사각형갯수 체크
			int tmp = Arr[i][i];

			for (int j = i + 1; j < N - i; j++) // 상
				Arr[j - 1][i] = Arr[j][i];

			for (int j = i + 1; j < N - i; j++) // 좌
				Arr[N - 1 - i][j - 1] = Arr[N - 1 - i][j];

			for (int j = N - 2 - i; j >= i; j--)// 하
				Arr[j + 1][N - 1 - i] = Arr[j][N - 1 - i];

			for (int j = N - 2 - i; j >= i; j--) // 우
				Arr[i][j + 1] = Arr[i][j];

			Arr[i][i + 1] = tmp;
		}


	}

}
