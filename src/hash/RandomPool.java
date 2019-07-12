package hash;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class RandomPool<K> {
    public HashMap<K, Integer> keyIndexMap = new HashMap<>();
    public HashMap<Integer, K> indexKeyMap = new HashMap<>();
    public int size;

    public RandomPool() {
        this.keyIndexMap = new HashMap<>();
        this.indexKeyMap = new HashMap<>();
        size = 0;//索引为0--size-1
    }

    public void insert(K k) {
        if (!this.keyIndexMap.containsKey(k)) {
            keyIndexMap.put(k, this.size);
            indexKeyMap.put(this.size++, k);
        }
    }

    public K getRandom() {
        if (this.size == 0) {
            return null;
        }
        int randomIndex = (int) (Math.random() * size);//0-size-1
        return this.indexKeyMap.get(randomIndex);
    }

    //删除一个记录时，将最后一个记录添加到被删除的记录中
    public void delet(K key) {
        int deleteIndex = keyIndexMap.get(key);
        int lastIndex = --this.size;
        K lastKey = indexKeyMap.get(lastIndex);
        this.keyIndexMap.put(lastKey, deleteIndex);
        this.indexKeyMap.put(deleteIndex, lastKey);
        this.keyIndexMap.remove(key);
        this.indexKeyMap.remove(lastIndex);
    }


    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1", 1);
        System.out.println(hashMap.get("1"));
        System.out.println(hashMap.get("2"));
        hashMap.put("1", 3);
        System.out.println(hashMap.get("1"));
    }

}
