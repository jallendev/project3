import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	//Utilize ZonedDateTime objects to preserve TimeZone placement
	private ZonedDateTime now = ZonedDateTime.now();
	private ZonedDateTime gmtTime = now.withZoneSameInstant(ZoneOffset.UTC);
	private ZonedDateTime bstTime = gmtTime.plusHours(6);
	private ZonedDateTime cstTime = gmtTime.minusHours(5);

	//Formatters for the various print styles required by main()
	private DateTimeFormatter nowDateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
	private DateTimeFormatter otherCityFormatter = DateTimeFormatter.ofPattern("HH:mm");
	private DateTimeFormatter differentZoneFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
	private DateTimeFormatter localTimeArrayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	
	//Store timeZones in a HashMap as required by the project pdf
	HashMap<String, String> timeZonesMap = new HashMap<String, String>();

	//Uses the base ZonedDateTime to acquire the current second on the server clock
	@Override
	int getValueOfSecond() {
		now = ZonedDateTime.now();
		System.out.println("The value of Second now: " + now.getSecond());
		return now.getSecond();
	}

	//Gets the current time from the now object. now is reinstantiated in case the server just slept for 5 seconds.
	@Override
	void dateTimeNow() {
		now = ZonedDateTime.now();
		System.out.println("Current Date/Time: " + nowDateFormatter.format(now));
	}

	//Uses the default Java system interface api to sleep the server for 5 seconds. If an InterruptedException is
	//caught, that just means the server woke up on the wrong side of the bed this morning.
	@Override
	void sleepForFiveSec() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			//Quit interrupting my sleep! Programming makes me tired!!
		}
	}

	//Format the ZonedDateTime objects instantiated above
	@Override
	void dateTimeOfOtherCity() {
		System.out.println("Time on Server: " + otherCityFormatter.format(now));
		System.out.println("GMT: " + otherCityFormatter.format(gmtTime));
		System.out.println("BST (90E): " + otherCityFormatter.format(bstTime));
		System.out.println("CST (90W): " + otherCityFormatter.format(cstTime));
	}

	//Store the ZonedDateTimes in a HashMap and print again with a new format.
	@Override
	void dateTimeDifferentZone() {
		timeZonesMap.put("GMT", differentZoneFormatter.format(gmtTime));
		timeZonesMap.put("BST", differentZoneFormatter.format(bstTime));
		timeZonesMap.put("CST", differentZoneFormatter.format(cstTime));
		
		System.out.println("GMT: " + timeZonesMap.get("GMT"));
		System.out.println("BST: " + timeZonesMap.get("BST"));
		System.out.println("CST: " + timeZonesMap.get("CST"));
	}

	//Add some arbitrary time zones, print, sort, format, and print again. See method comments for more details.
	@Override
	void timeZoneHashMap() {
		//Add the two arbitrary time zones.
		timeZonesMap.put("ZST", "11/05/2018 19:59");
		timeZonesMap.put("AST", "10/01/2020 19:59");
		
		//create a second map to store the values for the second print style.
		HashMap<String, String> secondMap = new HashMap<String, String>();
		//An array for the third print style.
		LocalDateTime[] localTimes = new LocalDateTime[timeZonesMap.size()];
		int index = 0;
		
		//Fill the new Data Structures
		for (String time : timeZonesMap.values()) {
			secondMap.put(time, "");
			LocalDateTime convertedTime = LocalDateTime.parse(time, differentZoneFormatter);
			localTimes[index] = convertedTime;
			++index;
		}
		
		//Sort the original map using an ArrayList of its keySet
		ArrayList<String> sortedKeys = new ArrayList<String>(timeZonesMap.keySet());
		Collections.sort(sortedKeys);
		
		//print the sorted map in the specified format.
		System.out.println("Print Style 1:");
		for (String key : sortedKeys) {
			System.out.println(key + " " + timeZonesMap.get(key));
		}
		
		//Same method as above, but with the second map
		ArrayList<String> sortedKeysSecondMap = new ArrayList<String>(secondMap.keySet());
		Collections.sort(sortedKeysSecondMap);
		
		//print the map.
		System.out.println("Print Style 3:");
		for (String key : sortedKeysSecondMap) {
			System.out.println(key);
		}
		
		//Now use the java api Arrays class to sort the array.
		Arrays.sort(localTimes);
		//Reverse it to get the order required by the project guidelines
		Collections.reverse(Arrays.asList(localTimes));
		
		//Create the final print style.
		System.out.println("Print Style 5: Final sorted Array:");
		for (LocalDateTime time : localTimes) {
			System.out.println(localTimeArrayFormatter.format(time));
		}
	}
   
}