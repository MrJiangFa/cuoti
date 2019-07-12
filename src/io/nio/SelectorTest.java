package io.nio;

import com.sun.corba.se.spi.activation.LocatorPackage.ServerLocation;
import sun.nio.ch.DirectBuffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorTest {
    /**
     * 一个selector对应一个线程；
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);//开启非阻塞模式
        ssc.socket().bind(new InetSocketAddress(8080));
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT | SelectionKey.OP_WRITE);
        selector.select();//以阻塞方式等待注册的io channel的变化，或者超时返回0
        while (true) {
            Set<SelectionKey> selectedKeys = selector.selectedKeys();//可进行selection操作的所有channel对应的key
            Iterator it = selectedKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();//SelectionKey表示在channel在selector中对应的key
                //判断是否有连接事件发生
                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                    ServerSocketChannel ssc2 = (ServerSocketChannel)key.channel();
                    SocketChannel sc = ssc2.accept();//接收与此通道的socket连接
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ);//sokcetchannel监听读事件
                    it.remove();//删除对应的next方法取出的元素；
                }
            }
        }

    }
}
