/**
 * @author Diego
 */

package Model;

import Interfaces.Music;

public final class Album extends Titles implements Music<Album> {
	
	//Attribute
	private String artist;
	
	//Getters and Setters
	@Override
	public String getArtist() {
		return this.artist;
	}

	@Override
	public Album setArtist(String artist) {
		this.artist = artist;
		return this;
	}

	@Override
	public String toString() {
		return "Album [id=" + getId() + ", artist=" + artist + ", title=" 
				+ getTitle() + ", genre=" + getGenre()
				+ ", year=" + getYearOfRelease() + ", media="
				+ getMediaFormat() + "]";
	}

	
	
}

