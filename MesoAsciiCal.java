
public class MesoAsciiCal extends MesoAsciiAbstract 
{
	private String stID = "";
	
	public MesoAsciiCal(MesoStation mesoStation) {
		this.stID = mesoStation.getStID();
	}

	@Override
	int calAverage() {
		double firstAvg = 0, secondAvg = 0;
		int sum = 0;
		final String FIXED_STID = "NRMN";
		
		char[] stnChars = stID.toCharArray();
		for (int index = 0; index < stnChars.length; ++index) {
			sum += (int)stnChars[index];
		}
		firstAvg = (double)sum / stnChars.length;
		if (firstAvg % 1 < 0.25d)
			firstAvg = Math.floor(firstAvg);
		else
			firstAvg = Math.ceil(firstAvg);
		
		sum = 0;
		stnChars = FIXED_STID.toCharArray();
		for (int index = 0; index < stnChars.length; ++index) {
			sum += (int)stnChars[index];
		}
		secondAvg = (double)sum / stnChars.length;
		if (secondAvg % 1 < 0.25d)
			secondAvg = Math.floor(secondAvg);
		else
			secondAvg = Math.ceil(secondAvg);
		
		return (int) (firstAvg + secondAvg) / 2;
	}
}