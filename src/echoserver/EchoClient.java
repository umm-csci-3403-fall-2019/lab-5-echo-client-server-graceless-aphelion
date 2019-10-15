package echoserver;

import java.net.*;
import java.io.*;

public class EchoClient {
	  public static final int portNumber = 6013;

  		public static void main(String[] args){
		String server;
    		  	// Use "127.0.0.1", i.e., localhost, if no server is specified.
    			if (args.length == 0) {
      				server = "127.0.0.1";
    			} else {
      				server = args[0];
    			}
		System.out.print(" Staring client with destination "+ server+":"+portNumber);	
		try{

			System.out.println("About to enter client loop");
			run_client(server, portNumber);
		}
		catch (IOException e) {
		System.err.println(e);
		}
	}

	void run_client(String server, int portNumber) throws IOException{
	
	//Start listening to the specified port
	Socket socket = new Socket(server,portNumber);

	//setup streams
	InputStream input = socket.getInputStream();
	OutputStream output = socket.getOutputStream();
	

	//start a while loop,
	bool cont = true;
	int present_byte;
	int result_byte;
	//get input from stdin, as ints
	present_byte = System.in.read();
	//if it's not -1, send them to the server
	if (present_byte != -1){
		OutputStream.write(present_byte);
		//read and dump the servers response
		result_byte = Inputstream.read();
		System.out.write(result_byte);
	} else {
		//break out of the loop
		cont = false;
		output.flush();
		input.close();
		output.close();
	}	
	//loop
	}
}
