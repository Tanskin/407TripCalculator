import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TripCalculator 
{
	private static final String INTERCHANGES_LIST = "src/main/resources/interchanges.json";
	
	private static HashMap<Integer, Double> distances = new HashMap<>();
	private static HashMap<String, Integer> ids = new HashMap<>();

	public TripCalculator(TripParser tripParser) 
	{
		parseJSON();
	}
	
	public void parseJSON() 
	{
		// Read the JSON file and store it
		try (FileReader reader = new FileReader(INTERCHANGES_LIST))
		{
			JSONObject jParser = (JSONObject) new JSONParser().parse(reader);
			 
			JSONArray jArray = new JSONArray();
			jArray.add(jParser.get("locations"));
			
			Iterator<Map.Entry> jItr = ((Map) jArray.iterator().next()).entrySet().iterator();
			
			while(jItr.hasNext()) 
			{
				Map.Entry jKeyVal = jItr.next();

				JSONObject jInfo = (JSONObject) jKeyVal.getValue();

				String name = (String) jInfo.get("name");

				JSONArray array = (JSONArray) jInfo.get("routes");

				JSONObject jobj = (JSONObject) array.get(0);

				double dist = Double.parseDouble(jobj.get("distance").toString());
				
				int id = Integer.parseInt((String) jKeyVal.getKey());

				distances.put(id, dist);
				ids.put(name, id);
			}
		} 
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		} 
		catch(ParseException e) 
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Get the total distance from the start road to end
	 */
	public double getDistance(String start, String end) 
	{
		if(ids.get(start) == null || ids.get(end) == null)
		{
			System.out.println("Invalid location");
			return 0.0d;
		}
		
		int id1 = ids.get(start);
		int id2 = ids.get(end);
		
		// Swap in case start is ahead of end
		if(id1 > id2)
		{
			int temp = id1;
			id1 = id2;
			id2 = temp;
			
			String temp2 = start;
			start = end;
			end = temp2;
		}

		double total = 0.0d;
		 
		for(int i = id1; i < id2; i++)
		{
			if(distances.containsKey(i))
				total += distances.get(i);
		}

		return total;
	}
	
	/*
	 * Get the total cost from the start road to end
	 * We can calculate cost inside the getDistance method but keep separate for testing
	 */
	public double getCost(String start, String end) 
	{
		double total = getDistance(start, end);

		return total / 0.25;
	}
}
