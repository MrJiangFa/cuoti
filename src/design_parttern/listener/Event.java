package design_parttern.listener;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private List<Listener> list = new ArrayList<>();

    public void addListener(Listener listener) {
        list.add(listener);
    }

    public void onListener() {
        for (Listener listener : list) {
            listener.process();
        }
    }
}
