package ie.cit.cloud.appdev.model;

public class PerformanceAppraisal {
	public enum Rating { FAREXCEEDS, SUCCESFULLYMEETS, PARTIALLYMEETS, DOESNOTMEET;}
	
	int thisyearRating;	
	int lastyearRating;
		
	public PerformanceAppraisal() {
		
	}

	public int getThisyearRating() {
		return thisyearRating;
	}

	public void setThisyearRating(int thisyearRating) {
		this.thisyearRating = thisyearRating;
	}

	
	public int getLastyearRating() {
		return lastyearRating;
	}

	public void setLastyearRating(int lastyearRating) {
		this.lastyearRating = lastyearRating;
	}



}
