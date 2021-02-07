package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 */
public class ReconstructFromPreorderAndInorder {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length < 1 || inorder.length < 1) return null;

    // 因为要根据值查找 index 从而划分左右子树，故建立 hash 提升查找效率
    Map<Integer,Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++)
      inorderMap.put(inorder[i], i);


    return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
  }

  private TreeNode process(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd,
                           Map<Integer, Integer> inorderMap) {
    if (preStart > preEnd || inStart > inEnd) return null;

    TreeNode root = new TreeNode(preorder[preStart]);
    int index = inorderMap.get(preorder[preStart]);
    // 确定in/pre 的左右区间
    int leftLen = index - inStart;
    int rightLen = inEnd - index;

    root.left = process(preorder, preStart + 1, preStart + leftLen,
      inorder, index - leftLen, index - 1, inorderMap);

    root.right = process(preorder, preStart + leftLen + 1, preStart + leftLen + rightLen,
      inorder, index + 1, index + rightLen, inorderMap);

    return root;
  }

  private void restoreTree(TreeNode root, String child,
                           Map<Integer, Integer> indexMap, int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
//    if (preStart > )
    int rootVal = preorder[preStart];
    int rootIndex = indexMap.get(rootVal);
    int leftNum = rootIndex - preStart;
    int rightNum = inorder.length - 1 - rootIndex;

    TreeNode node = new TreeNode(rootVal);
    if (child == "left") root.left = node;
    else root.right = node;

//    restoreTree(node, "left", indexMap, preorder, preStart + 1, start + leftNum,
//      inorder, rootIndex - leftNum, rootIndex - 1);
//    restoreTree(node, "right", indexMap, preorder, preStart + leftNum + 1, start + leftNum + rightNum,
//      inorder, rootIndex + 1, rootIndex + rightNum);

  }
}
