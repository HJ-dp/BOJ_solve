import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, answer[];
	public static boolean visited[];
	public static Queue<Integer> q = new LinkedList<>();
	public static int[] li = new int[101];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		answer = new int[101];
		visited = new boolean[101];
		// 맵 입력받기
		for(int i=0;i<N+M;i++) {
			temp = bf.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			li[a] = b;
		}// 입력 끝
		push(1);
        BFS();
        System.out.println(answer[100]);
	}
	
	public static void push(int x) {
        if(canGo(x)){
            visited[x]= true;
            q.add(x);
        }
	}
	
	public static void BFS() {
		while(!q.isEmpty()) {
			int Num = q.poll();
			int nowX;
            //뱀이나 사다리면
			if(li[Num]!=0) {
				nowX = li[Num];
				if(canGo(nowX) || (isRange(nowX)&&answer[nowX]>answer[Num])) {
					answer[nowX] = answer[Num];
					push(nowX);
				}
			} else {//없으면 주사위로 이동
                for(int i=1;i<7;i++) {
                    nowX = Num + i;
                    if(canGo(nowX)|| (isRange(nowX)&&answer[nowX]>answer[Num])) {
                        answer[nowX] = answer[Num]+1;
                        push(nowX);
                    }
                }
            }
		}
	}
	
	public static boolean isRange(int x) {
		return 1 <= x && x < 101;
	}

	public static boolean canGo(int x) {
		if (!isRange(x))
			return false;
		else if (visited[x])
			return false;
		return true;
	}
	
}