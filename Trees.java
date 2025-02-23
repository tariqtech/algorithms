class Trees {

  /*
  Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
  A leaf is a node with no children.
  */
   public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return targetSum == root.val;
    }
    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,
        targetSum - root.val);
  }
  
  /*
  Given the roots of two binary trees p and q, write a function to check if they are the same or not.
  Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
  */
  public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q==null) {
            return true;
        }
        if(p==null || q==null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
  
  /*
  Given the root of a binary tree, return its maximum depth.
  A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
  */
  public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
  
  
  /*
  Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
  */
      public TreeNode sortedArrayToBST(int[] nums) {
        
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums, int left, int right) {
        
        
        if (left > right) {
            return null;
        }
            int mid = left + (right - left) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = helper(nums, left,  mid - 1);
            node.right = helper(nums, mid+1, right);
            return node;
        
        
    }
  
  
  
  
}
