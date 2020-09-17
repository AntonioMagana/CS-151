package echo;

import java.net.Socket;
import java.util.ArrayList;

public class RatingHandler extends ProxyHandler {
    private double avgRate = 0;
    private boolean rated = false;
    private static ArrayList<Double> totalRatings = new ArrayList<Double>();

    public RatingHandler(Socket s) { super(s); }
    public RatingHandler() { super(); }

    synchronized private static void addRating(double val){
        totalRatings.add(val);
    }

    synchronized private double getAvgRate(){
        for(int i=0; i<totalRatings.size(); i++){
            avgRate = totalRatings.get(i) + avgRate;
        }
        avgRate = avgRate/totalRatings.size();
        return avgRate;
    }

    protected String response(String msg) throws Exception {
        String result = "";
        Double rating;
        String[] parsed = msg.split(" ");
        String cmd = parsed[0];

        if(cmd == null) {
            cmd = super.response(msg);
        }
        else if(cmd.equalsIgnoreCase("rate") && !rated){
            rating = Double.valueOf(parsed[1]);
            if(rating < 0 || rating > 5){
                result = "Please enter a valid rate";
            }
            else{
                addRating(rating);
                rated = true;
                result = "The average rating is: " + getAvgRate();
            }
        }
        else if(cmd.equalsIgnoreCase("rate") && rated){
            result = "You have already rated this session";
        }
        else {
            return super.response(msg);
        }
        return result;
    }
}
