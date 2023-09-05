import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(bf.readLine());
		int[] queue = new int[2000001];
		int front = 0;
		int rear = 0;
		for (int k = 0; k < tc; k++) {

			String[] s = bf.readLine().split(" ");
			switch (s[0]) {
			case "push":
				int n = Integer.parseInt(s[1]);
				queue[rear++] = n;
				break;

			case "pop":
				if (front == rear) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue[front++]).append("\n");
				}
				break;

			case "size":
				if (front == rear) {
					sb.append(0).append("\n");
				} else {
					sb.append(rear - front).append("\n");
				}
				break;

			case "empty":
				if (front == rear) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;

			case "front":
				if (front == rear) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue[front]).append("\n");
				}
				break;

			case "back":
				if (front == rear) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue[rear-1]).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}