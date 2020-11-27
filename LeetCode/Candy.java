class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        if(n <= 1)
            return n;
        
        candies[0] = 1;
        
        int sum = 0;
        
        for(int i = 1;i < n;i++)
        {
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
            
            else if(ratings[i] == ratings[i-1])
                candies[i] = 1;
            
            else //ratings[i] < ratings[i-1]
            {
                candies[i] = 1;
                int j = 1;
                while(i-j >= 0 && ratings[i-j] > ratings[i-j+1] && candies[i-j] <= candies[i-j+1])
                {
                    candies[i-j] = candies[i-j+1] + 1;
                    j++;
                }
            }
            
        }
        
        for(int i = 0;i < n;i++)
        {
            sum += candies[i];
        }
        
        return sum;
    }
}
