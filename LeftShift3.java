import java.util.*;
public class LeftShift3 {
    public static void main(String args[]) {
        int flag = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for(char ch : str.toCharArray()) {
            flag = flag | (1 << ch - '0');
        }
        if(flag == ((1 << 10) - 1)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
