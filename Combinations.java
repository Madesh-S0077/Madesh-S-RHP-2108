import java.util.Scanner;
public class Combinations {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();

        for(int i = 1; i < (1 << length); i++) {
            String comb = "";
            for(int idx = 0; idx < length; idx++) {
                if((i & (1 << idx)) > 0) {
                    comb += str.charAt(idx);
                }
            }
            System.out.println(comb);
        }
        sc.close();
    }
}
