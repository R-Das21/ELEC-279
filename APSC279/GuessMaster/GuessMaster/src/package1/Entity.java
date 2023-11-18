//Rishit Das
//Student Number: 20285547
//February 16th 2023
package package1; 
public class Entity
{ 
    private String name; 
    private Date born;
    
   
    public Entity(String name, Date date){ //constructor that sets the entity name and birthday
    	this.name = name;
    	this.born = new Date(date);
    }
    
    public Entity(String name){ //Copy constructor without privacy leak 
    	this.name = name;
    }
    
    public boolean equals(Entity entity) { //checks if the entity is already an instance
    	if (!(entity instanceof Entity))
    		return false;
    	else {
    		return true;
    	}
    }
    
    public String toString() { //returns the answer to GuessMaster
    	return getName() +"was born on " +born.toString();
    }
    
    public String getName() { //returns the name 
    	new Entity(name);
    	return name;
    }
    
    public Date getDate() { //returns the date 
    	return new Date(born);
    }
}

