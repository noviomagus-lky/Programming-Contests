class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        
        int l = 0;
        int index = 0;
        char newchar;
        List<Character> sub = new ArrayList<Character>();
        
        for(int i = 0; i < s.length(); i++)
        {
            newchar = s.charAt(i);
            if(sub.contains(newchar))
            {
                index = sub.indexOf(newchar);
                for(int j = 0; j <= index; j++)
                    sub.remove(0);
            }
            sub.add(newchar);
            if(sub.size() > l)
                l = sub.size();
        }
        return l;
    }
}
