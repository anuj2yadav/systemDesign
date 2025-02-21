package MovieTheatre;
import java.util.*;
import java.util.stream.Collectors;

public class Booking {
	static Map<Integer,Theatre> booking;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		booking=new HashMap<>();
		Movies movie1=new Movies(12,"Anuj",120,40);
		Movies movie2=new Movies(15,"Anuj2",120,40);
		Movies movie3=new Movies(14,"Anuj3",120,40);
		Movies movie4=new Movies(13,"Anuj4",120,40);
		List<Movies> movies =new ArrayList<>();
		movies.add(movie1);
		Theatre theatre =new Theatre(1232,"Book My Show",movies);
		Theatre theatre2 =new Theatre(1233,"Zomato",movies);
		booking.put(1232, theatre);
		booking.put(1233, theatre2);
		
		booking(1232,12,4);
		booking(1232,12,10);
		displayBooking(theatre);
		
		
		

	}
	public static void displayBooking(Theatre theatre)
	{
		for(Movies movie:theatre.movies)
		{
			for(int key:movie.seatBooking.keySet())
			{
				if(movie.seatBooking.get(key))
				System.out.println("Theatre Id: "+theatre.theatreId+"Movie id: "+movie.movieId+
						" seatNumber: " +movie.seatBooking.get(key));
			}
		}
	}
	public static boolean booking(int theatreId,int movieId,int seatNumber)
	{
	   // validate if theatre exixt
		
		if(!booking.containsKey(theatreId))
		{
		    System.out.println("No theatre available");
		    return false;
		}
		else {
			Theatre theatre=booking.get(theatreId);
			List<Movies> movie=
			theatre.movies.stream().filter((x)->x.movieId==movieId).collect(Collectors.toList());
			if(movie.size()>=1 && !movie.get(0).seatBooking.get(seatNumber)) {
				movie.get(0).seatBooking.put(seatNumber,true);
				return true;
				
			}
			
		}
		return false;
	}
	

}
