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

	private HashMap<LocalDate, Integer> sortingDates = new HashMap<LocalDate, Integer>();
	private LinkedHashMap<LocalDate, Integer> ascendingOrder = new LinkedHashMap<LocalDate, Integer>();
	private LinkedHashMap<LocalDate, Integer> descendingOrder = new LinkedHashMap<LocalDate, Integer>();
	
	DateTimeFormatter withHyphensFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public DateSortingUsingAlgorithm() {
		readSortingDatesFile();
		
		ArrayList<LocalDate> sortedKeys = new ArrayList<LocalDate>(sortingDates.keySet());
		
		sortedKeys = bubbleSort(sortedKeys);
		
		for (LocalDate date : sortedKeys) {
			ascendingOrder.put(date, sortingDates.get(date));
		}
		
		sortedKeys = reverse(sortedKeys);
		
		for (LocalDate date : sortedKeys) {
			descendingOrder.put(date, sortingDates.get(date));
		}
	}
	
	public void dateHashMapSortedDescending() {
		for (LocalDate date : descendingOrder.keySet()) {
			System.out.println(withHyphensFormatter.format(date));
		}
	}

	public void dateHashMapSorted() {
		for (LocalDate date : ascendingOrder.keySet()) {
			System.out.println(withHyphensFormatter.format(date));
		}
	}
	
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
				line = line.trim();
				String[] dateBits = line.split("\\-");
				
				sortingDates.put(LocalDate.of(Integer.parseInt(dateBits[0]), Integer.parseInt(dateBits[1]), Integer.parseInt(dateBits[2])), 
						THIS_NUMBER_DOES_NOT_MATTER_BUT_I_DIDNT_WANT_TO_MAKE_IT_MAGIC);
				
				line = fileReader.readLine();
			}
			fileReader.close();
		}
		// An IOException will most likely occur in the case of the FILENAME variable
		// being initialized with an incorrect path.
		catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private ArrayList<LocalDate> reverse(ArrayList<LocalDate> dates) 
    { 
        ArrayList<LocalDate> retDates = new ArrayList<LocalDate>(); 
        for (int i = dates.size() - 1; i >= 0; i--) { 
        	retDates.add(dates.get(i)); 
        }
        return retDates; 
    }
	
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
