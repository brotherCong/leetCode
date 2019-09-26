package algorithms.lt0094;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TreeInorderTraversal
 * Description 二叉树的中序遍历
 * Author cds
 * Date 2019/9/20 16:56
 * Version 1.0
 **/
public class TreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;

    }
    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
