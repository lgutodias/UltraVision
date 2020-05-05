/** 
 * @author luiz
 */

package model;

import java.util.List;

import interfaces.Title;

public final class TitleFactory {
	
	public static void displayTitle(List<Title> p) {
		for (Title t : p) {
			System.out.println(t);
		}
	}
	
	public static Album makeAlbum(int id, String artist, String title,
			String genre, int year, String media) {
		return (Album) new Album().setArtist(artist).setId(id).setTitle(title)
			.setGenre(genre).setYear(year).setMedia(media);
	}
	
	public static LiveConcertVideo makeLiveConcertVideo(int id, String artist,
			String title, String genre, int year, String media) {
		return  (LiveConcertVideo) new LiveConcertVideo().setArtist(artist)
			.setTitle(title).setGenre(genre).setYear(year).setMedia(media)
			.setId(id);
	}
	
	public static Movie makeMovie(int id, String director, String title,
			String genre, int year, String media) {
		return (Movie) new Movie().setDirector(director).setTitle(title)
			.setGenre(genre).setYear(year).setMedia(media).setId(id);
	}
	
	public static BoxSet makeBoxSet(int id, int season, String title,
			String genre, int year, String media) {
		return (BoxSet) new BoxSet().setSeason(season).setTitle(title)
			.setGenre(genre).setYear(year).setMedia(media).setId(id);
	}

}
