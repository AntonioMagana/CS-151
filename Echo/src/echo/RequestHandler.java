package echo;

import java.net.Socket;

public class RequestHandler extends Correspondent implements Runnable {
    public RequestHandler(Socket s) { super(s); }
    public RequestHandler() { }

    // override in a subclass:
    protected String response(String msg) throws Exception {
        return "echo: " + msg;
    }
    public void run() {
        while(true) {
            try {
                // receive request
                String request = receive();
                if(request == null) continue;
                if(Server.DEBUG) System.out.println("received: " + request);
                if(request.equals("quit")) break;
                String response = response(request);
                if(Server.DEBUG) System.out.println("sending: " + response);
                //sendObject(msg);
                send(response);
                Thread.yield();
            } catch(Exception e) {
                send(e.getMessage());
                if(Server.DEBUG){
                    send(e.getMessage() + "... ending session");
                    break;
                }
            }
        }
        close();
        if(Server.DEBUG) System.out.println("request handler shutting down");
    }
}
