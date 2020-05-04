/* 
 * @author Luiz
 */

package Interfaces;

public interface Title<T> {
	
	public int getId();
	public T setTitle(int id);
	
	public String getTitle();
	public T setTitle(String title);
	
	public String getGenre();
	public T setGenre(String genre);
	
	public int getYearOfRelease();
	public T setYearOfRelease(int year);
	
	public String getMediaFormat();
	public T setMediaFormat(String media);

}
