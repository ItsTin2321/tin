import java.util.*;

public class RockPaperScissors{
 public static void main(String[] arges){
   Scanner keyboard = new Scanner(System.in);
    // Gets a random number between (0,3), from computer.
    Random r = new Random();
    int pc = r.nextInt(3);
    
    // These shows the instruction for user and take user input.
    System.out.println("========== ROCK - PAPER - SCISSORS ==========");
    System.out.println("==========                         ==========");
    System.out.println("\nYou're playing against the computer, pick one: \n\nRock (0) \nPaper (1) \nScissors (2)");
    System.out.print("\nEnter your choice: ");  
    int user = keyboard.nextInt();
    

    switch(user){
     // case 0 is user input rock.
     case 0:
       System.out.println("\nYou chose rock.\n");
        /* 
        This switch goes with case 0. Depending on what number
        computer generate it will display diffrent texts.
        */
	switch(pc){
          case 0:
           System.out.println("System chose Rock. Its tie!");
           break;
          case 1:
           System.out.println("System chose Paper. You lose!");
           break;
          case 2:
           System.out.println("System chose Scissors. You win!");
           break;
        }
      break;
     // case 1 is user input Paper.
     case 1:
       System.out.println("\nYou chose Paper.\n");
        /* 
        This switch goes with case 1. Depending on what number
        computer generate it will display diffrent texts.
        */
	switch(pc){
          case 0:
           System.out.println("System chose Rock. You win!");
           break;
          case 1:
           System.out.println("System chose Paper. Its tie!");
           break;
          case 2:
           System.out.println("System chose Scissors. You lose!");
           break;
        }	
      break;
     // case 2 is user input Scissors.
     case 2:
       System.out.println("\nYou chose Scissors.\n");
        /* 
        This switch goes with case 2. Depending on what number
        computer generate it will display diffrent texts.
        */
	switch(pc){
          case 0:
           System.out.println("System chose Rock. You lose!");
           break;
          case 1:
           System.out.println("System chose Paper. You win!");
           break;
          case 2:
           System.out.println("System chose Scissors. Its tie!");
           break;
        }
      break;
     default:
      System.out.println("Not a valid choice");
    }
 
 }
}