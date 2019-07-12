package classloader;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    System.out.println(getClass());
                    InputStream is = getClass().getResourceAsStream(fileName);//通过加载这个类的类加载器进行寻找对应的Class
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] bs = new byte[is.available()];
                    is.read(bs);
                    return defineClass(name, bs, 0, bs.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = loader.loadClass("classloader.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);
    }
    public void jdbc(){

    }
}
