//Rishit Das 
//Student Number: 20285547

 import java.util.Random;
 import java.util.Scanner;
 
 public class GuessMaster {
     private int numOfEntities;
     private Entity[] entities; 
     private int numOfTickets;
     
     public GuessMaster() {
         numOfEntities = 0;
         entities = new Entity[100]; 
         numOfTickets = 0;
     }
 
     public void addEntity(Politician entity) {
         entities[numOfEntities++] = new Politician(entity);
     }
     
     public void addEntity(Country entity) {
         entities[numOfEntities++] = new Country(entity);
     }
     
     public void addEntity(Singer entity) {
         entities[numOfEntities++] = new Singer(entity);
     }
     
     public void addEntity(Person entity) {
         entities[numOfEntities++] = new Person(entity);
     }
     
     public void playGame(int entityId) {
         Entity entity = entities[entityId];
         playGame(entity);
     }
     
     public void playGame(Entity entity) {
         System.out.println("*********************************");
         System.out.println("Welcome! Let's start the game! " + entity.entityType());
         System.out.printf("Guess %s's birthday\n", entity.getName());
         System.out.println("(mm/dd/yyyy)");
         
         Scanner scanner = new Scanner(System.in);
 
         while (true) {
             String answer = scanner.nextLine();
             answer = answer.replace("\n", "").replace("\r", "");
 
             if (answer.equals("quit")) {
                 System.exit(0);
             }
 
             Date date = new Date(answer);
 
             if (date.precedes(entity.getBorn())) {
                 System.out.println("Incorrect. Try a later date.");
             } else if (entity.getBorn().precedes(date)) {
                 System.out.println("Incorrect. Try an earlier date.");
             } else {
                 int ticketsWon = (int) ((entity.getDifficulty()) *100);
                 numOfTickets += ticketsWon;
                 System.out.println("*************Bingo!***************\n");
                 System.out.println("You won " +ticketsWon +" tickets this round.");
                 System.out.println("The total number of your tickets is " +numOfTickets +".");
                 System.out.println("*********************************");
                 System.out.println("Congratulations! The detailed information of the entity you guessed is:");
                 System.out.println(entity.toString());
                 break;
             }
         }
     }
     
     public void playGame() {
         while (true) {
             int entityId = genRandomEntityId();
             playGame(entityId);
         }
     }
 
     public int genRandomEntityId() {
         Random randomNumber = new Random();
         return randomNumber.nextInt(numOfEntities);
     }
 
     public static void main(String[] args) {
         System.out.println("=========================\n");
         System.out.println("     GuessMaster 2.0 \n");
         System.out.println("=========================");
         Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25,1971), "Male", "Liberal", 0.25);
         Singer dion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female","La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
         Person myCreator = new Person("myCreator", new Date("September", 1, 2000), "Female", 1);
         Country usa = new Country("United States", new Date("July", 4, 1776), "Washington D.C.", 0.1);
 
         GuessMaster gm = new GuessMaster();
         gm.addEntity(trudeau);
         gm.addEntity(dion);
         gm.addEntity(myCreator);
         gm.addEntity(usa);
         
         gm.playGame();
     }
 }
 