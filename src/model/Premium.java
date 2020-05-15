/**
 * @author diego
 */
package model;

import java.util.ArrayList;
import java.util.List;
import interfaces.MembershipPlan;
import interfaces.Title;

public class Premium implements MembershipPlan<Title> {
	
	//Attribute
	private List<Title> titles = new ArrayList<>();
	
	// CRUD - Create, Read, Update and Delete
	@Override
	public List<Title> getAll(){
		return this.titles;
	}
	@Override
	public void add(Title m) {
		this.titles.add(m);
	}
	@Override
	public void delete(int index) {
		this.titles.remove(this.titles.get(index));
	}
	@Override
	public void delete(Title m) {
		this.titles.remove(m);
	}
	@Override
	public int size() {
		return this.titles.size();
	}
	@Override
	public Title get(int index) {
		return this.titles.get(index);
	}
	
}
