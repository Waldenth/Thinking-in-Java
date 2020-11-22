package socket.interaction.multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[]args){
        try{
            ServerSocket ss=new ServerSocket(8888);
            System.out.println("监听端口号:8888");
            Socket s=ss.accept();
            //启动发送消息线程
            new SendThread(s).start();
            //启动接受消息线程
            new ReceiveThread(s).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
