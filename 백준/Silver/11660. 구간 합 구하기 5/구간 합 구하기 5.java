import java.io.*;


public class Main {

	public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //N의 크기
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        //출력 횟수
        int m = Integer.parseInt(input[1]);
        //맵
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            input = bf.readLine().split(" ");
            int sum = 0;
            for (int j=0;j<n;j++){
                sum += Integer.parseInt(input[j]);
                arr[i][j] = sum;
            }
        }
        //x1y1x2y2
        for(int t=0;t<m;t++){
            input = bf.readLine().split(" ");
            int x1 = Integer.parseInt(input[0])-1;
            int y1 = Integer.parseInt(input[1])-1;
            int x2 = Integer.parseInt(input[2])-1;
            int y2 = Integer.parseInt(input[3])-1;
            int sum = 0;
            for(int i = x1;i <= x2; i++){
                sum += arr[i][y2];
                if (y1!=0){
                    sum -= arr[i][y1-1];
                }
            }
			sb.append(sum).append("\n");   
        } 
		System.out.println(sb);
    }
}