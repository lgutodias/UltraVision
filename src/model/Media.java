/**
 * @author diego
 */
package model;

public class Media {
	
	//Attributes
	private String CD;
	private String bluray;
	private static String DVD;
	
	static String media;
	
	
public static void validMedia() {
		
		if (media == "CD") {
			
		} else if (media == "DVD") {
			
		} else if(media == "BLU-RAY") {
			
		}
		System.out.println("TYPE CD, DVD OR BLU-RAY");
	}
	
		
	//Getters and Setters
	public String getCd() {
		return CD;
	}
	public Media setCd(String CD) {
		this.CD = CD;
		return this;
	}
	public String getBluray() {
		return bluray;
	}
	public Media setBluray(String bluray) {
		this.bluray = bluray;
		return this;
	}
	public String getDvd() {
		return DVD;
	}
	public Media setDvd(String DVD) {
		this.DVD = DVD;
		return this;
	}
	@Override
	public String toString() {
		return "Media [cd=" + CD + ", bluray=" + bluray + ", dvd=" + DVD + "]";
	}
	
	
	

}
