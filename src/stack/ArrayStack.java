package stack;

import java.util.Stack;

/**
 * pop,push,getMin的时间复杂度都为O(1)
 *
 * @param <E>
 */
public class ArrayStack<E> {

    private int index;
    private int[] arr;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    ArrayStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    ArrayStack(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new int[initialCapacity];
        index = 0;
    }

    public int pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("The array is empty");
        }
        return arr[--index];
    }

    public void push(int value) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The stack is full");
        }
        arr[index++] = value;
    }

    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum < this.getMin()) {
                this.stackMin.push(newNum);
            } else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackData.push(newNum);
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            return this.stackMin.peek();
    }
    }
}
