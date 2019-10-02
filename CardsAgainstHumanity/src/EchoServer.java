
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer{
    private Socket clientSocket;
    private ServerSocket serverSocket;

    private PrintWriter output;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();

        output = new PrintWriter(clientSocket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while(true)
        output.println(in.readLine());
    }
}
