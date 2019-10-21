import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeOne extends MesoDateTimeOneAbstract
{

	@Override
	int getValueOfSecond() {
		Date now = new Date();
		return now.getSeconds();
	}

	@Override
	void dateTimeNow() {
		// TODO Auto-generated method stub
		
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