/**
 * @author diego
 */
package model;

import java.util.ArrayList;
import java.util.List;

import interfaces.MembershipPlan;
import interfaces.TV;

public class TVLover implements MembershipPlan<TV> {
	
	private List<TV> tvs = new ArrayList<>();
	
	@Override
	public List<TV> getAll(){
		return this.tvs;
	}
	@Override
	public void add(TV m) {
		this.tvs.add(m);
	}
	@Override
	public void delete(int index) {
		this.tvs.remove(this.tvs.get(index));
	}
	@Override
	public void delete(TV m) {
		this.tvs.remove(m);
	}
	@Override
	public int size() {
		return this.tvs.size();
	}
	@Override
	public TV get(int index) {
		return this.tvs.get(index);
	}

}
