class Solution {
    public int reversePairs(int[] nums) {
        
        if(nums.length <= 1)
            return 0;
        return mergesort_count(nums, 0, nums.length-1);
    }
    
    public int mergesort_count(int[] A, int start, int end)
    {
        if(start == end)
            return 0;
        
        int mid = (start + end)/2;
        int count = mergesort_count(A, start, mid) + mergesort_count(A, mid + 1, end);
                
        int j = mid + 1;
        for(int i = start;i <= mid;i++)
        {
            //notice that the input range is the whole range of 32-bit int,
            //so be careful of data overflow
            while(j <= end && A[i] > (long)A[j]*2)
                j++;
            //j <= end + 1;
            count += j - (mid + 1);
                
        }
        
        merge(A, start, mid, end);
        return count;
        
    }
    
    
    public void merge(int[] A, int start, int mid,int end)
    {
        int[] L = new int[mid - start + 1];
        int[] R = new int[end -mid];
        
        for(int i = 0;i < L.length;i++)
        {
            L[i] = A[start + i];
        }
        for(int i = 0;i < R.length;i++)
        {
            R[i] = A[mid + 1 + i];
        }
        int i1 = 0;
        int i2 = 0;
        for(int i = start;i <= end;i++)
        {
            if(i2 >= R.length || i1 < L.length && L[i1] < R[i2])
                A[i] = L[i1++];
            else
                A[i] = R[i2++];
        }
    }
}
