package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;

public class DatagramChannelTest {
    public static void main(String[] args) {
        try {
            DatagramChannel channel = DatagramChannel.open();
            channel.bind(new InetSocketAddress(111));
            channel.connect(new InetSocketAddress(2123));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
