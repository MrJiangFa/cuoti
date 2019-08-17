package design_parttern.callback;

/**
 * 基本概念：
 * 1.店里留号码取货的样例
 * * 电话号码：回调函数
 *   将电话号码留给店员：登记回调函数
 *   店内来了货：触发回调关联事件
 *   店员给你打电话：调用回调函数
 *   到店内取货：响应回调函数
 */
public interface CallBack {
    void solve();
}
