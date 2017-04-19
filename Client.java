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
