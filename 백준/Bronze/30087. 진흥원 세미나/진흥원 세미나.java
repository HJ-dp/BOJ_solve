import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<String,String> hs = new HashMap<>();
        hs.put("Algorithm","204");
        hs.put("DataAnalysis","207");
        hs.put("ArtificialIntelligence","302");
        hs.put("CyberSecurity","B101");
        hs.put("Network","303");
        hs.put("Startup","501");
        hs.put("TestStrategy","105");
        
        int a = sc.nextInt();
        for(int i=0;i<a;i++){
            String b = sc.next();
            sb.append(hs.get(b)).append("\n");
        }
        System.out.println(sb);
    }
}