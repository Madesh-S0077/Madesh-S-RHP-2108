import java.util.Scanner;
public class LeftShift1 {
     public static void main(String[] args) {
        solve();
    }
    static void solve() {
        String s = new String();
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        int capital = 0, small = 0;
        for (char ch : s.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                capital = capital | (1 << ch - 'A');
            }
            else {
                small = small | (1 << ch - 'a');
            }
        }
        if((small == (1 << 26) - 1) && (capital == (1 << 26) - 1)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
        sc.close();
    }
}
