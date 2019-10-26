import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class DateTimeTwo {

	HashMap<LocalDate, Integer> datesFile = new HashMap<LocalDate, Integer>();
	
	private DateTimeFormatter hashMapFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public void daysOfCurrentMonth() {
		LocalDateTime currDay = LocalDateTime.now();
		DayOfWeek currDow = currDay.getDayOfWeek();
		int currDom = currDay.getDayOfMonth();
		final int TENTH_DAY = 10;
		final int EIGHTEENTH_DAY = 18;

		long dayDifference = 0;
		DayOfWeek tenthDay = currDow;
		DayOfWeek eighteenthDay = currDow;

		if (currDom < TENTH_DAY) {
			dayDifference = TENTH_DAY - currDom;
			tenthDay = currDow.plus(dayDifference);
		} else if (currDom > TENTH_DAY) {
			dayDifference = currDom - TENTH_DAY;
			tenthDay = currDow.minus(dayDifference);
		}

		if (currDom < EIGHTEENTH_DAY) {
			dayDifference = EIGHTEENTH_DAY - currDom;
			eighteenthDay = currDow.plus(dayDifference);
		} else if (currDom > EIGHTEENTH_DAY) {
			dayDifference = currDom - EIGHTEENTH_DAY;
			eighteenthDay = currDow.minus(dayDifference);
		}

		System.out.println("The tenth day of this month is " + tenthDay + " and eighteenth is " + eighteenthDay);
	}

	public void daysOfAnyMonth(int month, int year) {
		final int DAY_OF_MONTH = 15;
		final int THIS_NUMBER_DOES_NOT_MATTER_BUT_I_DIDNT_WANT_TO_MAKE_IT_MAGIC = 0;
		LocalDateTime givenMonth = LocalDateTime.of(year, month, DAY_OF_MONTH,
				THIS_NUMBER_DOES_NOT_MATTER_BUT_I_DIDNT_WANT_TO_MAKE_IT_MAGIC,
				THIS_NUMBER_DOES_NOT_MATTER_BUT_I_DIDNT_WANT_TO_MAKE_IT_MAGIC);
		final int LAST_DAY = givenMonth.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();

		DayOfWeek fifteenthDay = givenMonth.getDayOfWeek();
		long dayDifference = (long) LAST_DAY - (long) DAY_OF_MONTH;

		DayOfWeek lastDay = fifteenthDay.plus(dayDifference);

		System.out.println("For the year (" + year + ") and month (" + month + ") , the fifteenth day is " + fifteenthDay
				+ " and the last day is " + lastDay);
	}

	public void compareYear() {
		String isLeapYear = "";
		Period dateDifference;
		LocalDate currDate = LocalDate.now();
		int years = 0, months = 0, days = 0;
		
		readDatesFile();
		
		for (LocalDate date : datesFile.keySet()) {
			dateDifference = Period.between(date, currDate);
			years = dateDifference.getYears();
			months = dateDifference.getMonths();
			days = dateDifference.getDays();
			
			if (date.isLeapYear())
				isLeapYear = "";
			else
				isLeapYear = "not ";
			
			System.out.println(date.getYear() + " is " + isLeapYear + "a leap year, and Difference: " + years + " years, " + 
					months + " months, and " + days + " days.");
		}
	}
	
	public void dateHashMap() {
		for (LocalDate dateKey : datesFile.keySet()) {
			System.out.println(hashMapFormatter.format(dateKey) + ":" + datesFile.get(dateKey));
		}
	}
	
	public void dateHashMapSorted() {
		ArrayList<LocalDate> sortedKeys = new ArrayList<LocalDate>(datesFile.keySet());
		Collections.sort(sortedKeys);
		
		for (LocalDate dateKey : sortedKeys) {
			System.out.println(hashMapFormatter.format(dateKey) + ":" + datesFile.get(dateKey));
		}
	}

	private void readDatesFile() {
		final String FILENAME = "src/Dates.txt";
		// catch IOException if one occurs and print error message
		try {
			// Declare necessary variables and objects
			BufferedReader fileReader = new BufferedReader(new FileReader(FILENAME));
			String line = new String("");
			Integer iterator = new Integer(1);

			// read the file
			line = fileReader.readLine();
			while (line != null) {
				String[] dateBits = line.split("\\.");
				
				datesFile.put(LocalDate.of(Integer.parseInt(dateBits[2]), Integer.parseInt(dateBits[0]), Integer.parseInt(dateBits[1])), iterator);
				
				++iterator;
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
