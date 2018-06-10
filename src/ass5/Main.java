package ass5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Create a new world
		World world = buildWorld();
		
		Scanner sc = new Scanner(System.in);
		String input = "";
		
		//Keep looping till the input equals N or n
		while (!(input.equals("N") || input.equals("n"))) {
			
			//Run simulation 100 times
			for(int i = 0; i <100; i++) {
				//System.out.println(world);
				world.display();
				world.step();
			}
			//Keep taking input till input is Y or N
			do {
				System.out.println("The simulation has been run 100 times. Please press Y to run 100 more times, or N to quit");
				input = sc.nextLine();
			} while (!(input.equals("N") || input.equals("Y") || input.equals("n") || input.equals("y")));
		}
		System.out.println("Goodbye!");
	}
	
	/**
	 * Build a world and populate it
	 * @return the world created
	 */
	private static World buildWorld() {
		World world = new World(5,5);
		
		//Create 9 objects
		Autonomous Aa = new Autonomous("aut1",'A',1,1);
		Autonomous Ab = new Autonomous("aut2",'A',3,3);
		Movable Ma = new Movable("mov1",'M',2,1);
		Movable Mb = new Movable("mov1",'M',1,3);
		Movable Mc = new Movable("mov1",'M',2,3);
		Immovable Ia = new Immovable("imm1",'I',1,2);
		Immovable Ib = new Immovable("imm1",'I',3,2);
		Immovable Ic = new Immovable("imm1",'I',4,1);
		Immovable Id = new Immovable("imm1",'I',4,3);
		
		//Add them to the world
		try {
			world.add(Aa,1,2); world.add(Ab,3,3); world.add(Ma,2,1);
			world.add(Mb,1,3); world.add(Mc,2,3); world.add(Ia,1,2);
			world.add(Ib,3,2); world.add(Ic,4,1); world.add(Id,4,3);
		} catch (Exception e) {
	  		System.out.println("Entered coordinates do not match object. Fix code!");
			System.exit(0);
		}

		return world;
	}
	

}
