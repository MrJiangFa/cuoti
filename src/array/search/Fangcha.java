package array.search;

public class Fangcha {
    public static void main(String[] args) {
//        System.out.println(fangcha(-1,0,1));
        System.out.println(getResutl(process(new int[]{10, -1, 0, 1, 3}, 4)));
    }

    private static String getResutl(double res) {
        int indexOfPoint = -1;
        String s = "" + res;
        if ((indexOfPoint = s.indexOf(".")) > 0) {
            if (s.substring(indexOfPoint + 1).length() > 2) {
                if (s.charAt(indexOfPoint + 3) >= '5') {
                    double r = Double.valueOf(s.substring(0, indexOfPoint + 3)) + 0.01;
                    return "" + r;
                }
                return s.substring(0, indexOfPoint + 3);
            } else if (s.substring(indexOfPoint + 1).length() == 2) {
                return s;
            } else {
                int len = s.length() - (indexOfPoint + 1);
                for (int i = 0; i < (2 - len); i++) {
                    s += "0";
                }
                return s;

            }
        } else {
            return s + ".00";
        }
    }

    private static double process(int[] arr, int i) {
        if (i == 2) {
            return fangcha(arr[0], arr[1], arr[2]);
        }
        double before = process(arr, i - 1);
        double current = minFangcha(arr, arr[i], i - 1);
        return Math.min(before, current);
    }


    private static double minFangcha(int[] arr, int num, int bind) {
        double res = Double.MAX_VALUE;
        for (int i = 0; i <= bind - 1; i++) {
            for (int j = i + 1; j <= bind; j++) {
                res = Math.min(res, (fangcha(arr[i], arr[j], num)));
            }
        }
        return res;
    }

    private static double fangcha(int a, int b, int c) {
        double average = (a + b + c) / (double) 3;
        double res = (Math.pow(a - average, 2) + Math.pow(b - average, 2) + Math.pow(c - average, 2)) / (double) 3;
        return res;
    }

}
