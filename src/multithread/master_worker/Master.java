package multithread.master_worker;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Master {
    //任务队
    Queue<Object> queue = new ConcurrentLinkedQueue<>();
    //线程队列
    Map<String,Thread> threadMap = new HashMap<>();
    //子任务处理结果集
    Map<String,Object> resultMap = new ConcurrentHashMap<>();

    public boolean isComplete(){
        for(Map.Entry<String,Thread> entry : threadMap.entrySet()){


        }
        return false;
    }


}
