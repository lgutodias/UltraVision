/**
 * @author diego
 */
package model;

import java.util.ArrayList;
import java.util.List;
import interfaces.MembershipPlan;
import interfaces.Music;

public class MusicLover implements MembershipPlan<Music> {
	
	private List<Music> musics = new ArrayList<>();

	@Override
	public List<Music> getAll(){
		return this.musics;
		
	}
	@Override
	public void delete(int index) {
		this.musics.remove(this.musics.get(index));
	}
	@Override
	public void delete(Music m) {
		this.musics.add(m);
	}
	@Override
	public int size() {
		return this.musics.size();
	}
	@Override
	public Music get(int index) {
		return this.musics.get(index);
	}
	
	
}
