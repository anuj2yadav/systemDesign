package MovieTheatre;
import java.util.*;

public class Movies{
    public String movieName;
    public int movieId;
    public int duration;
    public Map<Integer,Boolean> seatBooking=new HashMap<>();
    public Movies(int movieId,String movieName,int duration,int capacity)
    {
        this.movieName=movieName;
        this.movieId=movieId;
        this.duration=duration;
        this.numberSeats(capacity);
    }
    public void numberSeats(int numberOfSeats)
    {
        for(int i=0;i<numberOfSeats;i++)
        {
            seatBooking.put(i,false);
        }
    }

}