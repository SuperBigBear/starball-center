package com.cn.starball.socket;

import com.sun.istack.internal.NotNull;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketApplication {
    public static void main(String[] args) throws Exception {
        //Listen port 55533
        int port = 55533;
        ServerSocket server = new ServerSocket(port);
        //waiting for connection coming
        System.out.println("server is waiting for connection coming...");
        Socket socket = server.accept();

        InputStream inputStream = socket.getInputStream();
        try {

            byte[] bytes = new byte[1024];
            int len;

            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len, "UTF-8"));
            }
            System.out.println("get message from client: " + sb);

            OutputStream outputStream=socket.getOutputStream();
            outputStream.write("Hello client,I get the message.".getBytes("UTF-8"));

        } catch (Exception ex) {
            throw ex;
        } finally {
            inputStream.close();
            socket.close();
            server.close();
        }


    }

}
