package day02.ws;

import java.util.Scanner;

public class swea1873_battle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			sc.nextLine();

			int x = 0, y = 0;
			int[] dx = { -1, 0, 1, 0 }; // 상,우,하,좌 (U,R,D,L)
			int[] dy = { 0, 1, 0, -1 };
			char car = 'o';

			// 게임 맵 만들면서 전차 찾기
			char[][] map = new char[H][W];
			for (int r = 0; r < H; r++) {
				String s = sc.nextLine();
				for (int c = 0; c < W; c++) {
					map[r][c] = s.charAt(c);
					if (map[r][c] == '>' | map[r][c] == '^' | map[r][c] == '<' | map[r][c] == 'v') {
						x = r;
						y = c;
						car = map[r][c]; // 현재 바라보고 있는 위치
					}
				}
			}

			// 명령어 받아오기
			int num = sc.nextInt();
			sc.nextLine();
			char[] arr = new char[num];
			String input = sc.nextLine();

			for (int i = 0; i < num; i++) {
				arr[i] = input.charAt(i);
			}

			int nx = 0, ny = 0;

			// 명령어 URDLS 수행
			for (int i = 0; i < num; i++) {
				switch (arr[i]) {
				case 'U':
					nx = x + dx[0];
					ny = y + dy[0];
					car = '^';
					if (nx >= 0 && map[nx][ny] == '.') {
						// 새로운 위치가 맵을 벗어나지 않고 평지이면
						map[x][y] = '.'; // 현재위치 평지로 만들고
						map[nx][ny] = '^'; // 새로운 위치에 위를 바라보는 방향
						x = nx; // 현재위치 수정
						y = ny;
					} else {
						map[x][y] = '^'; // 평지가 아니면, 바라보는 방향만 변경
					}

					break;
				case 'R':
					nx = x + dx[1];
					ny = y + dy[1];
					car = '>';
					if (ny < W && map[nx][ny] == '.') {
						map[x][y] = '.';
						map[nx][ny] = '>';
						x = nx;
						y = ny;
					} else {
						map[x][y] = '>';
					}

					break;
				case 'D':
					nx = x + dx[2];
					ny = y + dy[2];
					car = 'v';
					if (nx < H && map[nx][ny] == '.') {
						map[x][y] = '.';
						map[nx][ny] = 'v';
						x = nx;
						y = ny;
					} else {
						map[x][y] = 'v';
					}

					break;
				case 'L':
					nx = x + dx[3];
					ny = y + dy[3];
					car = '<';
					if (ny >= 0 && map[nx][ny] == '.') {
						map[x][y] = '.';
						map[nx][ny] = '<';
						x = nx;
						y = ny;
					} else {
						map[x][y] = '<';
					}

					break;
				case 'S':
					switch (car) {
					case '^':

						for (int j = x - 1; j >= 0; j--) {
							if (map[j][y] == '*') {
								map[j][y] = '.';
								break;
							}
							if (map[j][y] == '#')
								break;

						}
						break;

					case '>':

						for (int j = y + 1; j < W; j++) {
							if (map[x][j] == '*') {
								map[x][j] = '.';
								break;
							}
							if (map[x][j] == '#')
								break;

						}
						break;

					case 'v':

						for (int j = x + 1; j < H; j++) {
							if (map[j][y] == '*') {
								map[j][y] = '.';
								break;
							}
							if (map[j][y] == '#')
								break;

						}
						break;
					case '<':

						for (int j = y - 1; j >= 0; j--) {
							if (map[x][j] == '*') {
								map[x][j] = '.';
								break;
							}
							if (map[x][j] == '#')
								break;

						}
						break;

					}
					break;

				}
			}

			System.out.printf("#%d ", t + 1);
			for (char[] r : map) {
				for (char c : r) {
					System.out.print(c);
				}
				System.out.println();
			}
		}

	}

}
