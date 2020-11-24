class Solution(object):
    def partitionLabels(self, S):
        last = {c: i for i, c in enumerate(S)}
        # output of enumerate():
        #[(index1, value1),()....()]
        #通过enumerate构建反向哈希表， 自动刷新index使其为相同value最后出现的index, O(N)
        
        j = anchor = 0
        ans = []
        for i, c in enumerate(S):
            j = max(j, last[c])
            if i == j:
                ans.append(i - anchor + 1)
                anchor = i + 1
            
        return ans
            
