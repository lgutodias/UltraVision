/** 
 * @author luiz
 */

package interfaces;

public interface Title {
	
	public int getId();
	public void setTitle(int id);
	
	public String getTitle();
	public void setTitle(String title);
	
	public String getGenre();
	public void setGenre(String genre);
	
	public int getYearOfRelease();
	public void setYearOfRelease(int year);
	
	public String getMediaFormat();
	public void setMediaFormat(String media);

}
