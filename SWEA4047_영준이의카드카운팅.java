package IMTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA4047_영준이의카드카운팅 {
	/*
	 * S, D, H, C -> 총 13씩 *4 장= 52 몇장이 부족한지? 같은 카드 나오면 ERROR
	 */
	static int[] S, D, H, C;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			S = new int[14];
			D = new int[14];
			H = new int[14];
			C = new int[14];
			int[] cnt = {13,13,13,13} ;  //S,D,H,C
			int flag=1; // 0:불가능    1:가능 

			
				String s = br.readLine();
				for (int j = 0; j < s.length(); j += 3) {
					char type = s.charAt(j);
					int num = (s.charAt(j + 1) - '0') * 10 + (s.charAt(j + 2) - '0');

					switch (type) {
					case 'S':
						S[num]++;
						if(S[num]>=2) flag=0;
						cnt[0]--;

						break;
					case 'D':
						D[num]++;
						if(D[num]>=2) flag=0;
						cnt[1]--;

						break;
					case 'H':
						H[num]++;
						if(H[num]>=2) flag=0;
						cnt[2]--;

						break;
					case 'C':
						C[num]++;
						if(C[num]>=2) flag=0;
						cnt[3]--;

						break;

					}
				}
				
			
			if(flag==0) System.out.printf("#%d ERROR\n",t);
			else System.out.printf("#%d %d %d %d %d\n", t, cnt[0],cnt[1],cnt[2],cnt[3]);

		}
	}

}
/*
3
S01D02H03H04 
H02H10S11H02 
S10D10H10C01
 
 */
