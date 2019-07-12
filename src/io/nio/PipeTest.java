package io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PipeTest {
    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();
            Pipe.SinkChannel sinkChannel = pipe.sink();
            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer buf = ByteBuffer.allocate(44);
            Path path = Paths.get("E:\\dd\\jar\\create.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
