import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) {
        TextClient tc = new TextClient();
        EchoServer echoServer = new EchoServer();
/*
       if(args.length < 1) {
           try {
               echoServer.start(1666);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       else {
           try {
               tc.connect(args[0], 1666);
               tc.getUserInput();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
*/
        ExecutorService echse = Executors.newFixedThreadPool(2);
        ;

        echse.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    echoServer.start(1666);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        echse.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    tc.connect("127.0.0.1", 1666);
                    tc.getUserInput();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }






}

