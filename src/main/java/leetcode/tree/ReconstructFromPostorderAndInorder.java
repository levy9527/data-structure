package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class ReconstructFromPostorderAndInorder {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    // 左右根
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

    return process(inorder, 0, inorder.length - 1,
      postorder, 0, postorder.length - 1, map);
  }

  private TreeNode process(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd,
                           Map<Integer, Integer> map) {
    // 终止条件
    if (inStart > inEnd || postStart > postEnd) return null;

    int rootIndex = map.get(postorder[postEnd]);
    int leftLen = rootIndex - inStart;
    int rightLen = inEnd - rootIndex;
    TreeNode root = new TreeNode(postorder[postEnd]);

    // 先算 inorder
    root.left = process(inorder, rootIndex - leftLen, rootIndex - 1,
      postorder, postEnd - rightLen - leftLen, postEnd - rightLen - 1, map);
    root.right = process(inorder, rootIndex + 1, rootIndex + rightLen,
      postorder, postEnd - rightLen, postEnd - 1, map);

    return root;
  }
}
