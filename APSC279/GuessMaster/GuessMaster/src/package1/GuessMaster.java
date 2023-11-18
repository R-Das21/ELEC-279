//Rishit Das
//Student Number: 20285547
//February 16th 2023
package package1; 
import java.util.Random;
import java.util.Scanner;

public class GuessMaster {	
	private static int numberOfCandidateEntities = 3;
	private static Entity[] entities = new Entity[100]; //initialize 
	
	public void addEntity(Entity entity) { //adds entity to array and increments the size of the array
		if (equals(entity) == false) {
		entities[numberOfCandidateEntities] = entity;
		numberOfCandidateEntities++;
		} else {
			System.out.println("Entity already exists");
		}
	}
	 
	public void playGame (Entity entity) {
		System.out.println("Welcome to GuessMaster!\n");
		System.out.println("You will be guessing the birthday of\n" + entity.getName());
		boolean tryAgain = true;
        while (tryAgain) {
        	Scanner keyboard = new Scanner(System.in);
        	String line = keyboard.nextLine().replace("\n", "").replace("\r", ""); 
        	if (line.equals("quit")) {
    			System.exit(0);
        	}
        	Date inputDate = new Date(line); //creates a date object from the user input
        	Date test = entity.getDate(); 
    		if (inputDate.succeeds(test) == true) { 
    			System.out.println("Incorrect. Try an earlier date.");
    		}
    		if (inputDate.precedes(test) == true) {
    			System.out.println("Incorrect. Try a later date.");
    		}
    		if (inputDate.equals(test) == true) { //checks for correct guess
    			System.out.println("BINGO. You got it!!");
    			System.out.println(entity.toString());
    			break;
    		}
        }
	}
	
	public void playGame (int entityInd) { //plays game with that particular entity of the array
		if (entities[entityInd] != null) {
			playGame (entities[entityInd]);
		}
		else { 
			playGame();
		}
	}
	
	public void playGame () { //generates new index for game to play with
		genRandomEntityInd();
		while (true) {
			playGame(genRandomEntityInd());
		}
	}
	
	int genRandomEntityInd() { //generates a random number between 0 and number of entries 
		Random rand = new Random();
		int rand_int = rand.nextInt(numberOfCandidateEntities);
		return rand_int;
	}
	
	public static void main(String[] args) {
		Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
		Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
		Entity usa = new Entity("United States", new Date("July", 14, 1776));
		
		GuessMaster game = new GuessMaster();
		game.addEntity(trudeau);
		game.addEntity(dion);
		game.addEntity(usa);
		
		game.playGame();
	}
}