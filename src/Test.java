import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

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
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (sc.hasNextLine()) {
            String tmp = sc.nextLine().trim();
            tmp.replaceAll("\\n|\\r", "");
            s += tmp;
        }


        Pattern pattern1 = Pattern.compile("\\{(\\\"[a-zA-Z]*\\\")\\}");
        Pattern pattern = Pattern.compile("\\{[\n\r\\s]*[a-zA-Z]+ \\}");

    }

    private static void test(String s) {

    }

}
