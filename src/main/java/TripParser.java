import java.text.DecimalFormat;
import java.util.Scanner;

public class TripParser 
{
	private static TripCalculator tripCalculator;
	
	// Get start + end from user and calculate distance + cost
	public static void main(String[] args) 
	{
		TripParser tripParser = new TripParser();
		tripCalculator = new TripCalculator(tripParser);
		
		Scanner scanObj = new Scanner(System.in);
		System.out.println("Starting location:");
		
		String start = scanObj.nextLine();
		
		System.out.println("End location:");
		
		String end = scanObj.nextLine();
		
		DecimalFormat df = new DecimalFormat("#.####");   
		
		System.out.println(start + " to " + end);
		
		System.out.println("Total Distance: " + df.format(tripCalculator.getDistance(start, end)) + "km");
		System.out.println("Total Cost: $" + df.format(tripCalculator.getCost(start, end)));
		
		scanObj.close();
	}
	
	public TripParser() 
	{
		
	}
}
