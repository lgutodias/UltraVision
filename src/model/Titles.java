/** 
 * @author luiz
 */

package model;

import interfaces.Title;

public abstract class Titles implements Title<Titles> {
	
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
	public int getYearOfRelease() {
		return year;
	}
	public Titles setYearOfRelease(int year) {
		this.year = year;
		return this;
	}
	public String getMediaFormat() {
		return media;
	}
	public Titles setMediaFormat(String media) {
		this.media = media;
		return this;
	}
	@Override
	public String toString() {
		return "Titles [id=" + id + ", title=" + title + ", genre=" + genre 
				+ ", year=" + year + ", media=" + media + "]";
	}
	
}
