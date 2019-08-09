package design_parttern.callback;

public class B {
    public void call(CallBackImpl impl){
        impl.solve();
    }
}
