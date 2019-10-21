import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private Calendar now = Calendar.getInstance();

	@Override
	int getValueOfSecond() {
		now = Calendar.getInstance();
		System.out.println("The value of Second now: " + now.SECOND);
		return now.SECOND;
	}

	@Override
	void dateTimeNow() {
		now = Calendar.getInstance();
		System.out.println("Current Date/Time: " + now.MONTH + "/" + now.DAY_OF_MONTH + "/" + now.YEAR + " " + now.HOUR + ":" + now.MINUTE + " " + now.AM_PM);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	void dateTimeDifferentZone() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void timeZoneHashMap() {
		// TODO Auto-generated method stub
		
	}
   
}