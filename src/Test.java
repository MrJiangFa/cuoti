import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        Map<Integer, Integer> map = new HashMap<>();
//        Map<Integer, Integer> linkedMap = new LinkedHashMap<>();
//        for (int i = 0; i < 100; i++) {
//            map.put(i, i);
//            linkedMap.put(i, i);
//        }
//        map.forEach((k, v) -> System.out.println("map" + k + "=" + v));
//        linkedMap.forEach((k, v) -> System.out.println("linkedhashmap" + k + "=" + v));
//        map.remove(10);
//        linkedMap.remove(10);
//        map.put(10, 10);
//        linkedMap.put(10, 10);
//        System.out.println("=================================");
//        map.forEach((k, v) -> System.out.println("after insert map" + k + "=" + v));
//        linkedMap.forEach((k, v) -> System.out.println("after insert linkedhashmap" + k + "=" + v));
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        long userId = 56800004874L;
//        System.out.println(String.valueOf(userId).hashCode());
//        System.out.println((char)3000);
//        List<Integer> list = new ArrayList<>();
//        System.out.println(list.get(0));
//        String s = "aa{{company}}";
//        System.out.println(s.contains("^\\{\\{.+\\}\\}$"));
        System.out.println(get(3, 3, 4));
    }

    private String test1() {
        return null;
    }

    private void test() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        long denominator = 1;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            denominator *= nums[i];
        }

        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        double[] dp = new double[max];

        double[] rates = new double[max];
        rates[0] = 1.0 / denominator;
        for (int i = 1; i < max; i++) {
            rates[i] = (Math.pow(i + 1, n) / ((double) denominator)) - rates[i - 1];
        }

        double result = 0;
        for (int i = 0; i < max; i++) {
            result += ((i + 1) * rates[i]);
        }

        System.out.println(result);
    }

    private static int get(int n, int m, int k) {
        int max = m * n;
        int count = 0;
        for (int i = max; i >= 1; i--) {
            for (int j = Math.min(m, n); j >= 1; j--) {
                if (i % j == 0 && (i / j <= Math.min(m, n))) {
                    count++;
                    if (count == k) {
                        return i;
                    }
                }
            }
        }
        return 1;
    }
}
