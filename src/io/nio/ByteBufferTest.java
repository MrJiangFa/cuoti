package io.nio;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 测试 HeapByteBuffer、
 */
public class ByteBufferTest {
    public static void main(String[] args) throws IOException {
        ByteBuffer jvmByteBuffer = ByteBuffer.allocate(10);
        ByteBuffer directByteBuffer = ByteBuffer.allocateDirect(10);
        Path path = Paths.get("E:/test.txt");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        File file = path.toFile();

        //FileChannel.MapMode.READ_ONLY
        //...................READ_WRITE
        //...................PRIVATE：缓存中修改，但是不写入文件中；
        MappedByteBuffer mappedByteBuffer = FileChannel.open(path).map(FileChannel.MapMode.READ_ONLY, 0, file.length());
    }
}
