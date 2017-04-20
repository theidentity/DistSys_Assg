Two way communication using socket programming in Java
-------------------------------------------------------
Maybe used to emulate a chat application in Java using localhost.
Here a socket id of 9123 is explicitly given to both client and server.
Both client and server programs run on same machine and can exchange message.

Example
--------
	Client : Hi
	Server : Hello There
	Client : Checking the sockets
	Server : All Clear

The client and server can exchange messages one after another sequentially.
First the server starts running and the client initiates the first message in this case.

Server.java
------------
This is the Server Program which accepts connections from clients.
For this, the ServerSocket listens to a specified port and the accept() method waits for a client to connect
Upon connection, a socket is created.
The PrintWriter class helps to easily send these streams via socket.
The socket's 
	getOutputStream() and 
	getInputStream() 
methods are used to exchange streams of data between server and client.

Client.java
------------
A connection to the server is attempted through the instantiation of the Socket class. It attempts to
contact the server at localhost through port 1234 - the same port where the server is listening. Once
the socket is at hand, it works exactly the same as the one obtained through the ServerSocket class
in Server.java. This time, the input stream is obtained and a BufferedReader is instantiated using it.
The data is read from this stream and displayed to the screen.