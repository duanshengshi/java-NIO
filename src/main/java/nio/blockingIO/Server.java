package nio.blockingIO;

import nio.blockingIO.SocketHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    private static final int PORT = 9527;

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //监听PORT 端口进来的 TCP 链接
        serverSocketChannel.socket().bind(new InetSocketAddress(PORT));

        while (true){
            //这里会阻塞，直到有一个请求的连接进来
            SocketChannel socketChannel = serverSocketChannel.accept();

            // 开启一个新的线程来处理这个请求，然后在 while 循环中继续监听PORT 端口
            SocketHandler handler = new SocketHandler(socketChannel);
            new Thread(handler).start();
        }

    }

}
