import java.util.*;

class Solution {
    
    public static int[][] result = new int[4][2];
    public static boolean[] visited = new boolean[4];
    public static int[][] target;
    public static int answer = 0;
    public int solution(int[][] dots) {
        target = dots;
        permutation(0);
        return answer;
    }
    private static void permutation(int cnt) {
		if (cnt == 4) {
			double a = degree(result[0],result[1]);
            double b = degree(result[2],result[3]);
            if (a==b){ answer = 1;}
			return;
		}
		// 대상 집합을 순회하며 숫자를 하나 선택한다.
		for (int i = 0; i < 4; i++) {
			// 이미 해당 숫자를 선택한 경우에는 스킵.
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			result[cnt] = target[i];
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
    
    public static double degree(int[] x, int[] y){
		double dx =  y[0] - x[0];
		double dy = y[1] - x[1];
        double r = Math.toDegrees(Math.atan2(dx, dy));
        return r;
    }
}