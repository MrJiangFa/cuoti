package design_parttern.listener;

import java.util.EventObject;

public abstract class Event extends EventObject {
    private String msg;
    private long timeStamp = System.currentTimeMillis();

    public Event(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public long getTimeStam() {
        return timeStamp;
    }

    public String getMsg() {
        return msg;
    }


}
