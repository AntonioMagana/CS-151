package echo;

import java.net.Socket;

public class SecurityHandler extends ProxyHandler {
    private static UserTable users = new UserTable();
    private Boolean loggedIn = false;

    public SecurityHandler(Socket s) { super(s); }
    public SecurityHandler() { super(); }

    protected String response(String msg) throws Exception {
        String[] parsed = msg.split(" ");
        String cmd = parsed[0];
        String result = "";
        if(!loggedIn){
            if (cmd.equalsIgnoreCase("new")){
                users.newUser(parsed[1], parsed[2]);
                result = "New User Added";
            } else if (cmd.equalsIgnoreCase("login")) {
                if(users.getPassword(parsed[1]).equals(parsed[2])){
                    loggedIn = true;
                    result = "Logged In";
                }
                else{
                    result = "Not Logged In";
                }
            } else {
                result = "Must Login to issue command: " + msg;
            }
        }
        else {
            return super.response(msg);
        }
        return result;
    }
}
