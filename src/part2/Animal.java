package part2;

import java.util.Random;

//Animal class
public class Animal implements Runnable{
 
 //Attributes
 private String name;//name
 private int position;//position
 private int speed;//speed
 private int restMax;//rest max
 private Food food; //food
 
 //winner
 //initialized as false
 static boolean winner = false;

 //constructor of Animal class
 public Animal(String name, int speed, int restMax, Food food) {
     this.position = 0;//initially its 0
     this.name = name;
     this.speed = speed;
     this.restMax = restMax;
     this.food = food;
 }
 
 @Override
 //run method
 public void run() {
     
     //runs until position >= 120
     while(position<120){
         
         
         //if winner = true
         //that means someone has finished the race, then exit
         if(winner) break;
         
         /*otherwise*/
         
         //print name and position
         System.out.println(name+" is at position "+ position);
         
         //new random object
         Random random = new Random();  
         //generate a random number between 0 and maxRest
         long ms = random.nextLong(restMax); 
         
         //eat the food
         food.eat(name, ms);
         
         //increase position
         position += speed;
         
     }
     
     //if animal wins
     if(position>=120 && !winner){
         System.out.println(name+" wins");
         winner = true; //set winner true
     }
 }
 
 //main method
 public static void main(String[] args) {
     
     //create a Food object
     Food food = new Food();
     
     //create two threads for hare and tortoise
     Thread hare = new Thread(new Animal("hare", 9, 220, food));
     Thread tortoise = new Thread(new Animal("tortoise", 5, 165, food));
    
     hare.start(); //start hare thread
     tortoise.start(); //start tortoise thread
 }
 
}