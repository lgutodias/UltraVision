/*
 * @author Diego
 * 
 */

package Interfaces;

public interface Video<T extends Title> {

	public String getDirector();
	public T setDirector(String director);
	
}
