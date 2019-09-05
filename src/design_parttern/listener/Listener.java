package design_parttern.listener;

import java.util.EventListener;

public interface Listener<E extends Event> extends EventListener {
    //处理对应的事件
    void onApplicationEvent(E event);
}
