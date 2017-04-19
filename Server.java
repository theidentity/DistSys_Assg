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
