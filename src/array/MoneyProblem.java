package array;

import java.util.HashMap;

/**
 * 给定一个数组，比如{5，10,25，1}，每个元素表示面值，且有无数张，目标钱数为aim=15，则问组成15元有多少种方法；
 * 基本思路：
 * 0张5元，剩下的钱可以构成多少个15元
 * 1张5元，剩下的钱可以构成多少个10元
 * 2张5元。。。
 * 。。。
 * 将所有结果累加，就是最终有多少种构成方法
 * 对于dp问题，可以观看进阶版7视频
 */
public class MoneyProblem {
    public static void main(String[] args){
        System.out.println(getResult(new int[]{1,2,3},4));
    }
    public static int getResult(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return processMap(arr, 0, aim);
    }

    /**
     * 例子目标：index=0 aim=1000
     * 目标可以分解为：
     * 0张200+(arr,1,aim)
     * 1张200+(arr,1,aim-200)
     * 2张200+(arr,1,aim-200*2)
     * ....
     * <p>
     * 存在重复计算
     * 比如200,100,50,10,5,2,1,需要构成的目标钱数为1000
     * 选择2张200,0张100，  或选择1张200,2张100，  都要计算一遍剩下的钱数累和为1000-400=600，存在大量重复计算
     *
     * @param arr:
     * @param index:表示可以自由使用index及其之后所有的钱
     * @param aim:目标钱数
     * @return 构成方法数
     * 无后效性：返回值和怎么到达当前状态无关，当前状态和如何到达该状态无关；
     * 到达index=2
     */
    public static int process(int[] arr, int index, int aim) {
        int res = 0;
        //来到最后了，剩下的钱数如果为0则对应方案有效，否则无效；
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            //numOfCoins表示货币的张数
            for (int numOfCoins = 0; numOfCoins * arr[index] <= aim; numOfCoins++) {
                res += process(arr, index + 1, aim - numOfCoins * arr[index]);
            }
        }
        return res;
    }

    public static HashMap<String, Integer> hashMap = new HashMap<>();

    public static int processMap(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int numOfCoins = 0; numOfCoins * arr[index] <= aim; numOfCoins++) {
                int nextAim = aim - numOfCoins * arr[index];
                String key = String.valueOf(index + 1) + "_" + nextAim;
                if (hashMap.containsKey(key)) {
                    res += hashMap.get(key);
                } else {
                    res += process(arr, index + 1, nextAim);
                }
            }
        }
        hashMap.put(String.valueOf(index) + "_" + aim, res);
        return res;
    }

    //动态规划
    //制作一张二维动态规划表，行为index 0-arr.length,列为0-aim，最终要求的就是0,aim处的值
    public static int coins4(int[] arr,int aim){
        if(arr==null||arr.length==0||aim<0){
            return 0;
        }
        int[][] dp = new int[arr.length+1][aim+1];
        return 0;
    }
}
