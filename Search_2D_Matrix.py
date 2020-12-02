class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        
        left = 0
        right = m
        mid = floor(m/2)
        while left != right:
            if matrix[mid][0] == target:
                return True
            elif matrix[mid][0] > target:
                right = mid
                mid = floor((left + right)/2)
            else:
                left = mid + 1
                mid = floor((left + right)/2)
        
        for i in range(0, mid):
            left = 0
            right = n
            mid = floor(n/2)
            while left != right:
                if matrix[i][mid] == target:
                    return True
                elif matrix[i][mid] > target:
                    right = mid
                    mid = floor((left + right)/2)
                else:
                    left = mid + 1
                    mid = floor((left + right)/2)
        return False
                    
                    
