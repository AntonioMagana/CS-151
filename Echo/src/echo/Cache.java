package echo;

import java.util.HashMap;

public class Cache extends HashMap<String, String> {
    private HashMap<String, String> cMap = new HashMap<String, String>();

    synchronized String search(String request) {
        return cMap.get(request);
    }

    synchronized void update(String request, String response){
        cMap.put(request, response);
    }
}
