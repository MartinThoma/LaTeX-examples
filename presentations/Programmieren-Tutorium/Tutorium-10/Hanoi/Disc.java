/**
 Represents a Disc with a certain size.

 @author Tobi
*/
public class Disc {
	private int size;
	
	/**
	 Creates a {@code Disc} with a given size.
	
	 Size has to be a positive number, greater 0.
	 @param size the size of the disc.
	*/
	public Disc(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Invalid Disc-Size!");
		}
		this.size = size;
	}
	
	/**
	 Returns the size of the Disc.
	*/
	public int getSize() {
		return size;
	}
}