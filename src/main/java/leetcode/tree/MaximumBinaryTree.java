package leetcode.tree;

public class MaximumBinaryTree {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return process(nums, 0, nums.length - 1);
  }

  private TreeNode process(int[] nums, int start, int end) {
    if (start > end) return null;

    int maxIndex = start;
    for (int i = start + 1; i <= end; i++) {
      if (nums[maxIndex] < nums[i]) maxIndex = i;
    }

    TreeNode root = new TreeNode(nums[maxIndex]);

    root.left = process(nums, start, maxIndex - 1);
    root.right = process(nums, maxIndex + 1, end);

    return root;
  }
}
