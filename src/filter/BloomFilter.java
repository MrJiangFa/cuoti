package filter;

public class BloomFilter {
    public static void main(String[] args) {
        int[] arr = new int[1000];//可以表示32000个bit位
        int index = 30000;//bit位索引
        int intIndex = index / 32;//判断该索引属于哪个整数
        int bitIndex = index % 32;
        arr[intIndex]=arr[intIndex]|(1<<bitIndex);//对应的bit位被置1

    }
}
