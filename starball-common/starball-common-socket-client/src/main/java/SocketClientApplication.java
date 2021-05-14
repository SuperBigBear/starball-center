import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClientApplication {
    public static void main(String args[]) throws Exception {
        String host = "127.0.0.1";
        int port = 55533;

        Socket socket=new Socket(host,port);
        OutputStream outputStream=socket.getOutputStream();
        String message="Hello World!";
        socket.getOutputStream().write(message.getBytes("UTF-8"));

        //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
        socket.shutdownOutput();

        InputStream inputStream=socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len;
        StringBuilder sb=new StringBuilder();
        while ((len=inputStream.read(bytes))!=-1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }

        System.out.println("Get message from server: "+sb);
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
