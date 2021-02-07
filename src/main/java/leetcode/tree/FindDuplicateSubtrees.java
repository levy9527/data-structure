package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 */
public class FindDuplicateSubtrees {
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    if (root == null) return result;
    // 前序遍历。
    // 序列化每棵子树，使用 hash 进行匹配
    Map<String, Integer> map = new HashMap<>();

    serialize(root, map, result);

    return result;
  }

  private String serialize(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
    String SEPARATOR = ",", NULL = "#";
    if (root == null) return NULL;

    StringBuilder builder = new StringBuilder();

    builder.append(root.val);

    builder.append(SEPARATOR);
    builder.append(serialize(root.left, map, result));

    builder.append(SEPARATOR);
    builder.append(serialize(root.right, map, result));

    String str = builder.toString();
    map.merge(str, 1, Integer::sum);
    if (map.get(str) == 2) result.add(root);

    return str;
  }

}

