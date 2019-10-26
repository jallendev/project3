import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private ZonedDateTime now = ZonedDateTime.now();
	private ZonedDateTime gmtTime = now.withZoneSameInstant(ZoneOffset.UTC);
	private ZonedDateTime bstTime = gmtTime.plusHours(6);
	private ZonedDateTime cstTime = gmtTime.minusHours(5);

	private DateTimeFormatter nowDateFormatter = DateTimeFormatter.ofPattern("MM/DD/yyyy hh:mm a");
	private DateTimeFormatter otherCityFormatter = DateTimeFormatter.ofPattern("hh:mm");
	private DateTimeFormatter differentZoneFormatter = DateTimeFormatter.ofPattern("MM/DD/yyyy hh:mm");
	private DateTimeFormatter localTimeArrayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-DDThh:mm");
	
	HashMap<String, String> timeZonesMap = new HashMap<String, String>();

	@Override
	int getValueOfSecond() {
		now = ZonedDateTime.now();
		System.out.println("The value of Second now: " + now.getSecond());
		return now.getSecond();
	}

	@Override
	void dateTimeNow() {
		now = ZonedDateTime.now();
		System.out.println("Current Date/Time: " + nowDateFormatter.format(now));
	}

	@Override
	void sleepForFiveSec() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			//Quit interrupting my sleep! Programming makes me tired!!
		}
	}

	@Override
	void dateTimeOfOtherCity() {
		System.out.println("Time on Server: " + otherCityFormatter.format(now));
		System.out.println("GMT: " + otherCityFormatter.format(gmtTime));
		System.out.println("BST (90E): " + otherCityFormatter.format(bstTime));
		System.out.println("CST (90W): " + otherCityFormatter.format(cstTime));
	}

	@Override
	void dateTimeDifferentZone() {
		timeZonesMap.put("GMT", differentZoneFormatter.format(gmtTime));
		timeZonesMap.put("BST", differentZoneFormatter.format(bstTime));
		timeZonesMap.put("CST", differentZoneFormatter.format(cstTime));
		
		System.out.println("GMT: " + timeZonesMap.get("GMT"));
		System.out.println("BST: " + timeZonesMap.get("BST"));
		System.out.println("CST: " + timeZonesMap.get("CST"));
	}

	@Override
	void timeZoneHashMap() {
		timeZonesMap.put("ZST", "11/05/2018 19:59");
		timeZonesMap.put("AST", "10/01/2020 19:59");
		
		HashMap<String, String> secondMap = new HashMap<String, String>();
		LocalDateTime[] localTimes = new LocalDateTime[timeZonesMap.size()];
		int index = 0;
		
		for (String time : timeZonesMap.values()) {
			secondMap.put(time, "");
			LocalDateTime convertedTime = LocalDateTime.parse(time, differentZoneFormatter);
			localTimes[index] = convertedTime;
			++index;
		}
		
		ArrayList<String> sortedKeys = new ArrayList<String>(timeZonesMap.keySet());
		Collections.sort(sortedKeys);
		
		System.out.println("Print Style 1:");
		for (String key : sortedKeys) {
			System.out.println(key + " " + timeZonesMap.get(key));
		}
		
		ArrayList<String> sortedKeysSecondMap = new ArrayList<String>(secondMap.keySet());
		Collections.sort(sortedKeysSecondMap);
		
		System.out.println("Print Style 3:");
		for (String key : sortedKeysSecondMap) {
			System.out.println(key);
		}
		
		Arrays.sort(localTimes);
		
		System.out.println("Print Style 5: Final sorted Array:");
		for (LocalDateTime time : localTimes) {
			System.out.println(localTimeArrayFormatter.format(time));
		}
	}
   
}