
// "static void main" must be defined in a public class.

// "static void main" must be defined in a public class.
import java.util.Scanner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
       
        	
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int h = sc.nextInt();
        int temp = 0;
        HashMap<Integer,Integer> map = new HashMap();
        LinkedList<Integer> list = new LinkedList();
        
        for(int i = 0;i < n;i++)
        {
        	 temp = sc.nextInt();
        	 if(!map.containsKey(temp))
        		 {map.put(temp, 1);list.add(temp);}
        	 else
        		 map.replace(temp, map.get(temp)+1);
        	
        }
        sc.close();
        int[][] cards = new int[list.size()][2];
        for(int i = 0;i < list.size();i++)
        {
        	cards[i][0] = list.get(i);
        	cards[i][1] = map.get(cards[i][0]);
        }
        
        Arrays.sort(cards, new Comparator<int[]>() {
        	public int compare(int[] o1, int[] o2)
        	{
        		if(o1[1] > o2[1])
        			return -1;
        		else
        			return 1;
        	}
        });
        list.clear();
        for(int i = 0;i  < cards.length;i++)
        {
        	map.replace(cards[i][0], i);
        	list.add(cards[i][0]);
        }
        int[] result = new int[h];
        int count = 0;
        while(list.size() >= 0)
        {
        	result = new int[h];
        	int index = 0;
        	for(int i = 0;i < h;i++)
            {
            	if(index >= list.size())
            	{
            		if(count == 0)
            		System.out.print("impossible");
            		return;
            	}
            	result[i] = list.get(index);
            	cards[map.get(list.get(index))][1] -= 1;

            	if(cards[map.get(list.get(index))][1] == 0)
            		list.remove(index--);
            	index ++;
            	
            }
        	count ++;
        	for(int i = 0;i < h;i++)
        	{
        		System.out.printf("%d ", result[i]);
        	}
        	System.out.print("\n");
        }
        
        
        return;
      
    }
   
}