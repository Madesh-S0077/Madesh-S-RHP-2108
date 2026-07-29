package Day3;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;
public class CountDisjointSets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] leader = new int[n+1];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++)
            leader[i] = i;
        for(int i = 0; i < m; i++) {
            int lt = sc.nextInt();
            int rt = sc.nextInt();
            join(leader,lt,rt);
        }
        System.out.println(Arrays.toString(leader));
        for(int i = 1; i <= n; i++) {
            set.add(find(leader,i));
        }
        System.out.println(set.size());
        System.out.println(Arrays.toString(leader));
    }
    static void join(int[] ldr,int left, int right) {
        int leader_left = find(ldr,left);
        int leader_right = find(ldr,right);
        ldr[leader_right] = leader_left;
    }
    static int find(int[] ldr,int val) {
        if(ldr[val] == val) {
            
            return val;
        }
        ldr[val] = find(ldr,ldr[val]);
        return ldr[val];
    }
}
