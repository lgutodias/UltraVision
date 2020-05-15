/** 
 * @author luiz
 */

package model;

import java.io.Serializable;

import interfaces.Title;

public abstract class Titles implements Title, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Attributes
	private int id;
	private String title;
	private String genre;
	private int year;
	private String media;
	
	
	// Getters and Setters
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public Titles setId(int id) {
		this.id = id;
		return this;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public Titles setTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public String getGenre() {
		return this.genre;
	}

	@Override
	public Titles setGenre(String genre) {
		this.genre = genre;
		return this;
	}

	@Override
	public int getYear() {
		return this.year;
	}

	@Override
	public Titles setYear(int year) {
		this.year = year;
		return this;
	}

	@Override
	public String getMedia() {
		return this.media;
	}

	@Override
	public Titles setMedia(String media) {
		this.media = media;
		return this;
	}

	@Override
	public String toString() {
		return "Titles [id=" + id + ", title=" + title + ", genre=" + genre + ", year=" + year + ", media=" + media
				+ "]";
	}
	
}