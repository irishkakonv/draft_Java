package NIIT;                                                                //enum

enum DayOfWeek{
	MON, TUE, WED, TRU, FRI, SUT, SAN
}

class DayPrinter {
	void dayPrinter(DayOfWeek day){
		String daySTR = "UNKNOWN";
		daySTR = day.name();
		/*switch(day){
		case MON:
			daySTR = "Mon";
			break;
		case TUE:
			daySTR = "TUE";
			break;
			
		case WED:
			daySTR = "WED";
			break;
		case TRU:
			daySTR = "TRU";
			break;
			
		case FRI:
			daySTR = "FRI";
			break;
		case SUT:
			daySTR = "SUT";
			break;
		case SAN:
			daySTR = "SAN";
			break;	
		default:
			daySTR = "UNKNOWN";
			break;
		}*/
		System.out.println("Day is " + daySTR);
	}
}
public class Enum {

	public static void main(String[] args) {
	//	DayOfWeek currentDay = DayOfWeek.WED;
//		DayPrinter dp = new DayPrinter();
//		dp.dayPrinter(currentDay);
		
		DayOfWeek currentDay = DayOfWeek.valueOf(null);
		DayPrinter dp = new DayPrinter();
		dp.dayPrinter(currentDay);
		

	}

}
