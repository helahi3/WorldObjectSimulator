package ass5;

/**
 * 
 * @author Hamza
 * 
 */
public class Autonomous extends Movable {

	boolean hasMoved; //TODO: FIgure this out and implement
	
	/**
	 * Constructor
	 * @param name
	 * @param token
	 * @param x
	 * @param y
	 */
	public Autonomous(String name, char token, int x, int y) {
		super(name, token, x, y);
	}
	
	/**
	 * 
	 * @return an array with random direction to move
	 * int[0] is x movemnet, int[1] is y movement
	 */
	public int[] step() {
		
		int randNum = (int) (Math.random() * 4);
		int[] XYmovement;
		
		if(randNum == 0) {  XYmovement = new int[]{1,0}; }
		else if(randNum == 1) {  XYmovement = new int[]{-1,0}; }
		else if(randNum == 2) {  XYmovement = new int[]{0,1}; }
		else {  XYmovement = new int[]{0,-1}; }

		return XYmovement;
	}
	

	/**
	 * 
	 * @return if the object has moved
	 */
	public boolean hasMoved() {
		return hasMoved;
	}
	
	public void resetMoved() {
		this.hasMoved = false;
	}

}
