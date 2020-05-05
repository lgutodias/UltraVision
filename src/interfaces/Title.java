/** 
 * @author luiz
 */

package interfaces;

public interface Title<T> {
	
	public int getId();
	public T setId(int id);
	
	public String getTitle();
	public T setTitle(String title);
	
	public String getGenre();
	public T setGenre(String genre);
	
	public int getYear();
	public T setYear(int year);
	
	public String getMedia();
	public T setMedia(String media);

}
