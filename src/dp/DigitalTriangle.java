package dp;

import java.util.Scanner;

public class DigitalTriangle {
    public static void main(String[] args){
        DigitalTriangle dt = new DigitalTriangle();
        int[][] arr= dt.initInput();
        long time1 = System.currentTimeMillis();
        System.out.println(dt.max(arr,0,0));
        long time2 = System.currentTimeMillis();
        System.out.println(dt.max2(arr,0,0));
        long time3 = System.currentTimeMillis();
        System.out.println(dt.max3(arr));
        long time4 = System.currentTimeMillis();
        System.out.println("递归法运行时间为:"+(time2-time1));
        System.out.println("以数组形式避免重复计算之后，运行时间为："+(time3-time2));
        System.out.println("采用递推法代理递归法："+(time4-time3));
    }
    private int[][] initInput(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] inputArr = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j = 0;j<=i;j++){
                inputArr[i][j]=sc.nextInt();
            }
        }
        return inputArr;
    }

    /**
     * https://blog.csdn.net/rock_joker/article/details/68928150
     * 利用递归法求取最大值，存在重复计算问题，时间复杂度为 2^n
     * @param arr：
     * @param row：
     * @param col：
     * @return
     */
    public int max(int[][] arr,int row,int col){
        if(row==arr.length-1){
            return arr[row][col];
        }else {
            int x = max(arr,row+1,col);
            int y = max(arr,row+1,col+1);
            return Math.max(x,y)+arr[row][col];
        }
    }
    //对于每一行中的数字，将其求出的最大值保存起来避免重复计算
    //递归总是需要大量的栈空间，容易造成栈溢出
    //如何将递归转化为递推
    public int max2(int[][] arr,int row,int col){
        int[][] maxMatrix = new int[arr.length][arr.length];
        if(maxMatrix[row][col]>0){
            return maxMatrix[row][col];
        }
        if(row==arr.length-1){
            maxMatrix[row][col]=arr[row][col];
        }else{
            int x = max2(arr,row+1,col);
            int y = max2(arr,row+1,col+1);
            maxMatrix[row][col]= Math.max(x,y)+arr[row][col];
        }
        return maxMatrix[row][col];
    }
    //避免使用递归
    public int max3(int[][] arr){
        int[][] max = new int[arr.length][arr.length];
        for(int i=arr.length-1;i>=0;i--){
            for(int j =0;j<=i;j++){
                if(i==arr.length-1){
                    max[i][j]=arr[i][j];
                }else{
                    max[i][j]=Math.max(max[i+1][j],max[i+1][j+1])+arr[i][j];
                }
            }
        }
        return max[0][0];
    }
    //继续优化——不使用二维数组int[][]存储最大值
    //使用以为数组代替二维数组



}
