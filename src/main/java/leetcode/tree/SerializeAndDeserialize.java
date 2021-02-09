package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * 总体注意点：字符串的处理使用 StringBuilder
 */
public class SerializeAndDeserialize {
  static String SEPARATOR = ",";
  static String NULL = "#";


  /**
   * Encodes a tree to a single string.
   * 要点：
   * 1.要能区分节点之间的值，即节点之间要有分隔符
   * 2.要能区分空节点，即空节点要有占位符
   */
  public String serialize(TreeNode root) {
    StringBuilder builder = new StringBuilder();

    traverse(root, builder);

    return builder.toString();
  }

  private void traverse(TreeNode root, StringBuilder builder) {
    if (root == null) {
      builder.append(NULL);
      return;
    }

    builder.append(root.val);

    builder.append(SEPARATOR);
    traverse(root.left, builder);

    builder.append(SEPARATOR);
    traverse(root.right, builder);
  }

  /**
   * Decodes your encoded data to tree.
   * 要点：
   * 1. 必须先构造根节点，再构造子树；因为如果先构造子节点，无法知道其父节点
   * 2. 如果是使用递归方式，注意输入数据的指针移动, 基本类型是值传递的，则变通方式有：
   * - 成员变量
   * - 使用链表/双端队列，动态移除复原过的节点
   * - 使用只存储一个元素的数组 ✅
   */
  public TreeNode deserialize(String data) {
    if (data.equals(NULL)) return null;
    //
    String[] strings = data.split(",");

    int[] begin = new int[]{0};

    return traverse(strings, begin);
  }

  TreeNode traverse(String[] strings, int[] begin) {
    if (begin[0] >= strings.length || NULL.equals(strings[begin[0]])) return null;

    TreeNode root = new TreeNode(Integer.parseInt(strings[begin[0]]));

    begin[0]++;
    root.left = traverse(strings, begin);

    begin[0]++;
    root.right = traverse(strings, begin);

    return root;
  }

}
