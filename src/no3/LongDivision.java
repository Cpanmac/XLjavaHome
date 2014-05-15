package no3;

public class LongDivision {
	public static void main(String[] args) {
		final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;	//Œ¢√Î
		final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000; 		//∫¡√Î
		System.out.println(MICROS_PER_DAY/MILLIS_PER_DAY); 
	}
}
