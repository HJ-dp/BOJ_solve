import java.util.*;

public class Main {
    public static int n, m, uf[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1;tc<=t;tc++){
            n = sc.nextInt();
            m = sc.nextInt();
            uf = new int[n+1];
            for(int i=1;i<=n;i++){
            	uf[i] = i;
            }
            for(int i=0;i<m;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                union(a,b);
            }
            HashSet<Integer> hm = new HashSet<>();
            for(int i=1;i<=n;i++){
                hm.add(find(i));
            }
            System.out.println(n-1);
        }
    }
    public static void union(int x,int y){
        int X = find(x);
        int Y = find(y);
        uf[X] = Y;
    }

    public static int find(int x){
        if(uf[x]==x){
            return x;
        }
        int root = find(uf[x]);
        uf[x] = root;
        return root;
    }

}