package mqlenv;
import java.net.*;
import java.io.*;
 
public class Server
{
    //initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private BufferedReader in       =  null;
 
    // constructor with port
    public Server(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");
 
            System.out.println("Waiting for a client ...");
 
            socket = server.accept();
            System.out.println("Client accepted");
 
            // takes input from the client socket
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("in created");
            System.out.println(in.ready());
            while(in.ready() != true) {
            	System.out.println(in.ready());
            }
            System.out.println(in.ready());
            String line = "";
 
            // reads message from client until "Over" is sent
            while (!line.equals("END CONNECTION"))
            {
            	
                try
                {
//                	in.reset();
                	System.out.println("loop try started");
                    line = in.readLine();
                    System.out.println("line read loop going");
                    System.out.println(line);
                    System.out.println("line printed in loop");
 
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
 
            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        
    }
 
    public static void main(String args[])
    {
        Server server = new Server(8888);
    }
}