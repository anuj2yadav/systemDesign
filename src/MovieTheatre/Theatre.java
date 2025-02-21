package MovieTheatre;
import java.util.*;
import java.util.List;

public class Theatre{
    public List<Movies> movies;
    public int theatreId;
    public String theatreName;

    public  Theatre(int theatreId,String theatreName,List<Movies> movies)
    {
        this.theatreName=theatreName;
        this.theatreId=theatreId;
        this.movies=movies;
    }

}