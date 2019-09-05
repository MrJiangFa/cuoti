
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        System.out.println(process(6));

    }

    private static int getResult(int n) {
        if (n == 2) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (i == 1 || i == n - 1) {
                res += getResult(n - 2);
                continue;
            }
            if (i % 2 == 0) {
                continue;
            }
            if (i % 2 != 0) {
                res += (getResult(i - 1) * getResult(n - i - 1));
            }
        }
        return res % 1000000007;
    }

    private static int process(int n) {
        if (n < 2 || n > 1000 || n % 2 != 0) {
            return 0;
        }
        int[] arr = new int[n + 1];
        for (int i = 2; i % 2 == 0 && i <= n; i += 2) {
            if (i == 2) {
                arr[2] = 1;
            } else {
                for (int k = 1; k < i; k++) {
                    if (k == 1 || k == i - 1) {
                        arr[i] += arr[i - 2];
                        continue;
                    }
                    if (k % 2 == 0) {
                        continue;
                    }
                    if (k % 2 != 0) {
                        arr[i] += (arr[k - 1] * arr[i - k - 1]);
                    }
                }
            }
        }
        return arr[n] % 1000000007;
    }

}
