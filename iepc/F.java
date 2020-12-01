
// "static void main" must be defined in a public class.
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
       int n = sc.nextInt();
       int c = sc.nextInt();
       int[] a = new int[n];
       
       
       int l = 0;
       int r = n - 1;
       
       for (int i = 0; i < n; i++) {
    	   a[i] = sc.nextInt();
       }
       
       if (n == 0) {
    	   System.out.println(0);
    	   return;
       }
       if (n == 1) {
    	   System.out.println(1);
    	   return;
       }
       
       Arrays.sort(a);
       while (l < r) {
    	   if (a[l] + a[r] <= c) {
    		   l++;
    		   r--;
    		   n--;
    	   } else {
    		   r--;
    	   }
       }
       
       System.out.println(n);

    }
}