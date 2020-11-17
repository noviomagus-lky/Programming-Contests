class Solution {
    public int reverse(int x) {
        
        List<Integer> digits = new ArrayList<Integer>();
        boolean sign = (x > 0);
        long result = 0;
        
        if(!sign)
            x= -x;
        while(x > 0)
        {
            digits.add(x % 10);
            x = x /10;
            
        }
        
        for(int i = 0 ; i < digits.size(); i++)
        {
            result += digits.get(i) * Math.pow(10, digits.size() - i - 1);
        }
        if(result <= Math.pow(2, 31) - 1 && sign)
            return((int)result);
        else if(result <= Math.pow(2, 31) && (!sign))
            return((int)result * -1);
        else
            return 0;
            
    }
}
