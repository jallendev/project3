import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class DateTimeTwo {
	//Regular HashMap and LinkedHashMap to preserve order.
	HashMap<LocalDate, Integer> datesFile = new HashMap<LocalDate, Integer>();
	LinkedHashMap<LocalDate, Integer> originalOrderFile = new LinkedHashMap<LocalDate, Integer>();
	
	//Another formatter to print along project guidelines.
	private DateTimeFormatter hashMapFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	//Figures out which days are TENTH and EIGHTEENTH in the current month
	public void daysOfCurrentMonth() {
		//These three store current month data for use in the logic shown below.
		LocalDateTime currDay = LocalDateTime.now();
		DayOfWeek currDow = currDay.getDayOfWeek();
		int currDom = currDay.getDayOfMonth();
		//named constants, cause I really despise magic numbers
		final int TENTH_DAY = 10;
		final int EIGHTEENTH_DAY = 18;

		//These variables store the findings for the method to output
		long dayDifference = 0;
		DayOfWeek tenthDay = currDow;
		DayOfWeek eighteenthDay = currDow;

		//This logic find the difference between the current day and the TENTH day to determine how much
		//to increment or decrement the DayOfWeek
		if (currDom < TENTH_DAY) {
			dayDifference = TENTH_DAY - currDom;
			tenthDay = currDow.plus(dayDifference);
		} else if (currDom > TENTH_DAY) {
			dayDifference = currDom - TENTH_DAY;
			tenthDay = currDow.minus(dayDifference);
		}

		//Just like the one above, but for the EIGHTEENTH day this time.
		if (currDom < EIGHTEENTH_DAY) {
			dayDifference = EIGHTEENTH_DAY - currDom;
			eighteenthDay = currDow.plus(dayDifference);
		} else if (currDom > EIGHTEENTH_DAY) {
			dayDifference = currDom - EIGHTEENTH_DAY;
			eighteenthDay = currDow.minus(dayDifference);
		}

		//The user gets to see now, but they will never understand.
		System.out.println("The tenth day of this month is " + tenthDay + " and eighteenth is " + eighteenthDay);
	}

	//Similar to the method above, but now the user gets to choose the month and year.
	public void daysOfAnyMonth(int month, int year) {
		//It makes sense to start with 15 because no dayDifference calculation needs to be made to determine the fifteenth day.
		final int DAY_OF_MONTH = 15;
		//I love naming variables. It's great.
		final int THIS_NUMBER_DOES_NOT_MATTER_BUT_I_DIDNT_WANT_TO_MAKE_IT_MAGIC = 0;
		//Make LocalDateTime from given variables
		LocalDateTime givenMonth = LocalDateTime.of(year, month, DAY_OF_MONTH,
				THIS_NUMBER_DOES_NOT_MATTER_BUT_I_DIDNT_WANT_TO_MAKE_IT_MAGIC,
				THIS_NUMBER_DOES_NOT_MATTER_BUT_I_DIDNT_WANT_TO_MAKE_IT_MAGIC);
		//Calcumalate last day with fifteenth day and strategic use of TemporalAdjusters.
		//It's the only time programming can make you feel like a time traveler.
		final int LAST_DAY = givenMonth.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();

		//Daydifference time.
		DayOfWeek fifteenthDay = givenMonth.getDayOfWeek();
		long dayDifference = (long) LAST_DAY - (long) DAY_OF_MONTH;

		DayOfWeek lastDay = fifteenthDay.plus(dayDifference);

		//The users will never understand how many cups of java it took to bring this beautiful line to their ungrateful retinas.
		System.out.println("For the year (" + year + ") and month (" + month + ") , the fifteenth day is " + fifteenthDay
				+ " and the last day is " + lastDay);
	}

	//This scrap of code figures out whether the year is a leap year, and what the date difference is.
	public void compareYear() {
		//Some vars to hold calculation results
		String isLeapYear = "";
		Period dateDifference;
		LocalDate currDate = LocalDate.now();
		int years = 0, months = 0, days = 0;
		
		readDatesFile();
		
		for (LocalDate date : originalOrderFile.keySet()) {
			//Use periods to find the difference
			dateDifference = Period.between(date, currDate);
			years = dateDifference.getYears();
			months = dateDifference.getMonths();
			days = dateDifference.getDays();
			
			//It's better than writing two sysouts. That would just be ugly.
			if (date.isLeapYear())
				isLeapYear = "";
			else
				isLeapYear = "not ";
			
			System.out.println(date.getYear() + " is " + isLeapYear + "a leap year, and Difference: " + years + " years, " + 
					months + " months, and " + days + " days.");
		}
	}
	
	//Prints the HashMap before sorting
	public void dateHashMap() {
		for (LocalDate dateKey : originalOrderFile.keySet()) {
			System.out.println(hashMapFormatter.format(dateKey) + ":" + originalOrderFile.get(dateKey));
		}
	}
	
	//Sorts the HashMap and displays in the same manner
	public void dateHashMapSorted() {
		ArrayList<LocalDate> sortedKeys = new ArrayList<LocalDate>(datesFile.keySet());
		Collections.sort(sortedKeys);
		
		for (LocalDate dateKey : sortedKeys) {
			System.out.println(hashMapFormatter.format(dateKey) + ":" + datesFile.get(dateKey));
		}
	}

	//It does what it says
	private void readDatesFile() {
		final String FILENAME = "Dates.txt";
		// catch IOException if one occurs and print error message
		try {
			// Declare necessary variables and objects
			BufferedReader fileReader = new BufferedReader(new FileReader(FILENAME));
			String line = new String("");
			Integer iterator = 1;

			// read the file
			line = fileReader.readLine();
			while (line != null) {
				String[] dateBits = line.split("\\.");
				
				datesFile.put(LocalDate.of(Integer.parseInt(dateBits[2]), Integer.parseInt(dateBits[0]), Integer.parseInt(dateBits[1])), iterator);
				originalOrderFile.put(LocalDate.of(Integer.parseInt(dateBits[2]), Integer.parseInt(dateBits[0]), Integer.parseInt(dateBits[1])), iterator);
				
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
