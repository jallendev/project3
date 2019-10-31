import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MesoLexicographical extends MesoSortedAbstract
{
	//The stations to include in the lexicographical sort
	HashMap<String, Integer> asciiVal = new HashMap<String, Integer>();
	
	//assign the stations and start the sort
	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		this.asciiVal = asciiVal;
		sortedMap(asciiVal);
	}

	//returns the sorted map
	@Override
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		LinkedHashMap<String, Integer> sortedVals = new LinkedHashMap<String, Integer>();
		
		//sort by an ArrayList of keys
		ArrayList<String> sortedKeys = new ArrayList<String>(asciiVal.keySet());
		Collections.sort(sortedKeys);
		
		for (String asciiKey : sortedKeys) {
			sortedVals.put(asciiKey, asciiVal.get(asciiKey));
			System.out.println(asciiKey);
		}
		
		return sortedVals;
	}
}