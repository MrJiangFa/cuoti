package io.nio;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args){
        Path file = Paths.get("e:\\","dd");
        System.out.println(file.getNameCount());
        System.out.println(file.toAbsolutePath());
        System.out.println(file.getName(0));
        URI u = URI.create("e:\\dd");
        System.out.println(Paths.get(u).toAbsolutePath());
    }
}
