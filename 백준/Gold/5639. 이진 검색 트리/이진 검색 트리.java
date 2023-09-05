import java.util.Scanner;

public class Main {

	public static node root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        All:
		while (true) {
			try {
				int a = sc.nextInt();
				insert(a);
			} catch (Exception e) {
				break All;
			}
		}
		print(root);
		
	}
	
	public static void print(node n) {
        if(n!=null){
            print(n.leftChild);
            print(n.rightChild);
		    System.out.println(n.value);
        }
	}

	public static void insert(int x) {
		node now = root;
		node p = root;
		while (now != null) {
			p = now;
			if (now.value > x) {
				now = now.leftChild;
			} else {
				now = now.rightChild;
			}
		}
		if (p == null) {
			root = new node(x);
		} else if (p.value > x) {
			p.leftChild = new node(x);
		} else {
			p.rightChild = new node(x);
		}
	}

	static class node {
		node parent;
		node leftChild;
		node rightChild;
		int value;

		public node(int x) {
            this.value = x;
		}
	}

}