package com.lm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOClient {
	private static int flag = 0;
	private static int BLOCK = 4096;	
	private final static int port = 9000;
	private static ByteBuffer receivebuffer = ByteBuffer.allocate(BLOCK);
	private static ByteBuffer sendbuffer = ByteBuffer.allocate(BLOCK);
	
	private static SocketChannel socketChannel = null;
	private static Selector selector = null;
	
	private final static InetSocketAddress SERVER_ADDRESS
		= new InetSocketAddress("localhost",port);
	
	public void getConnection()throws IOException
	{
		socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		selector = Selector.open();
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		socketChannel.connect(SERVER_ADDRESS);
	}
	
	public static void main(String[] args) {
		NIOClient client = new NIOClient();
		try{
			client.getConnection();
			client.sendMsg();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public void sendMsg()throws IOException{
		 Set<SelectionKey> selectionKeys;  
	     Iterator<SelectionKey> iterator;  
	     SelectionKey selectionKey;  
	     SocketChannel client;  
	     String receiveText;  
	     String sendText;  
	     int count=0;  
	     
	     while(true){
	    	 selector.select();
	    	 selectionKeys = selector.selectedKeys();
	    	 iterator = selectionKeys.iterator();
	    	 while(iterator.hasNext())
	    	 {
	    		 selectionKey = iterator.next();
	    		 if(selectionKey.isConnectable()){
	    			 System.out.println("client connection...");
	    			 client = (SocketChannel) selectionKey.channel();
	    			 // 判断此通道上是否正在进行连接操作。  
	                 // 完成套接字通道的连接过程。  
	    			 if(client.isConnectionPending()){
	    				 client.finishConnect();
	    				 System.out.println("连接成功!");
	    				 sendbuffer.clear();
	    				 sendbuffer.put("hello server ".getBytes());
	    				 sendbuffer.flip();
	    				 client.write(sendbuffer);
	    			 }
	    			 client.register(selector, SelectionKey.OP_READ);
	    		 }else if(selectionKey.isReadable()){
	    			 client = (SocketChannel) selectionKey.channel();
	    			 receivebuffer.clear();
	    			 try{
	    				 count = client.read(receivebuffer);
		    			 if(count > 0){
		    				 receiveText = new String(receivebuffer.array(),0,count);
		    				 System.out.println(" 客户端收到的信息: " + receiveText);
		    				 client.register(selector, SelectionKey.OP_WRITE);
		    			 } 
	    			 }catch(IOException e){
	    				 e.printStackTrace();
	    				 selectionKey.cancel();
	    				 client.socket().close();
	    				 client.close();
	    				 return;
	    			 }
	    			
	    		 }else if(selectionKey.isWritable()){
	    			 sendbuffer.clear();
	    			 client = (SocketChannel) selectionKey.channel();
	    			 sendText = "客户端给服务端发消息 " + (flag++);
	    			 sendbuffer.flip();
	    			 client.write(sendbuffer);
	    			 System.out.println("客户端给服务端发消息  " + sendText);
	    			 client.register(selector, SelectionKey.OP_READ);
	    		 }
	    	 }
	    	 selectionKeys.clear();
	     }
	}
}
