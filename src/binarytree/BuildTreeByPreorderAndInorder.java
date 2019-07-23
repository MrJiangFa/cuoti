package binarytree;

import java.util.Arrays;

public class BuildTreeByPreorderAndInorder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int indexOfRootInorder = 0;
        while (indexOfRootInorder < inorder.length) {
            if (inorder[indexOfRootInorder] == preorder[0]) {
                break;
            }
            indexOfRootInorder++;
        }
        int[] leftTreePreorder = Arrays.copyOfRange(preorder, 1, indexOfRootInorder + 1);
        int[] leftTreeInorder = Arrays.copyOfRange(inorder, 0, indexOfRootInorder);
        int[] rightTreePreorder = Arrays.copyOfRange(preorder, indexOfRootInorder + 1, preorder.length);
        int[] rightTreeInorder = Arrays.copyOfRange(inorder, indexOfRootInorder + 1, inorder.length);
        TreeNode l = buildTree(leftTreePreorder, leftTreeInorder);
        TreeNode r = buildTree(rightTreePreorder, rightTreeInorder);
        root.left = l;
        root.right = r;
        return root;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
