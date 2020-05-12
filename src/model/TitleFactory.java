/** 
 * @author luiz
 */

package model;

import java.util.ArrayList;
import java.util.List;

import interfaces.Title;

public final class TitleFactory {
	
	public static void display(List<Title> p, Customer c) {
		String content = "";
		for (Title t : p) {
			
			Class<?> cls = t.getClass();
			String className = cls.getInterfaces()[0].getSimpleName();
			
			if (className.equalsIgnoreCase(c.getPlanType())) {
				
				content += t.toString() + "\n";
				System.out.println(t);
			} else if (c.getPlanType().equalsIgnoreCase("PR")) {
				content += t.toString() + "\n";
				System.out.println(t);
			} 
		}
		Keyboard.textOutput(content);
	}
	
	
	public static void displayTitle(List<Title> p) {
		for (Title t : p) {
			System.out.println(t);
		}
	}
	
	public static List<Title> searchTitle(List<Title> p, String word) {
		
		List<Title> l = new ArrayList<>();
		word = word.toLowerCase();
		for (Title t : p) {
			if (t.getTitle().toLowerCase().contains(word) || t.getGenre()
					.toLowerCase().contains(word)) {
				l.add(t);
			} 
		}
		return l;
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
	
	public static BoxSet makeBoxSet(int id, String title, int season,
			String genre, int year, String media) {
		return (BoxSet) new BoxSet().setSeason(season).setTitle(title)
			.setGenre(genre).setYear(year).setMedia(media).setId(id);
	}

}
