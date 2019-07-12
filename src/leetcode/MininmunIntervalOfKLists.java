package leetcode;

import java.util.*;

//leetcode632，对比leetcode23，同样可以采用优先队列做
//返回所有list中
public class MininmunIntervalOfKLists {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(4,10,15,24,26);
        List<Integer> list2 = Arrays.asList(0,9,12,20);
        List<Integer> list3 = Arrays.asList(5,18,22,30);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        System.out.println(Arrays.toString(smallestRange(list)));
    }

    static class Element {
        int val;
        int index;
        int num;

        Element(int num, int index, int val) {
            this.num = num;
            this.index = index;
            this.val = val;
        }
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        });
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            Element e = new Element(i, 0, nums.get(i).get(0));
            priorityQueue.offer(e);
            max = Math.max(max, nums.get(i).get(0));
        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (priorityQueue.size() == nums.size()) {
            Element cur = priorityQueue.poll();
            if (max - cur.val < range) {
                range = max - cur.val;
                start = cur.val;
                end = max;
            }
            if (cur.index + 1 < nums.get(cur.num).size()) {
                cur.index = cur.index + 1;
                cur.val = nums.get(cur.num).get(cur.index);
                priorityQueue.offer(cur);
                if (cur.val > max) {
                    max = cur.val;
                }
            }
        }
        return new int[]{start, end};
    }
}
