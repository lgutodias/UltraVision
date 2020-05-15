/** 
 * @author luiz
 */

package model;

import java.util.ArrayList;
import java.util.List;

import interfaces.Title;

public final class TitleFactory {
	
	
	
	
	public void display(List<Titles> p, Customer c) {
		String content = "";
		for (Titles t : p) {
			
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
		//Keyboard.textOutput(content);
	}
	
	
	public void displayTitle(List<Titles> p) {
		for (Titles t : p) {
			System.out.println(t);
		}
	}
	
	public List<Titles> searchTitle(List<Titles> p, String word) {
		
		List<Titles> l = new ArrayList<>();
		word = word.toLowerCase();
		for (Titles t : p) {
			if (t.getTitle().toLowerCase().contains(word) || t.getGenre()
					.toLowerCase().contains(word)) {
				l.add(t);
			} 
		}
		return l;
	}
	
	public Titles makeAlbum(int id, String artist, String title,
			String genre, int year, String media) {
		return new Album().setArtist(artist).setId(id).setTitle(title)
			.setGenre(genre).setYear(year).setMedia(media);
	}
	
	public Titles makeLiveConcertVideo(int id, String artist,
			String title, String genre, int year, String media) {
		return new LiveConcertVideo().setArtist(artist)
			.setTitle(title).setGenre(genre).setYear(year).setMedia(media)
			.setId(id);
	}
	
	public Titles makeMovie(int id, String director, String title,
			String genre, int year, String media) {
		return new Movie().setDirector(director).setTitle(title)
			.setGenre(genre).setYear(year).setMedia(media).setId(id);
	}
	
	public Titles makeBoxSet(int id, String title, int season,
			String genre, int year, String media) {
		return new BoxSet().setSeason(season).setTitle(title)
			.setGenre(genre).setYear(year).setMedia(media).setId(id);
	}

}
