/**
 * @author diego
 */
package model;

import interfaces.Music;

public final class LiveConcertVideo extends Titles implements Music
<LiveConcertVideo> {
	
	//Attributes
	private String artist;
	
	//Getters and Setters
	@Override
	public String getArtist() {
		return this.artist;
	}

	@Override
	public LiveConcertVideo setArtist(String artist) {
		this.artist = artist;
		return this;
	}

	@Override
	public String toString() {
		return "LiveConcertVideo [artist=" + artist + "]";
	}
	
}