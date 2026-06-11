import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Equal0And1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Integer,Integer> map = new HashMap<>();
        int maxLength = 0;
        int sum = 0;
        int idx = 0;
        map.put(0,-1);
        for(char ch : s.toCharArray()) {
            if(ch == '0') {
                sum -= 1;
            }
            else if(ch == '1') {
                sum += 1;
            }
            if(map.containsKey(sum)) {
                maxLength = Math.max(maxLength,idx - map.get(sum)) ;
            }
            else if(!map.containsKey(sum)) {
                map.put(sum,idx);
            }
            idx++;
        }
        System.out.println("Maximum Length of the Substring: " + maxLength);
        sc.close();
    }
}