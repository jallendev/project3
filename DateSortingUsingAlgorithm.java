import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DateSortingUsingAlgorithm {
	//Build HashMap for each ordering. LinkedHashMaps are used for sorted data sets to preserve insertion order.
	private HashMap<LocalDate, Integer> sortingDates = new HashMap<LocalDate, Integer>();
	private LinkedHashMap<LocalDate, Integer> ascendingOrder = new LinkedHashMap<LocalDate, Integer>();
	private LinkedHashMap<LocalDate, Integer> descendingOrder = new LinkedHashMap<LocalDate, Integer>();
	
	//A formatter to make sure dates are printed properly
	DateTimeFormatter withHyphensFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	//Sorts the data sets using helper methods and stores the data in HashMaps above.
	public DateSortingUsingAlgorithm() {
		//read the file
		readSortingDatesFile();
		//sort with the keyset
		ArrayList<LocalDate> sortedKeys = new ArrayList<LocalDate>(sortingDates.keySet());
		//bubble sort the keys
		sortedKeys = bubbleSort(sortedKeys);
		//place in the ascending order LinkedHashMap
		for (LocalDate date : sortedKeys) {
			ascendingOrder.put(date, sortingDates.get(date));
		}
		//reverse
		sortedKeys = reverse(sortedKeys);
		//place in the descending order LinkedHashMap
		for (LocalDate date : sortedKeys) {
			descendingOrder.put(date, sortingDates.get(date));
		}
	}
	
	//print the created and formatted LinkedHashMap
	public void dateHashMapSortedDescending() {
		for (LocalDate date : descendingOrder.keySet()) {
			System.out.println(withHyphensFormatter.format(date));
		}
	}

	//print the created and formatted LinkedHashMap
	public void dateHashMapSorted() {
		for (LocalDate date : ascendingOrder.keySet()) {
			System.out.println(withHyphensFormatter.format(date));
		}
	}
	
	//Simply reads the given file in order to acquire the data.
	private void readSortingDatesFile() {
		final String FILENAME = "SortingDates.txt";
		final int THIS_NUMBER_DOES_NOT_MATTER_BUT_I_DIDNT_WANT_TO_MAKE_IT_MAGIC = 0;
		// catch IOException if one occurs and print error message
		try {
			// Declare necessary variables and objects
			BufferedReader fileReader = new BufferedReader(new FileReader(FILENAME));
			String line = new String("");

			// read the file
			line = fileReader.readLine();
			while (line != null) {
				//Both the line and split parts are trimmed to clear unneccessary whitespace
				line = line.trim();
				String[] dateBits = line.split("\\-");
				for (int index = 0; index < dateBits.length; ++index)
					dateBits[index] = dateBits[index].trim();
				
				sortingDates.put(LocalDate.of(Integer.parseInt(dateBits[0]), Integer.parseInt(dateBits[1]), Integer.parseInt(dateBits[2])), 
						THIS_NUMBER_DOES_NOT_MATTER_BUT_I_DIDNT_WANT_TO_MAKE_IT_MAGIC);
				
				line = fileReader.readLine();
			}
			fileReader.close();
		}
		// An IOException will most likely occur in the case of the FILENAME variable
		// being initialized with an incorrect path.
		catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Reverses the given ArrayList without using Collections.
	private ArrayList<LocalDate> reverse(ArrayList<LocalDate> dates) 
    { 
        ArrayList<LocalDate> retDates = new ArrayList<LocalDate>(); 
        for (int i = dates.size() - 1; i >= 0; i--) { 
        	retDates.add(dates.get(i)); 
        }
        return retDates; 
    }
	
	//A basic implementation of the standard bubble sort algorithm. Bubble sort has a worst case and average complexity of O(n^2).
	private ArrayList<LocalDate> bubbleSort(ArrayList<LocalDate> dates){
		LocalDate swap = LocalDate.now();
		
		for (int i = 0; i < dates.size(); i++) {
	        for (int j = 1; j < (dates.size() - i); j++) {
	            if (dates.get(j - 1).compareTo(dates.get(j)) > 0) {
	                swap = dates.get(j - 1);
	                dates.set(j - 1, dates.get(j));
	                dates.set(j, swap);
	            }
	        }
	    }
		
		return dates;
	}
}
