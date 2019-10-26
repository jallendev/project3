import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MesoLexicographical extends MesoSortedAbstract
{
	HashMap<String, Integer> asciiVal = new HashMap<String, Integer>();
	
	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		this.asciiVal = asciiVal;
		sortedMap(asciiVal);
	}

	@Override
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		LinkedHashMap<String, Integer> sortedVals = new LinkedHashMap<String, Integer>();
		
		ArrayList<String> sortedKeys = new ArrayList<String>(asciiVal.keySet());
		Collections.sort(sortedKeys);
		
		for (String asciiKey : sortedKeys) {
			sortedVals.put(asciiKey, asciiVal.get(asciiKey));
			System.out.println(asciiKey + " " + asciiVal.get(asciiKey));
		}
		
		return sortedVals;
	}
}