package ass5;

/**
 * Cell object that makes up the world
 * @author Hamza Elahi
 *
 */
public class Cell {
	int x, y;
	WorldObject obj;
	
	/**
	 * Constructor
	 * @param x coordinate
	 * @param y coordinate
	 */
	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return the object in the cell
	 */
	public WorldObject getObj() {
		return this.obj;
	}
	
	/**
	 * @return if cell is empty
	 */
	public boolean isEmpty() {
		return this.obj == null;
	}
	
	/**
	 * @return if cell contains Immovable
	 */
	public boolean containsImmovable() {
		return this.obj instanceof Immovable;
	}
	
	/**
	 * @return if cell contains Movable
	 */
	public boolean containsMoveable() {
		return this.obj instanceof Movable;
	}
	
	/**
	 * Add a new object to this cell if its empty
	 * @param newObj
	 */
	public void addObj(WorldObject newObj) {
		this.obj = newObj;
		newObj.setX(x);
		newObj.setY(y);
	}
	
	/**
	 * Remove the object from this cell
	 */
	public void clearCell() {
		this.obj = null;
	}

	/**
	 * @Override the default toString method
	 */
	public String toString() {
		String emptyCell = "{   }";
		if(this.isEmpty()) return emptyCell;

		String fullCell = "{ " + this.getObj().getToken() + " }";
		return fullCell;
				
	}
	
}
