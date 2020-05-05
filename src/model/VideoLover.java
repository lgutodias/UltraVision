/**
 * @author diego
 */
package model;

import java.util.ArrayList;
import java.util.List;
import interfaces.MembershipPlan;
import interfaces.Video;

public class VideoLover implements MembershipPlan<Video> {
	
	private List<Video> videos = new ArrayList<>();
	
	// CRUD - C = create; R = read; U = update; D = delete
	@Override
	public List<Video> getAll(){
		return this.videos;
	}
	@Override
	public void add(Video m) {
		this.videos.add(m);
	}
	@Override
	public void delete(int index) {
		this.videos.remove(this.videos.get(index));
	}
	@Override
	public void delete(Video m) {
		this.videos.remove(m);
	}
	@Override
	public int size() {
		return this.videos.size();
	}
	@Override
	public Video get(int index) {
		return this.videos.get(index);
	}
}
