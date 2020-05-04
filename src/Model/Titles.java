/** 
 * @author luiz
 */

package Model;

import Interfaces.Title;

public abstract class Titles implements Title {
	
	// Attributes
	private int id;
	private String title;
	private String genre;
	private int year;
	private String media;
	
	
	// Getters and Setters
	public int getId() {
		return id;
	}
	public Titles setId(int id) {
		this.id = id;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Titles setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getGenre() {
		return genre;
	}
	public Titles setGenre(String genre) {
		this.genre = genre;
		return this;
	}
	public int getYear() {
		return year;
	}
	public Titles setYear(int year) {
		this.year = year;
		return this;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	@Override
	public String toString() {
		return "Titles [id=" + id + ", title=" + title + ", genre=" + genre 
				+ ", year=" + year + ", media=" + media + "]";
	}
	
}
