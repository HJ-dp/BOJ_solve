import java.util.Scanner;

public class Main {

	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	public static int n;
	public static int m;
	public static int x;
	public static int y;
	public static int d;
	public static int[][] map;
	public static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		// 방향
		d = sc.nextInt();
		// 맵 입력받기
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		

		while (true) {
			if (map[x][y]==0) {
				clean();
			} else if(!cleanSearch()) {
				if(!back()) {break;}
			} else {
				turn();
				move();
			}
		}
		
		System.out.println(answer);

	}

	public static boolean back() {
		int temp = (d + 2) % 4;
		int nowx = x + dr[temp];
		int nowy = y + dc[temp];
		if (!isRange(nowx, nowy) || map[nowx][nowy] == 1) {
			return false;
		}
		x = nowx;
		y = nowy;
		return true;
	}

	// 반시계방향 턴
	public static void turn() {
		d = (d + 3) % 4;
	}

	public static void clean() {
		map[x][y]--;
		answer++;
	}
	
	public static void move() {
		int nowx = x + dr[d];
		int nowy = y + dc[d];
		if(isRange(nowx,nowy) && map[nowx][nowy]==0){
			x = nowx;
			y = nowy;
		}
	}
	
	public static boolean cleanSearch() {
		for(int q=0;q<4;q++) {
			int nowx = x + dr[q];
			int nowy = y + dc[q];
			if(isRange(nowx,nowy) && map[nowx][nowy]==0) {
				return true;
			}
		}
		return false;
	}

	public static boolean isRange(int xx, int yy) {
		return 0 <= xx && xx < n && 0 <= yy && yy < m;
	}
}
