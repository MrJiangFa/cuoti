package binarysearchtree.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定整数n，求以 1——n 为节点构成的二叉搜索树（binary search tree,BST)有多少种
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 解法：
 * 对于 1——n 中的每一个数i，如果以i为顶点，1——（i-1）位于i的左子树，i——n 位于i的右子树
 * 然后可以通过迭代的方式构建子树，通过上述方式可以保证每一个BST都是唯一的
 * <p>
 * G(n)：对于长度为n的序列，BST的个数
 * F(i,n)：当i为BST的根节点的时，唯一BST的个数
 * G(n) = F(1, n) + F(2, n) + ... + F(n, n)
 * G(0)=1, G(1)=1.
 * 例子：对于i=3，n=7 求解F(1,7)
 * F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
 * 所以有：
 * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
 * G(i) = F(0,i-1)+F(1,i-2)+……+F(i-1,0) = G(0)*G(i-1)+G(1)*G(i-2)+……G(i-1)*G(0)
 */
public class Code_96_NumOfBST {
    public static void main(String[] args) {
        System.out.println(numOfBST(4));
    }

    public static int numOfBST(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                G[i] += G[j] * G[i - 1 - j];
            }
        }
        return G[n];
    }

    /**
     * 返回所有1——n 可以表示的BST，返回值为List<TreeNode>表示BST的根节点；
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();//list.add(null); 那么list.size()=1;
        }
        return genTrees(1, n);
    }

    public List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {

            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
