package linked_list;

public class ReverseTest {

    private Node head;
    private static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    //方法1
    public void reverse(){
        if(head==null)
            return;
        //定义一个虚拟节点
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev  = dummy.next;
        Node pcur = prev.next;
        while(pcur!=null){
            prev.next = pcur.next;
            pcur.next = dummy.next;
            dummy.next = pcur;
            pcur=prev.next;//更新pcur，进入下一步循环
        }
        head = dummy.next;
    }
    //方法2，新建链表法

    public static void main(String[] args){
        ReverseTest rt  = new ReverseTest();
        rt.head = new Node(1);
        rt.head.next = new Node(2);
        rt.head.next.next  = new Node(3);
        rt.reverse();
        System.out.println(rt.head.value+" "+rt.head.next.value+" "+rt.head.next.next.value);
    }
}
