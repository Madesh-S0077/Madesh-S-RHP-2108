import java.util.Scanner;
public class LeftShift2 {
    public static void main(String args[]) {
        solve();
    }
    static void solve() {
        String number = new String();
        Scanner sc = new Scanner(System.in);
        number = sc.nextLine();
        int flag = 0;
        for(char ch : number.toCharArray()) {
            flag = flag | (1 << ch - '0');
        }
        if(flag == (1 << 10) -1 ) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
        sc.close();
    }
}
