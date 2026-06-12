import java.util.Scanner;
import java.util.Arrays;
public class ShariAndNeta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int shari = sc.nextInt();
        int neta = sc.nextInt();
        int[] arr1 = new int[shari];
        int[] arr2 = new int[neta];
        for(int i = 0; i < shari; i++) {
            arr1[i] = sc.nextInt(); 
        }
        for(int i = 0; i < neta; i++) {
            arr2[i] = sc.nextInt(); 
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        shari--; neta--;
        int count = 0;
        while(shari >= 0 && neta >= 0) {
            if(arr2[neta] <= 2 * arr1[shari]) {
                count++;
                neta--; shari--;
            }
            else {
                neta--;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
