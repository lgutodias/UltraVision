/**
 * @author Diego
 * 
 */

package interfaces;

public interface Music<T extends Title> {

		public String getArtist();
		public T setArtist(String artist);

}
