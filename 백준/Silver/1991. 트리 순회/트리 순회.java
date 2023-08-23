import java.util.Scanner;

public class Main {
	public static Node[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new Node[N + 1];

		for (int i = 0; i < N; i++) {
			arr[i] = new Node();
		}

		for (int tc = 0; tc < N; tc++) {
			char a = sc.next().charAt(0);
			char b = sc.next().charAt(0);
			char c = sc.next().charAt(0);
			arr[a - 65].data = a;

			if (b - 65 < N && b != '.') {
				arr[a - 65].lcIdx = arr[b - 65];
			}
			if (c - 65 < N && c != '.') {
				arr[a - 65].rcIdx = arr[c - 65];
			}
		}

		preorder(arr[0]);
		System.out.println();
		inorder(arr[0]);
		System.out.println();
		postorder(arr[0]);

	}

	public static void inorder(Node node) {
		if (node.lcIdx != null) {
			inorder(node.lcIdx);
		}

		System.out.print(node.data);

		if (node.rcIdx != null) {
			inorder(node.rcIdx);
		}
	}

	public static void preorder(Node node) {
		System.out.print(node.data);

		if (node.lcIdx != null) {
			preorder(node.lcIdx);
		}

		if (node.rcIdx != null) {
			preorder(node.rcIdx);
		}
	}

	public static void postorder(Node node) {

		if (node.lcIdx != null) {
			postorder(node.lcIdx);
		}

		if (node.rcIdx != null) {
			postorder(node.rcIdx);
		}
		System.out.print(node.data);
	}

	public static class Node {
		char data;
		Node pIdx, lcIdx, rcIdx;

		Node() {
			this.data = ' ';
			this.lcIdx = null;
			this.rcIdx = null;
		}

	}

}