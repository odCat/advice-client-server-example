import java.io.*;
import java.net.*;

public class AdviceServer
{
    private String advice = "DRY: Don't repeat yourself";

    public void startServer()
    {
        try
        {
            ServerSocket server = new ServerSocket(8000);

            while (true)
            {
                Socket socket = server.accept();
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(advice);
                out.close();
                System.out.println(advice);
            }
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        AdviceServer adviceServer = new AdviceServer();
        adviceServer.startServer();
    }
}
