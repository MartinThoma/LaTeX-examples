/**
	This is an aotomatic Hanoi algorithm. It solves a given game.
*/
public class Hanoi {

	public static void main (String[] args) {
		Pole a = new Pole(3);
		Pole b = new Pole(3);
		Pole c = new Pole(3);
		Disc d1 = new Disc(1);
		Disc d2 = new Disc(2);
		Disc d3 = new Disc(3);
		
		a.push(d3);
		a.push(d2);
		a.push(d1);
		
		System.out.println("from: \n" + a);
		System.out.println("help: \n" + b);
		System.out.println("to: \n" + c);
		move(a, b, c);
		System.out.println("from: \n" + a);
		System.out.println("help: \n" + b);
		System.out.println("to: \n" + c);
	}
	
	public static void move(Pole from, Pole help, Pole to) {
		if(from == null | to == null || help == null) {
			throw new IllegalArgumentException("Pole is null");
		}
		
		move(from.getSize(), from, help, to);
	}

	private static void move(int n, Pole from, Pole help, Pole to) {
		if(n > 0) {
			move(n - 1, from, to, help);
			to.push(from.pop());
			move(n - 1, help, from, to);
		}
	}
}