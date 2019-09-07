package stringtest;

/**
 * 计算两个非负实数的计算结果，只能用字符串的形式
 */
public class SumOfTwoNonnegativeNumber {
    public static void main(String[] args) {
        System.out.println(isValid("-0.01"));
        System.out.println(isValid("0.01"));
        System.out.println(isValid("0.0.2"));
    }


//    private static String getResult(String a, String b) {
//        if (isValid(a) == -1 || isValid(b) == -1) {
//            return null;
//        } else if (isValid(a) == -2 && isValid(b) == -2) {
//            return resolutionAddOfTwoInt(a, b).toString();
//        } else if (isValid(a) == -2 && isValid(b) != -2) {
//            return resolution(a, b);
//        } else if (isValid(a) != -2 && isValid(b) == -2) {
//            return resolution(b, a);
//        } else {
//            int indexOfPointa = isValid(a);
//            int indexOfPointb = isValid(b);
//            int lastNonZeroOfa = removeLastZeros(a, indexOfPointa);
//            int lastNonZeroOfb = removeLastZeros(b, indexOfPointb);
//            if (lastNonZeroOfa == -1 && lastNonZeroOfb == -1) {
//                return resolutionAddOfTwoInt(a.substring(0, indexOfPointa), b.substring(0, indexOfPointb)).toString();
//            } else if (lastNonZeroOfa == -1 && lastNonZeroOfb != -1) {
//                return resolution(a.substring(0, indexOfPointa), b).toString();
//            } else if (lastNonZeroOfa != -1 && lastNonZeroOfb == -1) {
//                return resolution(b.substring(0, indexOfPointb), a).toString();
//            } else {
//                String beforPointa = a.substring(0, indexOfPointa);
//                String afterPointa = a.substring(indexOfPointa + 1, lastNonZeroOfa + 1);
//                String beforePointb = b.substring(0, indexOfPointb);
//                String afterPointb = b.substring(indexOfPointb + 1, lastNonZeroOfb + 1);
//                if (afterPointa.length() > afterPointb.length()) {
//                    int numOfZeros = 0;
//                    int len = afterPointa.length() - afterPointb.length();
//                    while (numOfZeros < len) {
//                        afterPointb += "0";
//                        numOfZeros++;
//                    }
//                } else {
//                    int numOfZeros = 0;
//                    int len = afterPointb.length() - afterPointa.length();
//                    while (numOfZeros < len) {
//                        afterPointa += "0";
//                        numOfZeros++;
//                    }
//                }
//                String afterPoint = resolutionAddOfTwoInt(afterPointa, afterPointb).toString();
//                String addToBefore = "";
//                String beforePoint = resolutionAddOfTwoInt(beforPointa, beforePointb).toString();
//                if (afterPoint.length() > afterPointa.length()) {
//                    addToBefore += afterPoint.charAt(0);
//                    beforePoint = resolutionAddOfTwoInt(beforePoint, addToBefore).toString();
//                    afterPoint = afterPoint.substring(1);
//                }
//                int indexOfNonZero = -1;
//                for (int i = 0; i < beforePoint.length(); i++) {
//                    if (beforePoint.charAt(i) != '0') {
//                        indexOfNonZero = i;
//                        break;
//                    }
//                }
//                indexOfNonZero = indexOfNonZero == -1 ? beforePoint.length() - 1 : indexOfNonZero;
//                int indexOfNonZeroOfAfter = -1;
//                for (int i = afterPoint.length() - 1; i >= 0; i--) {
//                    if (afterPoint.charAt(i) != '0') {
//                        indexOfNonZeroOfAfter = i;
//                    }
//                }
//                return indexOfNonZeroOfAfter != -1 ? beforePoint.substring(indexOfNonZero) + "." + afterPoint : beforePoint.substring(indexOfNonZero);
//            }
//        }
//    }

    /**
     * 计算两个非负整数的和，a和b分别表示一个整数
     *
     * @param a
     * @param b
     * @return
     */
    private static StringBuilder resolutionAddOfTwoInt(String a, String b) {
        int len = Math.max(a.length(), b.length());
        int[] na = new int[len];
        int[] nb = new int[len];
        for (int i = len - 1; i >= (len - a.length()); i--) {
            na[i] = Integer.valueOf("" + a.charAt(i - len + a.length()));
        }
        for (int i = len - 1; i >= (len - b.length()); i--) {
            nb[i] = Integer.valueOf("" + b.charAt(i - len + b.length()));
        }
        for (int i = len - 1; i >= 0; i--) {
            int add = na[i] + nb[i];
            if (i != 0) {
                if (add >= 10) {
                    na[i - 1] += add / 10;
                    na[i] = add % 10;
                } else {
                    na[i] = add;
                }
            } else {
                na[i] = add;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(na[i]);
        }
        return sb;
    }

    /**
     * @param a : 正整数
     * @param b ：带小数点小数
     * @return
     */
    private static String resolution(String a, String b) {
        int indexOfPointOfb = 0;
        if (isValid(b)) {
            indexOfPointOfb = b.indexOf(".");
        }
        String beforePointOfb = b.substring(0, indexOfPointOfb);
        StringBuilder sb = resolutionAddOfTwoInt(a, beforePointOfb);
        int indexOfLastNonZero = removeLastZeros(b, indexOfPointOfb);
        if (indexOfLastNonZero == -1) {
            return sb.toString();
        }
        for (int i = indexOfPointOfb; i <= indexOfLastNonZero; i++) {
            sb.append(b.charAt(i));
        }
        return sb.toString();
    }

    private static int removeLastZeros(String a, int indexOfPoint) {
        int len = a.length();
        int lastIndexOfNonZero = -1;
        for (int i = len - 1; i > indexOfPoint; i--) {
            if (a.charAt(i) != '0') {
                lastIndexOfNonZero = i;
                break;
            }
        }
        return lastIndexOfNonZero;
    }

    private static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        return s.matches("[\\-\\+\\d]\\d*\\.\\d*");
    }
}
