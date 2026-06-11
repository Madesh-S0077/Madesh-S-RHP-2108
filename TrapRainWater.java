import java.util.Scanner;
public class TrapRainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] height = new int[length];
        for(int i = 0; i < length; i++) {
            height[i] = sc.nextInt();
        }
        System.out.println(trap(height));
        sc.close();
    }
    static int trap(int[] height) {
        int l = height.length;
        int[] leftMax = new int[l];
        int[] rightMax = new int[l];
        int amount = 0;
        leftMax[0] = height[0];
        for(int i = 1; i < l; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        rightMax[l-1] = height[l-1];
        for(int i = l - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        for(int i = 0; i < l; i++) {
            if(height[i] < leftMax[i] && height[i] < rightMax[i]) {
                amount += Math.min(leftMax[i],rightMax[i]) - height[i];
            }
        }
        return amount;
    }
}
