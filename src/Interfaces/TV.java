package Interfaces;

public interface TV<T extends Title> {
	
	public int getSeason();
	public T setSeason(int season);

}
