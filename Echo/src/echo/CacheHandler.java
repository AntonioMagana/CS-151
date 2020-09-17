package echo;

import java.net.Socket;

public class CacheHandler extends ProxyHandler {
    private static Cache cache = new Cache();

    public CacheHandler(Socket s) { super(s); }
    public CacheHandler() { super(); }

    protected String response(String msg) throws Exception {
        String result = "";
        if(result ==  null) {
            result = super.response(msg);
            cache.update(msg, result);
        }
        return result;
    }
}
