
// "static void main" must be defined in a public class.

// "static void main" must be defined in a public class.
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        double a,b,c,ans = 0;
        LinkedList<Double> dist = new LinkedList();
       
        
        for(int i = 0;i < n;i++)
        {
        	a = sc.nextDouble();
        	b = sc.nextDouble();
        	c = sc.nextDouble();
        	dist.add(dist(a, b, c)) ;

        }
        PriorityQueue<Double> q = new PriorityQueue(dist);
        for(int i = 0;i < k;i++)
        	ans = q.remove();
        System.out.printf("%f",Math.sqrt(ans));
        return;

    }
    public static double dist(double a,double b,double c)
    {
    	double result = a*a + b*b + c*c;
    	return result;
    }
}