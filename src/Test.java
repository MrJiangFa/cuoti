import java.util.Collection;
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
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    private static void inOrder(Node head){
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.value);
        inOrder(head.right);
    }
    static Node solution(String input) {
        if(input==null||input.trim().length()==0){
            return null;
        }
        int start = input.indexOf("(");
        int end = input.lastIndexOf(")");
        if(start<0){
            return new Node(Integer.valueOf(input));
        }
        Node head = new Node(Integer.valueOf(input.substring(0,start)));
        int tmp = input.indexOf(",");
        if(input.charAt(start+1)==','){
            head.left = null;
        }else{
            int indexOfMid = 0;
            int count = Integer.MAX_VALUE;
            for(int i = start+1;i<input.length();i++){
                if(input.charAt(i)==','&&count==Integer.MAX_VALUE){
                    head.left = new Node(Integer.valueOf(input.substring(start+1,i)));
                    indexOfMid = i;
                    break;
                }
                if(input.charAt(i)=='('&&count==Integer.MAX_VALUE){
                    count=1;
                }else if(input.charAt(i)=='('&&count!=Integer.MAX_VALUE){
                    count++;
                }else if(input.charAt(i)==')'){
                    count--;
                    if(count==0){
                        indexOfMid=i+1;
                        tmp = indexOfMid;
                        break;
                    }
                }
            }
            head.left = solution(input.substring(start+1,indexOfMid));
        }
        if(input.charAt(end-1)==','){
            head.right = null;
        }else{
            head.right = solution(input.substring(tmp+1,end));
        }
        return head;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        Node head = solution(_input);
        inOrder(head);
    }
}
