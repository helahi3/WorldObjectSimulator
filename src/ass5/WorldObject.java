package ass5;

/**
 * Filename: WorldObject.java
 * @author Hamza Elahi
 * Purpose: Abstract Class that is the objects that populate the world
 * 
 */
public abstract class WorldObject {
	
	private String name;
	private char token;
	private int x, y;	

	/**
	 * Constructor of Object
	 * @param name
	 * @param token
	 * @param x
	 * @param y
	 */
	public WorldObject(String name, char token, int x, int y) {
		this.name = name;
		this.token = token;
		this.setX(x);
		this.setY(y);
	}

	/**
	 * @return the token
	 */
	public char getToken() {
		return this.token;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
}
