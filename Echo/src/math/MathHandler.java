package math;

import echo.RequestHandler;

import java.net.*;
import java.util.Random;

public class MathHandler extends RequestHandler {

    private String[] parsed;
    private String operator;
    private double total;

    private static synchronized double add(String[] cmd) {
        double temp = Double.parseDouble(cmd[1]);
        for(int i  = 2; i < cmd.length; i++){
            temp  = temp + Double.parseDouble(cmd[i]);
        }
        return temp;
    }

    private static synchronized double sub(String[] cmd) {
        double temp = Double.parseDouble(cmd[1]);
        for(int i  = 2; i < cmd.length; i++){
            temp  = temp - Double.parseDouble(cmd[i]);
        }
        return temp;
    }

    private static synchronized double mul(String[] cmd) {
        double temp = Double.parseDouble(cmd[1]);
        for(int i  = 2; i < cmd.length; i++){
            temp  = temp * Double.parseDouble(cmd[i]);
        }
        return temp;
    }

    private static synchronized double div(String[] cmd) {
        double temp = Double.parseDouble(cmd[1]);
        for(int i  = 2; i < cmd.length; i++){
            temp  = temp / Double.parseDouble(cmd[i]);
        }
        return temp;
    }

    public MathHandler(Socket sock) {
        super(sock);
        init();
    }

    public MathHandler() {
        super();
        init();
    }

    private void init() {
        total = 0;
    }

    protected String response(String request) throws Exception {
        parsed = request.split(" ");
        operator  = parsed[0];
        String result = "";
        if (operator.equalsIgnoreCase("new")) {
            init();
            result = "Enter your Command";
        } else if (operator.equalsIgnoreCase("help")) {
            result = "operators: new, add, mul, sub, div, and help";
        }
        else if (operator.equalsIgnoreCase("add")) {
            total = add(parsed);
            result = "Total = " + total + "";
        }
        else if (operator.equalsIgnoreCase("sub")) {
            total = sub(parsed);
            result = "Total = " + total + "";
        }
        else if (operator.equalsIgnoreCase("mul")) {
            total = mul(parsed);
            result = "Total = " + total + "";
        }
        else if (operator.equalsIgnoreCase("div")) {
            total = div(parsed);
            result = "Total = " + total + "";
        }
        else {
            result = "Unrecognized command: " + request;
        }
        return result;
    }

}