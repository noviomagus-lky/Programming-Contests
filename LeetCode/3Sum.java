class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) break;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) j++;
                else if (sum > 0) k--;
                else {
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    // Skip duplicate numbers of j
                    while (j+1 <= k && arr[j] == arr[j+1]) j++;
                    j++;
                    k--;
                }
            }
            // Skip duplicate numbers of i
            while (i + 1 < n && arr[i + 1] == arr[i]) i++;
        }
        return ans;
    }
}     
        
