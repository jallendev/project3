
public class MesoAsciiCal extends MesoAsciiAbstract 
{
	//The given station ID
	private String stID = "";
	
	//Instantiates variable above.
	public MesoAsciiCal(MesoStation mesoStation) {
		this.stID = mesoStation.getStID();
	}

	//Mathematics are beautiful to behold.
	@Override
	int calAverage() {
		//Variables follow project requirements.
		double firstAvg = 0, secondAvg = 0;
		int sum = 0;
		final String FIXED_STID = "NRMN";
		
		//Calculate the first average
		char[] stnChars = stID.toCharArray();
		for (int index = 0; index < stnChars.length; ++index) {
			sum += (int)stnChars[index];
		}
		firstAvg = (double)sum / stnChars.length;
		if (firstAvg % 1 < 0.25d)
			firstAvg = Math.floor(firstAvg);
		else
			firstAvg = Math.ceil(firstAvg);
		
		//Calculate the second average
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
		
		//Average the averages and return the average of the average averages
		return (int) (firstAvg + secondAvg) / 2;
	}
}