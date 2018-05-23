package com.lm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
	private int flag = 0;
	private int BLOCK = 4096;
	private ByteBuffer sendbuffer = ByteBuffer.allocate(BLOCK);	
	private ByteBuffer receivebuffer = ByteBuffer.allocate(BLOCK);
	private Selector selector;
	
	public NIOServer(int port)throws IOException
	{
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);//服务器为非阻塞
		ServerSocket serverSocket = serverSocketChannel.socket();
		serverSocket.bind(new InetSocketAddress(port));
		// 通过open()方法找到Selector  
		selector = Selector.open();
		// 注册到selector，等待连接  
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
	    System.out.println("服务器端初始化完成，端口 " + port);	
	}
	
	//监听
	private void listen()throws IOException
	{
		while(true){
			// 选择一组键，并且相应的通道已经打开  
			selector.select();
			// 返回此选择器的已选择键集。  
			Set<SelectionKey> selectionkeys = selector.keys();
			Iterator<SelectionKey> iterator = selectionkeys.iterator();
			while(iterator.hasNext()){
				SelectionKey selectionKey = iterator.next();
				iterator.remove();
				//处理请求
				handleKey(selectionKey);
			}
		}
	}
	
	//处理请求
	private void handleKey(SelectionKey selectionKey)throws IOException
	{
		ServerSocketChannel server = null;
		SocketChannel client = null;
		String receiveText ;
		String sendText;
		int count = 0;
		 // 测试此键的通道是否已准备好接受新的套接字连接。  
		if(selectionKey.isAcceptable()){
			server = (ServerSocketChannel) selectionKey.channel();
			client = server.accept();
			client.configureBlocking(false);
			// 注册到selector，等待连接  
			client.register(selector, SelectionKey.OP_ACCEPT);
		}else if(selectionKey.isReadable()){
			client = (SocketChannel) selectionKey.channel();
			//将缓冲区清空以备下次读取  
			receivebuffer.clear();
			//读取服务器发送来的数据到缓冲区中  
			count = client.read(receivebuffer);
			if(count>0){
				receiveText = new String(receivebuffer.array(),0,count);
				System.out.println("服务器端收到信息 " + receiveText);
				client.register(selector, SelectionKey.OP_WRITE);
			}
		}else if(selectionKey.isWritable()){
			sendbuffer.clear();
			client = (SocketChannel) selectionKey.channel();
			sendText = "message from server--" + flag++;
			sendbuffer.put(sendText.getBytes());
			sendbuffer.flip();
			//输出到通道
			client.write(sendbuffer);
			System.out.println("服务端向客户端发送信息 : " + sendText);
			client.register(selector, SelectionKey.OP_READ);
		}
	}
	
	public static void main(String[] args) {
		int port = 9000;
		
		try {
			NIOServer server = new NIOServer(port);
			server.listen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
