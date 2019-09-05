package design_parttern.listener;

public class Robot {

    //此处为一个具象化的行为，可以不用事件对象，如果是图形界面，点击按钮即初始化一个事件对象
    public void working() {
    }

    public static void main(String[] args) {
        new Robot().working();
    }
}
