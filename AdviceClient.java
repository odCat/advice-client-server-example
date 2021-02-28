import java.io.*;
import java.net.*;

public class AdviceClient
{
    private BufferedReader buffered;

    public void requestAndPrintAdvice()
    {
        connect2adviceServer();
        String advice = readFromServer();
        System.out.println(advice);
        closeConnection();
    }

    private void connect2adviceServer()
    {
        try
        {
            Socket socket = new Socket("127.0.0.1", 8000);
            InputStreamReader input = new InputStreamReader(socket.getInputStream());
            buffered = new BufferedReader(input);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private String readFromServer()
    {
        String result = "";
        try
        {
            result = buffered.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    private void closeConnection()
    {
        try
        {
            buffered.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        AdviceClient client = new AdviceClient();
        client.requestAndPrintAdvice();
    }
}
