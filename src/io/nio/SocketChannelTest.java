package io.nio;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketChannelTest {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("https://www.baidu.com/", 80));
            ByteBuffer buf = ByteBuffer.allocate(48);
            socketChannel.read(buf);
            String newData = "New string to write to file..." + System.currentTimeMillis();
            ByteBuffer wrBuf = ByteBuffer.allocate(100);
            socketChannel.write(wrBuf.put(newData.getBytes()));
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //https://blog.csdn.net/csh159/article/details/7999893
    private void serverSocketChannelTest() {
        final int listenPort = 80;
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();//打开一个监听通道
            serverSocketChannel.bind(new InetSocketAddress(listenPort));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();//创建选择器
            //每当有一个channel注册到Selector中，selector的SelectionKey对象
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//只有非阻塞信道才可以注册监听器，并在注册过程中指出可以

        } catch (IOException e) {
        }
    }

    class TcpProtocalImpl implements TcpProtocal {
        private int bufferSize;

        TcpProtocalImpl(int bufferSize) {
            this.bufferSize = bufferSize;
        }

        //如果该通道是非阻塞模式，如果没有挂起的连接立刻返回null；否则，如果是阻塞模式，会阻塞直到一个连接的到来
        //或则错误的发生

        /**
         * 如果该通道是非阻塞模式，如果没有挂起的连接立刻返回null；否则，如果是阻塞模式，会阻塞直到一个连接的到来
         * 或则错误的发生
         *
         * @param key：此处的key应该表示的是ServerSocketChannel对应的SelectionKey
         * @throws IOException
         */
        @Override
        public void handleAccept(SelectionKey key) throws IOException {
            SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
            clientChannel.configureBlocking(false);
            //只需要注册一次
            clientChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }

        @Override
        public void handleRead(SelectionKey key) throws IOException {
            SocketChannel clientChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            buffer.clear();
            long bytesRead = clientChannel.read(buffer);
            if (bytesRead == -1) {
                clientChannel.close();
            } else {
                buffer.flip();//将缓冲区准备为数据读取状态

            }
        }

        @Override
        public void handleWrite(SelectionKey key) throws IOException {
            SocketChannel clientChannel = (SocketChannel) key.channel();
            clientChannel.configureBlocking(false);
            clientChannel.register(key.selector(), SelectionKey.OP_WRITE, ByteBuffer.allocate(bufferSize));
        }
    }

    interface TcpProtocal {
        //接受一个SocketChannel对应的处理
        void handleAccept(SelectionKey key) throws IOException;

        void handleRead(SelectionKey key) throws IOException;

        void handleWrite(SelectionKey key) throws IOException;
    }
}
