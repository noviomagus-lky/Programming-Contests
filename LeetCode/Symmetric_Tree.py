# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isMirror(self, left, right) -> bool:
        
        if left is None and right is None:
            return True
        if left is None or right is None:
            return False
        
        outMirror = self.isMirror(left.left, right.right)
        inMirror = self.isMirror(left.right, right.left)
        
        return outMirror and inMirror and (left.val == right.val)
          
    
    
    def isSymmetric(self, root: TreeNode) -> bool:
        
        if root is None:
            return True
        return self.isMirror(root.left, root.right)
    
  
