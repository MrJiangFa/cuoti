package stack;

import java.util.Queue;

/**
 * 两个队列实现栈结构，执行pop操作时，首先将一个队列中所有元素加入另一个队列中
 */
public class TwoQueueStack {
    private Queue<Integer> data;
    private Queue<Integer> help;

    public int pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        while (data.size() > 1) {
            this.help.offer(data.poll());
        }
        int res = data.poll();//此时data队列已经变成了一个空队列；
        swap();
        return res;
    }

    public void push(int num) {
        this.data.offer(num);
    }

    public void swap() {
        Queue<Integer> tmp = help;
        help = data;
        data = tmp;
    }

    public int peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (data.size() > 1) {
            this.help.offer(data.poll());
        }
        int res = this.data.poll();
        this.help.offer(res);
        swap();
        return res;
    }
}
