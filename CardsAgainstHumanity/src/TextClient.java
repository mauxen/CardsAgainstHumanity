
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TextClient {

    private Socket socket;
    private PrintWriter output;
    private BufferedReader in;

    public void connect(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        output = new PrintWriter(socket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void getUserInput() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String input = scanner.nextLine();
            output.println(input);
            System.out.println(in.readLine());
        }
    }

}
