package tree;

import java.util.Scanner;

public class AVLTreeTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(s.equals("None")) {
            System.out.println("False");
            return;
        }
        String[] strings = s.split(",");
        int[] a = new int[strings.length];
        for(int i =0;i<a.length;i++){
            a[i]=Integer.parseInt(strings[i]);
        }
        if(isAVLTree(0,a)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }

    }
    private static boolean isAVLTree(int parent,int[] arr){
        int leftchild = 2*parent+1;
        int rightchild = 2*parent+2;
        if(leftchild>arr.length-1){
            return true;
        }else if(leftchild==arr.length){
            if(arr[leftchild]<arr[parent]) {
                return true;
            }else{
                return false;
            }
        }else{
            if(isAVLTree(leftchild,arr)&&isAVLTree(rightchild,arr)){
                if(arr[leftchild]<arr[parent]&&arr[parent]<arr[rightchild]){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
