package greedy;

import java.util.Arrays;

public class JumpII {
    public static void main(String[] args){
        for(int i=0;i<10;){
            System.out.println(++i);
        }
    }
    public static void getResult(int[] arr){
        int reach = 0;//全局最远可达位置
        int last = 0;//上一步最远能到达的位置
        int step = 0;//i超过上一步最远位置时加1
        for(int i=0;i<=reach&i<=arr.length;i++){
            if(i>last){
                step++;
                last=reach;
            }
            reach=Math.max(reach,arr[i]+i);
        }
    }

}
