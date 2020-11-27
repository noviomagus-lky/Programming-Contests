class Solution {
    public int maxCoins(int[] nums) {
        
        //m[i,j] = max(i<=k<=j){m[i,k-1] + c(i-1)*c(k)*c(j+1) + m[k+1,j]}
        // save the last balloon left for m[i,j]
        
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 0)
            return 0;   
       
        int[][] coins = new int [n][n];
        
        coins[0][0] = nums[0]*nums[1];
        coins[n-1][n-1] = nums[n-1]*nums[n-2];
        
        for(int i = 1;i < n-1;i++)
        {
            coins[i][i] = nums[i]*nums[i-1]*nums[i+1];     
        }
        
        int left,right,j;
        
        for(int l = 2;l <= n;l++)
            for(int i = 0;i <= n-l;i++)
            {
                 j = i+l-1;
                
                if(i == 0)
                    left = 1;
                else
                    left = nums[i-1];
                if(j == n-1)
                    right = 1;
                else
                    right = nums[j+1];
                
                for(int k = i;k  <= j;k++)
                {
                    int temp = 0;
                    
                    if(k == i)
                        temp = coins[k+1][j] + nums[k]*left*right;
                    else if(k == j)
                        temp = coins[i][k-1] + nums[k]*left*right;
                    else
                        temp = coins[i][k-1] + coins[k+1][j] + nums[k]*left*right;
                    
                    coins[i][j] = Math.max(coins[i][j],temp);
                }
            }
                
        return coins[0][n-1];
                      
    } 
}
