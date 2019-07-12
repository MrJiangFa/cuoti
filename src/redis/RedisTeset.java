package redis;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RedisTeset {
    public static void main(String[] args)throws Exception{
        Socket socket = new Socket("localhost",6379);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        //向redis服务器写
        os.write("PING\r\n".getBytes());
        byte[] bytes = new byte[1024];
        if(is.read()=='+') {
            int len = is.read(bytes);
            System.out.println(new String(bytes));
        }
    }
    private void set(String key,String value)throws Exception {
        Socket socket = new Socket("10.128.0.122",6379);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        os.write(("unionfind " +key+" "+value).getBytes());
    }
    public void get(String key){

    }

}
