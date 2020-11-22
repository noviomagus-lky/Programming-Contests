class Solution {
    public int jump(int[] nums) {
        
          int initial = 0;
        int jump = nums[0];
        int n = nums.length;
        int result = 0;
        if(n == 1)
            return 0;
        
        if(n > 1)
        while(initial+jump < n-1)
        {              
            int newjump = nums[initial+1];
            int newinitial = initial+1;
            
            for(int i = initial + 1;i <= initial + jump;i++)
            {
                if(nums[i]+i-newinitial>= newjump)
                {newjump = nums[i]; newinitial = i;}         
            }
            result++;
            jump = newjump;
            initial = newinitial;
        }
        
        result++;
     
        return result;
    }
}
