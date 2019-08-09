
public class Test {
    public static void main(String[] args) {
        System.out.println(getResult("199999999999999.94894935689504869054068058", "1"));
        System.out.println(getResult("1", "199999999999999.94894935689504869054068058"));
//        System.out.println(resolution("199999999999999", "1.53485783495"));
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

    private static String getResult(String a, String b) {
        if (isValid(a) == -1 || isValid(b) == -1) {
            return null;
        } else if (isValid(a) == -2 && isValid(b) != -2) {
            int indexOfPointOfb = isValid(b);
            int indexOfLastNonZero = removeLastZeros(b, indexOfPointOfb);
            StringBuilder before = resolution(a, b);
            if (indexOfLastNonZero == -1) {
                return before.toString();
            }
            for (int i = indexOfPointOfb; i <= indexOfLastNonZero; i++) {
                before.append(b.charAt(i));
            }
            return before.toString();
        } else if (isValid(a) != -2 && isValid(b) == -2) {
            int indexOfPointOfa = isValid(a);
            int indexOfLastNonZero = removeLastZeros(a, indexOfPointOfa);
            StringBuilder before = resolution(b, a);
            if (indexOfLastNonZero == -1) {
                return before.toString();
            }
            for (int i = indexOfPointOfa; i <= indexOfLastNonZero; i++) {
                before.append(a.charAt(i));
            }
            return before.toString();
        } else {
            int indexOfPointa = isValid(a);
            int indexOfPointb = isValid(b);
            String right = a.substring(indexOfPointa);
            String left = a.substring(0, indexOfPointa);
            String leftRes = getResult(left, b);
            int lastNonZeroOfRight = removeLastZeros(right, 0);
            String rightOfb = b.substring(indexOfPointb);
            int lastNonZeroOfRightb = removeLastZeros(b, indexOfPointb);
            return null;
        }
    }

    /**
     * @param a : 正整数
     * @param b ：带小数点小数
     * @return
     */
    private static StringBuilder resolution(String a, String b) {
        int indexOfPointOfb = isValid(b);
        int len = Math.max(a.length(), indexOfPointOfb);
        int[] beforePoint1 = new int[len];
        int[] beforePoint2 = new int[len];
        for (int i = len - 1; i >= (len - a.length()); i--) {
            beforePoint1[i] = Integer.valueOf("" + a.charAt(i - len + a.length()));
        }
        for (int i = len - 1; i >= (len - indexOfPointOfb); i--) {
            beforePoint2[i] = Integer.valueOf("" + b.charAt(i - len + indexOfPointOfb));
        }
        for (int i = len - 1; i >= 0; i--) {
            int add = beforePoint1[i] + beforePoint2[i];
            if (i != 0) {
                if (add >= 10) {
                    beforePoint1[i - 1] = add / 10;
                    beforePoint1[i] = add % 10;
                } else {
                    beforePoint1[i] = add;
                }
            } else {
                beforePoint1[i] = add;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(beforePoint1[i]);
        }
        return sb;
    }


    private static int isValid(String s) {
        boolean isvalid = true;
        if (s == null || s.length() == 0) {
            isvalid = false;
        }
        int numOfPoint = 0;
        int indexOfPoint = -1;
        if (isvalid) {
            for (int i = 0; i < s.length(); i++) {
                if (numOfPoint > 1) {
                    isvalid = false;
                    indexOfPoint = -1;
                    break;
                }
                if (("" + s.charAt(i)).matches("\\.")) {
                    numOfPoint++;
                    indexOfPoint = i;
                    continue;
                }
                if (i == 0) {
                    if (!(("" + s.charAt(i)).matches("\\d|\\+"))) {
                        isvalid = false;
                        break;
                    }
                } else if (!("" + s.charAt(i)).matches("\\d")) {
                    isvalid = false;
                    break;
                }
            }
        }
        if (isvalid) {
            if (numOfPoint == 0) {
                return -2;
            } else if (numOfPoint == 1) {
                return indexOfPoint;
            }
        }
        return -1;
    }
}
