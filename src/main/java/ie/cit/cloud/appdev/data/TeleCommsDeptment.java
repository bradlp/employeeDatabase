package ie.cit.cloud.appdev.data;

public class TeleCommsDeptment {

	private String department;
	// range of free phone extension
	int LAST_USED_EXTN = 100;
	
	private int current_availible;
	
	public TeleCommsDeptment( )
	{
		current_availible = LAST_USED_EXTN;
	}

	public int getNetxAvailibleNumber() {
		current_availible++;
		return current_availible;
	}

	public int getNumbersAllocated() {
		return ( current_availible - LAST_USED_EXTN);
	}
}
