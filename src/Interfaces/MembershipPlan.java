package Interfaces;

import java.util.List;

public interface MembershipPlan<T> {
	
	public List<T> getAll();
	public void add(T m);
	public void delete(int index);
	public void delete(T m);
	public int size();
	public T get(int index);

}
