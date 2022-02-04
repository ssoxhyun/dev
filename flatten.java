package day02.ws;

import java.util.Arrays;
import java.util.Scanner;

public class flatten {

	public static void main(String[] args) {

		int tc = 10;
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < tc; t++) {
			int count = sc.nextInt();
			int[] arr = new int[100];

			for (int i = 0; i < 100; i++)
				arr[i] = sc.nextInt();
			
			dump(arr,count);

			Arrays.sort(arr);
			for (int i = 0; i < count; i++) {
				arr[0]++;
				arr[99]--;

				Arrays.sort(arr);
			}
			System.out.printf("#%d %d\n",t+1,arr[99] - arr[0]);
		}

	}

	public static void dump(int[] arr, int num) {
		int min = 100;
		int max = 1;
		int minidx = 0, maxidx = 0;
		int cha = 0;
		int cnt=0;

		for (int i = 0; i < num; i++) {

			for (int j = 0; j < 100; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minidx = j;
				}
				if (arr[j] > max) {
					max = arr[j];
					maxidx = j;
				}
			}
			arr[minidx]++;
			arr[maxidx]--;
			cha = arr[maxidx] - arr[minidx];

		}
		System.out.printf("#%d %d\n",++cnt,cha);
	}

}
