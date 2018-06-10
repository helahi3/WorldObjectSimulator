package ass5;

import java.util.ArrayList;

/**
 * 
 * @author Hamza Elahi
 * The World class
 */
public class World {
	private Cell[][] worldArray;
	
	/**
	 * Constructor that creates the worldArray
	 * @param x
	 * @param y
	 */
	public World(int x, int y){
		if((x > 0) && (y > 0)) {
			this.worldArray = new Cell[x][y];
		}
		
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				worldArray[i][j] = new Cell(i,j);
			}
		}
	}
	

	
	/**
	 * Add the object to the World 
	 * @param obj
	 * @param x
	 * @param y
	 * @throws Exception 
	 */
	 public void add(WorldObject obj, int x, int y) throws Exception  {
	      if(((x < 0) && (y > 0)) || ((x > worldArray.length) && (y > worldArray[0].length))) {
	           System.out.println("Your coordinates are out of bounds. Object not added");
	           return;
	      }
	      if(x != obj.getX() || y != obj.getY()) {
	    	  		throw new Exception();
	      }
	      this.worldArray[x][y].addObj(obj);
	 }
	
	/**
	 * Cycle through each cell in the world
	 * If the object is autonomous, attempt to move it
	 */
	public void step() {
		WorldObject temp;
		
		//loop through each spot in 2d array
		for(int i=0; i < worldArray.length; i++) {
			for(int j=0; j < worldArray[i].length; j++) {
				
				if(worldArray[i][j].isEmpty()) //do nothing if spot is empty
					continue;
				
				temp = worldArray[i][j].getObj(); //otherwise get object and check if autonomous
				if(temp instanceof Autonomous) {
					
					int[] XY = ((Autonomous) temp).step(); //Get the x movement amount and Y movement amount
					moveObj(i, j, i+ XY[0], j+ XY[1]);     // and move the object
				}
			}
		}
	}
	
	/**
	 * Try to check if the object can be moved
	 * Recursively check if all objects in its path can also be moved
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 * @return whether the object was moved or not
	 */
	public boolean moveObj(int startX, int startY, int endX, int endY) {
		
		//Return false if any of the inputs are out of bounds
		if(startX < 0 || startY < 0 || endX < 0 || endY < 0 || startX >= worldArray.length 
				|| startY >= worldArray[0].length ||endX >= worldArray.length || endY >= worldArray[0].length)
			return false;
		
		
		int Xdiff = endX - startX;
		int Ydiff = endY - startY;
		Cell startCell = worldArray[startX][startY];
		Cell endCell = worldArray[endX][endY];
		
		
			//Return false if empty cell, else get the object in cell
		if(startCell.isEmpty()) return false;
		WorldObject obj = startCell.getObj();
	
		
			//Return false if endCell has immovable
		if(endCell.containsImmovable()) return false;
		
		
			//If endCell has moveable/autonomous, recursively run moveObj on that object
		if(endCell.containsMoveable()) {
			
			if(moveObj(endX, endY, endX + Xdiff, endY + Ydiff) == false)
				return false;  	//If the inner moveObj returns false, this method will also return false
		}

			//If endCell is empty, move the object and return true
		if(endCell.isEmpty()) {
			startCell.clearCell();
			endCell.addObj(obj);
			
			return true;
		}
		return false;
	}
		
	/**
	 * @param row
	 * @param column
	 * @return the Cell at the given location
	 */
	public Cell getCell(int row, int column) {
		return worldArray[row][column];
	}
	
	public void display() {
		System.out.println(this);
	}
	
	public Cell[][] getWorldArray(){
		return this.worldArray;
	}
	
	/**
	 * @return a console depiction of the world
	 */
	public String toString() {
		
		String board = "";
		for(int i=0; i<worldArray.length; i++) {
			for(int j=0; j<worldArray[i].length; j++) {
				board += worldArray[j][i];
			}
			board += "\n";
		}
		return board;
	}
	
	
	
	
}
