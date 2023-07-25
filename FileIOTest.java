import java.util.*;
import java.io.*;
import java.util.Scanner;

public class FileIOTest {
  public static void main(String[] args) throws Exception { 
	Scanner kb1 = new Scanner(System.in);
	int input = 0;
	
	//open file
	File f = new File("expense1.txt");
	//file not exist create new file
	if(!f.exists()) { 
		String amount = "Amount";
		String description = "Description";
		PrintWriter outputFile = new PrintWriter("expense1.txt");
		outputFile.printf("%-16s %-16s",amount,description);
		outputFile.close();
	}
	
	do{	
		// opens file
		File file = new File("expense1.txt");
		Scanner inputFile = new Scanner(file);
		
		//initialize string variable
		double receivedValue = 0.0;
		double expensesValue = 0.0;
		double balanceValue = 0.0;
		
		//read file
		while(inputFile.hasNext()){
			String str = inputFile.nextLine();
			
		 String received = "";
		 String expenses = "";
		 
		 // read each character from text	 
		for (int i = 0; i < str.length(); i++) {
			
			//if char equal '$' reads whats after it to get the positive value
			if(str.charAt(i) == '$' && str.charAt(i+1) != '-' ){
				for(int j = i + 1; j < str.length(); j++){
					//if it reads a space exit loop
					if(str.charAt(j) == ' '){
						break;
					}
					// get the received value and add the string of numbers to it
					received = received + str.charAt(j);	
				
				}// end of for loop
				
				// now convert the number string into a double
				receivedValue = receivedValue + Double.parseDouble(received);
				
			//if char equal '$' and '-' reads whats after it to get the negative value
			} else if(str.charAt(i) == '$' && str.charAt(i+1) == '-' ){
				for(int k = i + 2; k < str.length(); k++){
					//if it reads a space exit loop
					if(str.charAt(k) == ' '){
						break;
					}
					// get the expense value and add the string of numbers to it
					expenses = expenses + str.charAt(k);
					
				}// end of for loop
				
				//now convert the number string into a double
				expensesValue = expensesValue + Double.parseDouble(expenses);
			}// end of if loop
			
			// if it reads a space in the txt exit loop
			if(str.charAt(i) == ' '){
				break;
			}
		}//end of for loop to read txt
		
		/* ignore this just for testing
		 System.out.println("balance = " + balance);
		 System.out.println("received = " + received);
		 System.out.println("expenses = " + expenses);*/
		 
		}// end of while loop to read txt file
		inputFile.close();
		
		System.out.println(receivedValue);
		System.out.println(expensesValue);
		
		//take whats was converted into a double and get new balance
		balanceValue = receivedValue - expensesValue;
		
		String lines = ("------------------------------------------------------------------------------");
		
		
		//format to get user input for new items
		System.out.println(lines);
		System.out.println("Balance: $" + balanceValue + "\t\t" + "Total received: $"
							 + receivedValue + "\t\t" + "Total expenses: $" + expensesValue);
		System.out.println("\n1. Add a new expense item");
		System.out.println("2. Add a new received item");
		System.out.println("3. Exit");
		input = kb1.nextInt();
		System.out.println(lines);
		
		//call the userInput1 method which will do something based on "input"
		userInput1(input);
		
	
	// end of do loop for the entire program if input is not equal to 3
	}while(input != 3);
   

  }// end of main method
  public static void userInput1(int userInput)throws Exception{
	  Scanner kb = new Scanner(System.in);
		// if user input 1 then it will do this
	    if (userInput == 1){
			System.out.println("how much was the item?");
			double expenseAmount = kb.nextDouble();
			System.out.println(expenseAmount);
			System.out.println("What is the description of the item");
			kb.nextLine();
			String expenseDescription = kb.nextLine();
			System.out.println(expenseDescription);
			////append the data user inputed to txt file 
			FileWriter fw = new FileWriter("expense1.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.printf("\n$-%-14s %-14s",expenseAmount,expenseDescription);
			out.close();
		// if user input 2 then it will do this
		}else if ( userInput == 2){
			System.out.println("how much was the item you received?");
			double receivedAmount = kb.nextDouble();
			System.out.println(receivedAmount);
			kb.nextLine();
			System.out.println("What is the description of the item");
			String receivedDescription = kb.nextLine();
			System.out.println(receivedDescription);
			//append the data user inputed to txt file 
			FileWriter fw = new FileWriter("expense1.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.printf("\n$%-15s %-15s",receivedAmount,receivedDescription);
			bw.close();
		// if user input any number but 1,2,3 then it will do this
		}else if ( userInput != 1 && userInput != 2 && userInput != 3){
			System.out.println("\nInvalid Option!!!\nTry Again!!!");
		
		}//end of if statement
  }//end of userInput1 method
}//end of class