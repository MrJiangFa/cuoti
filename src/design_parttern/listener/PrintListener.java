package design_parttern.listener;

public class PrintListener implements Listener {
    @Override
    public void process() {
        System.out.println("触发" + getClass().getCanonicalName() + "监听器，监听到机器人正在工作");
    }
}
