package part2;

//Food class
public class Food {

 //synchronized method
 //for eating Food 
 public synchronized void eat(String name, long time) {

     //before eating
     System.out.println(name + " has started eating");

     //sleep given time
     try {//use a try-catch block
         Thread.sleep(time);
     } catch (InterruptedException ex) {
         ex.printStackTrace();
     }
     
   //after eating
   System.out.println(name + " has stopped eating");
 }

}
