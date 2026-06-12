import java.util.Scanner;
public class KarenCoffee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of recipes: ");
        int n = sc.nextInt();
        System.out.println("Enter the required min count of recipes: ");
        int k = sc.nextInt();
        System.out.println("Enter the no. of queries: ");
        int q = sc.nextInt();
        final int  MAX = 200002;
        int[] diff = new int[MAX];
        for(int i = 0; i < n ; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            diff[l]++;
            diff[r+1]--;
        }
        int[] admissible = new int[MAX];
        int count = 0;
        for(int i = 0; i < MAX; i++) {
            count += diff[i];
            if(count >= k) {
                admissible[i] = 1;
            }
            else {
                admissible[i] = 0;
            }
        }
        int[] pref = new int[MAX];
        pref[0] = admissible[0];
        for(int i = 1; i < MAX; i++) {
            pref[i] = pref[i-1] + admissible[i];
        }
        for(int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = pref[b] - pref[a-1];
            System.out.println(ans);
        }
        sc.close();
    }
}
