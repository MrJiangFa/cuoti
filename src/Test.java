
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
//    public static void main(String[] args) {
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
//        System.out.println("a".substring(0,0).equals(""));
//    }


    //s的i位置及之前的所有字符串的处理步骤
//    public static List<String> process(String s, int i) {
//        List<String> list = new ArrayList<>();
//        if (i == 0) {
//            list.add((i) + " " + 0);
//            list.add(s.charAt(i) + " " + 0);
//            return list;
//        }
//        if (i == 1) {
//            if (s.charAt(i) == s.charAt(i - 1)) {
//                list.add(s.charAt(i) + " " + i);
//                return list;
//            } else {
//                list.add(s.charAt(i - 1) + " " + 0);
//                list.add(s.charAt(i - 1) + " " + 0);
//                list.add(s.charAt(i) + " " + 0);
//                list.add(s.charAt(i) + " " + 0);
//                return list;
//            }
//        }
//
//        return list;
//    }

    public static void main(String[] args) {
        get("12223");
    }

    public static void get(String s) {
        List<String> res = process(s, s.length() - 1);
        Object[] resArr = res.toArray();
        Arrays.sort(resArr);
        for (int i = 0; i < resArr.length; i++) {
            System.out.println(resArr[i]);
        }
    }

    public static void getResult() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<String> res = process(input, input.length() - 1);
        String[] resArr = (String[]) res.toArray();
        Arrays.sort(resArr);
        for (int i = 0; i < resArr.length; i++) {
            System.out.println(resArr[i]);
        }
    }

    public static List<String> process(String s, int i) {
        List<String> list = new ArrayList<>();
        if (i == 0) {
            list.add((char) (Integer.valueOf(s.charAt(i) + "") - 1 + 'A') + "");
            return list;
        }
        if (i == 1) {
            list.add((char) (Integer.valueOf(s.charAt(i - 1) + "") - 1 + 'A') + "" + (char) (Integer.valueOf(s.charAt(i) + "") - 1 + 'A'));
            if (Integer.valueOf(s.substring(0, i + 1)) <= 26) {
                list.add((char) (Integer.valueOf(s.substring(0, i + 1)) - 1 + 'A') + "");
            }
            return list;
        }
        List<String> before = process(s, i - 1);
        int sizeOfBefore = before.size();
        for (int count = 0; count < sizeOfBefore; count++) {
            String tmp = before.remove(0);
            list.add(tmp + (char) (Integer.valueOf(s.charAt(i) + "") - 1 + 'A'));
        }
        List<String> bbefore = process(s, i - 2);
        int sizeOfBB = bbefore.size();
        for (int count = 0; count < sizeOfBB; count++) {
            String tmp = bbefore.remove(0);
            if (Integer.valueOf(s.substring(i - 1, i + 1)) <= 26) {
                list.add(tmp + (char) (Integer.valueOf(s.substring(i - 1, i + 1)) - 1 + 'A'));
            }
        }
        return list;
    }


}
