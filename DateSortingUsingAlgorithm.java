import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class DateSortingUsingAlgorithm {

	private HashMap<LocalDate, Integer> sortingDates = new HashMap<LocalDate, Integer>();
	
	public DateSortingUsingAlgorithm() {
		readSortingDatesFile();
	}
	
	public void dateHashMapSortedDescending() {
		// TODO Auto-generated method stub
		
	}

	public void dateHashMapSorted() {
		// TODO Auto-generated method stub
		
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
				line.trim();
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
}
