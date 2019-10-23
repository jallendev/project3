import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private ZonedDateTime now = ZonedDateTime.now();
	private ZonedDateTime gmtTime = now.withZoneSameInstant(ZoneOffset.UTC);
	private ZonedDateTime bstTime = gmtTime.plusHours(6);
	private ZonedDateTime cstTime = gmtTime.minusHours(5);

	private DateTimeFormatter nowDateFormatter = DateTimeFormatter.ofPattern("MM/DD/yyyy hh:mm a");
	private DateTimeFormatter otherCityFormatter = DateTimeFormatter.ofPattern("hh:mm");
	private DateTimeFormatter differentZoneFormatter = DateTimeFormatter.ofPatter("MM/DD/yyyy hh:mm");

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
		HashMap timeZonesMap = new HashMap();
		timeZonesMap
	}

	@Override
	void timeZoneHashMap() {
		// TODO Auto-generated method stub
		
	}
   
}