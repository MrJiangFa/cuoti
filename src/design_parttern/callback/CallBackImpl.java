package design_parttern.callback;

/**
 * 实现回调函数接口，对于服务需求方
 * 1.登记回调
 * 2.响应回调
 */
public class CallBackImpl implements CallBack {
    private B b;
    public CallBackImpl(B b){
        this.b = b;
    }
    //响应回调函数
    @Override
    public void solve() {
        System.out.println("the problem is solved");
    }

    public void registerCallback(){
        System.out.println("ask someone to solve the problem");
        b.call(this);//将回调函数注册到调用方
        /**
         * 转头去干其他事
         */
    }
}
