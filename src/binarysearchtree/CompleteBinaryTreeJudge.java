package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeJudge {
    //判断一棵树是否为完全二叉树，分四种情况讨论，层序遍历时，如果两个儿子双全，那么继续遍历下一个
    //节点，如果左儿子为空，右儿子为非空，直接返回false；如果左儿子为非空，右儿子为空，或者左右儿子
    //皆为空，那么此节点后的每一个节点必须为空，否则返回false；
    Queue queue = new LinkedList();
    boolean isLeaf = false;//表示开启了3,4两种情况的阶段，为true时表示后面的节点必须都为空


    //求解完全二叉树节点个数
    //先遍历整个二叉树的整个左边界，求解整个二叉树的高度，h=O(logN)
    //遍历头结点右子树的左边界，查看该左边界是否到到最后一层
    //递归法：分两种情况讨论
    public static int nodeNum(SuccessorNode.Node head){
        return 0;
    }
    public static void main(String[] args){
        System.out.print(4&3);
    }

    /**
     *
     * @param node:当前节点
     * @param level：当前节点在那一层
     * @param h：整个树的深度
     * @return：以node为头的整棵树的节点个数
     */
    public static int bs(SuccessorNode.Node node,int level,int h){
        if(level==h){
            return 1;
        }
        return 0;

    }
}
