# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        # dia(root) = max{dia(root.left), dia(root.right), h(root.left) + h(root.right)}
        
        if root is None:
            return 0
        
        #Recurse first to refresh the node values to height
        leftDia = self.diameterOfBinaryTree(root.left)
        rightDia = self.diameterOfBinaryTree(root.right)
        
        if root.left is None:
            leftHeight = 0
        else:
            leftHeight = root.left.val
         
        if root.right is None:
            rightHeight = 0
        else:
            rightHeight = root.right.val
        
        root.val = max(leftHeight, rightHeight) + 1
           
        return max(leftDia, rightDia, leftHeight + rightHeight)
