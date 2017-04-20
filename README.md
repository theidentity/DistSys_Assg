# Two way communication using socket programming in Java #

- Used to emulate a chat application in Java using localhost.
- Here a socket id of **9123** is explicitly given to both client and server.
- Both client and server programs run on same machine and can exchange message.

## Example ##

	Client : Hi
	Server : Hello There
	Client : Checking the sockets
	Server : All Clear

- The client and server can exchange messages one after another sequentially.
- First the server starts running and the client initiates the first message in this case.

## Server.java ##

- This is the Server Program which accepts connections from clients.
- For this, the *ServerSocket* listens to a specified port
- The *accept()* method waits for a client to connect
- Upon connection, a socket is created.
- The *PrintWriter* class helps to easily send these streams via socket.
- The socket's *getOutputStream()* and *getInputStream()* methods are used to exchange streams of data between server and client.

```java

import java.io.*;
import java.net.*;


public class Server
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket serversocket = new ServerSocket(9123);
			Socket s = serversocket.accept();

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader srvIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter srvOut = new PrintWriter(s.getOutputStream(),true);
			while(true)
			{
				String msgIn = srvIn.readLine();
				System.out.println("Client : "+msgIn);
				String msgOut = br.readLine();
				srvOut.println(msgOut);
			}
		}
		catch(Exception e)
		{
			System.out.println("Connection Lost");
		}
	}
}
```

## Client.java ## 

- The client contacts the port at which the server is listening.
- Upon successful connection, a socket is created.
- Data is read and written as streams using the socket.
- *Buffered Reader* is used to take user input
- *PrintWriter* is used to get and put the information to and from sockets.
- The *getOutputStream()* and *getInputStream()* methods of the socket handle the streams.

```java

import java.io.*;
import java.net.*;

public class Client
{
	public static void main(String[] args)
	{
		try
		{
			Socket s = new Socket("localhost",9123);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter cliOut = new PrintWriter(s.getOutputStream(),true);
			BufferedReader cliIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while(true)
			{
				String msgOut = br.readLine();
				cliOut.println(msgOut);
				String msgIn = cliIn.readLine();
				System.out.println("Server : "+msgIn);
			}
		}
		catch(Exception e)
		{
			System.out.println("Connection Lost");
		}
	}
}

```
