/**
 * @author diego
 */
package Model;

public class Media {
	
	//Attributes
	private String cd;
	private String bluray;
	private String dvd;
	
	//Getters and Setters
	public String getCd() {
		return cd;
	}
	public Media setCd(String cd) {
		this.cd = cd;
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
		return dvd;
	}
	public Media setDvd(String dvd) {
		this.dvd = dvd;
		return this;
	}
	@Override
	public String toString() {
		return "Media [cd=" + cd + ", bluray=" + bluray + ", dvd=" + dvd + "]";
	}
	
	
	

}
