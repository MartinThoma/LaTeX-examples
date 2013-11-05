/**
 A Pole is a stick with Discs on it. The Discs have to be sorted ascending by their size, at all time.
 Discs can be moved from one pole to another. Only the Disc on top of a pole can be accessed.
*/
public class Pole {
	private Disc[] discs;
	int currPop; //the index of the element, which has to be popped next.
	
	/**
	 Creates a {@code Pole} with a given capacity.
	 
	 The capacity is a positive number. It indicates, how many Discs can be handeld by the Pole-Instance.
	 @param capacity the capacity of the new pole
	*/
	public Pole(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Invalid capacity. Has to be >= 0!");
		}
		discs = new Disc[capacity];
		currPop = -1;
	}
	
	/**
	 Pushes a given disc to the top of this pole.
	 
	 The result will be false, if the pole is full or the size of the given disc does not fit.
	 @param d the disc to push onto this pole
	 @param true of the operation has succeeded
     @return true iff operation was successfull, otherwise false
	*/
	public boolean push(Disc d) {
		if (d == null) {
			throw new IllegalArgumentException("parameter was null");
		} else if (getTopDisc() != null && getTopDisc().getSize() <= d.getSize()) {
			return false; //size of d is too big.
		} else if (currPop >= discs.length - 1) {
			return false; //full
		}
		
		currPop++;
		discs[currPop] = d;
		return true;
	}
	
	/**
	 Fetches the Disc of the top of the Pole, removes it from the pole and returns the disc.
	 @return the top disc of the pole or null, if the pole is empty.
	*/
	public Disc pop() {
		Disc result = getTopDisc();
		if(result != null) { //if there is no top disc, there is no need of change of currPop.
			discs[currPop] = null;
			currPop--;
		}
		return result;
	}
	
	public String toString() {
		String result = "";
		for(int i = discs.length - 1; i >= 0; i--) {
			result += discToString(discs[i], discs.length) + "\n";
		}
		return result;
	}
	
	private String discToString(Disc d, int width) {
		String result = "";
		int padWhitespace = width;
		if(d == null) {
			result = "|";
		} else {
			padWhitespace = (width - d.getSize());
			for (int i = 0; i < d.getSize(); i++){
				result += "+++";
			}
		}
		//pad left/right
		for(int i = 0; i < padWhitespace; i++) {
			result = " " + result + " ";
		}
		
		return result;
	}
	
	/**
	 Returns the number of discs on this pole.
	 @return the number of discs
	*/
	public int getSize() {
		return currPop + 1;
	}
	
	/* Returns the disc on top (or null if empty), but doesn't pop it.*/
	private Disc getTopDisc() {
		if (currPop >= 0) {
			return discs[currPop];
		} else {
			return null;
		}
	}
}
