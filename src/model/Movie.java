 /**
 * @author diego
 */
package model;

import interfaces.Video;

public final class Movie extends Titles implements Video<Movie> {
	
	//Attribute 
	private String director;
	
	//Getter and Setter
	@Override
	public String getDirector() {
		return this.director;
	}
	@Override
	public Movie setDirector(String director) {
		this.director = director;
		return this;
	}
	@Override
	public String toString() {
		return "Movie [id=" + getId() + ", title=" + getTitle() + ","
				+ " genre=" + getGenre() + ", director=" + director + ","
				+ " year+" + getYear() + ", media=" + getMedia() + "]";
	}
	
}
