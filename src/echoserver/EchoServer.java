package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
	public static final int portNumber = 6013;

	public static void main(String[] args){
		try{
			System.out.println("About to enter server loop");
			run_server();
		}
		catch (IOException e) {
		System.err.println(e);
		}
	}

	static void run_server() throws IOException{
	//Start listening on the specified port
	ServerSocket sock = new ServerSocket(portNumber);
	
	boolean cont = true;

	while (cont) {
		System.out.println("Waiting for connection");
		Socket client = sock.accept();
		System.out.println("Connection established");
		InputStream input = client.getInputStream();
		OutputStream output = client.getOutputStream();

		//we now have a connected client
		//Read its first byte
		Integer input_byte = input.read();
		System.out.println(input_byte);
		//if the present byte isn't null, continue reading and writing
		while (input_byte != -1){
			output.write(input_byte);
			output.flush();
	 		input_byte = input.read();
			System.out.println(input_byte);
		}
		System.out.println("Connection closed");
	}
}
}
