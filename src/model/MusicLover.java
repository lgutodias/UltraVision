/**
 * @author diego
 */
package model;

import java.util.ArrayList;
import java.util.List;
import interfaces.MembershipPlan;
import interfaces.Music;

public class MusicLover implements MembershipPlan<Music> {
	
	//Attribute
	private List<Music> music = new ArrayList<>();
	
	
	@Override
	public List<Music> getAll(){
		return this.music;
		
	}
	@Override
	public void delete(int index) {
		this.music.remove(this.music.get(index));
	}
	@Override
	public void delete(Music m) {
		this.music.add(m);
	}
	@Override
	public int size() {
		return this.music.size();
	}
	@Override
	public Music get(int index) {
		return this.music.get(index);
	}
	@Override
	public void add(Music m) {
		music.add(m);
		
	}
	
	
}
