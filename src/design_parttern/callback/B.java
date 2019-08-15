package design_parttern.callback;

public class B {
    /**
     * 此方法相当于一个回调过程
     *
     * @param impl
     */
    public void call(CallBackImpl impl) {
        /**
         * 干自己的事情
         */
        //直到自己干完了自己的事情，或者某件事情发生，中断自身干的事，此时调用回调函数，进行统治
        if ("状态" == "ok") {
            impl.solve();
        }
    }
}
