
import java.util.HashMap;
import java.util.Map;
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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Node> map = new HashMap<>();
        while (sc.hasNextLine()) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            if (!map.containsKey(from)) {
                Node node = new Node(from);
                node.map = new HashMap<>();
                node.map.put(to, weight);
                map.put(from, node);
            } else {
                Node node = map.get(from);
                node.map.put(to, weight);
            }
        }
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                arr[i] = 0;
            } else {

            }
        }
    }

    static class Node {
        public int val;
        public Map<Integer, Integer> map;

        public Node(int val) {
            this.val = val;
            map = new HashMap<>();
        }
    }


}
