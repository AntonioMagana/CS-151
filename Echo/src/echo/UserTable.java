package echo;

import java.util.HashMap;

public class UserTable extends HashMap<String, String> {
    private HashMap<String, String> table;

    public UserTable(){
        table = new HashMap<String, String>();
    }

    synchronized String getPassword(String user) {
        return table.get(user);
    }

    synchronized void newUser(String username, String password){
        table.put(username, password);
    }
}
