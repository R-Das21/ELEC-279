//Rishit Das
// Student Number: 20285547

abstract class Entity {
    private final String name;
    private final Date born;
    // will be between 0 and 1
    private final double difficulty;

    public Entity(String name, Date birthDate, double difficulty) {
        this.name = name;
        this.born = new Date(birthDate);
        this.difficulty = difficulty; // no privacy leak
    }

    public Entity(Entity entity) {
        this.name = entity.name;
        this.born = new Date(entity.born);
        this.difficulty = entity.getDifficulty(); // no privacy leak
    }

    public int getAwardedTicketNumber() {
        Integer ticketNum = (int) (difficulty * 100);
        return ticketNum;
    }

    abstract String entityType();

    abstract Entity clone(Entity entity);

    public void welcomeMessage() {
        System.out.println("Welcome! Let's start the game! This entity is a " + entityType());
    }

    public void cloningMessage() {
        System.out.println("Congratulations! The detailed information of the entity you guessed is:\n" + toString());
    }

    public String getName() {
        return name;
    }

    public Date getBorn() {
        return new Date(born);
    }

    public String toString() {
        return "Name: " + name + "\n" + "Born at: " + born.toString() + "\n";
    }

    public double getDifficulty() {
        return difficulty;
    }
}
