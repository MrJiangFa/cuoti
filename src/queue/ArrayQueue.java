package queue;

public class ArrayQueue {
    private int[] arr;
    private int size;
    private int end;
    private int start;
    private static int DEFAULT_INITIAL_CAPACITY = 10;

    ArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    ArrayQueue(int initialCapacity) {
        arr = new int[initialCapacity];
    }

    public void push(int obj) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        arr[end] = obj;
        end = end == arr.length - 1 ? 0 : end + 1;
    }
    public int poll(int obj){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int tmp = start;
        start = start == arr.length-1?0:start+1;
        return arr[tmp];
    }

}
