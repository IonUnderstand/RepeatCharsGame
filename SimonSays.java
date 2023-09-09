import java.util.Random; 
import java.util.Scanner;

public class SimonSays {
	public static int level = 0;//public variable
	public static void main(String[] args) throws InterruptedException {
	System.out.println("Welcome to my SimonSays game!");
	while(true) {
	    Scanner myObj = new Scanner(System.in);  //Ask if user wants to play
		System.out.println("Would you like to play? Y for yes, N for no");
		String play = myObj.nextLine().toLowerCase();//convert to lower
		if (play.equals("y")) {//play game
			game.gameStart();//go to game class
			}
		else if (play.equals("n")) {//doesnt want to play
			end(level);
			}
		else {//not y or n
			System.out.println("I'm sorry, that wasn't an option.");
			}		
		}
	}
	public static void end(int level) {//end game method
		if(level != 0) {//if they played a round they get the well done 
			System.out.println("Well done, you lasted " + level + " levels");
		}
		System.out.println("Thanks for checking out my Simon Says game!");
		System.exit(0);//ends it
	}
}
class game{
	public static void gameStart() throws InterruptedException {
		SimonSays.level++;//originally set to 0, now increments each time
		StringBuilder sb = new StringBuilder(100);//create an SB to store the letters
		System.out.println("Lets start in 3 seconds!");
		Thread.sleep(3000);//3 seconds till start
		for (int i = 0; i <= SimonSays.level;i++) {
			Random rnd = new Random();
			char c = (char) ('a' + rnd.nextInt(26));//determines random char
			System.out.println(c);//shows char to user
			sb.append(c);//add to sb
			Thread.sleep(800);
			for(int j = 0; j < 100;j++) {//create a bunch of symbols between each letter so you cant see prev one
				System.out.println("-");
			}
		}
	    Scanner user = new Scanner(System.in);  // record user input
		System.out.println("What did Simon Say? Type out the letters in the order you saw.");
		String ans = user.nextLine();//turned input to string 
		if(ans.equalsIgnoreCase(sb.toString())){//if answer same as SB, SB converted to string
			System.out.println("Well done for passing level " + SimonSays.level + ".");
			Scanner again = new Scanner(System.in);  // Asks if they wanna play again
			continueGame(again);//Method to play again or not
		}else {//if user is wrong
			System.out.println("Sorry, better luck next time.");
			System.out.println("You wrote: '"+ans+ "' , but the correct order was: '" + sb.toString() + "'.");
			SimonSays.end(SimonSays.level);
		}
	}
	public static void continueGame(Scanner a) throws InterruptedException {
		System.out.println("Would you like to play the next level? Y for yes or N for no.");
		String next = a.nextLine().toLowerCase();//user to play next round or not
		if(next.equals("y")) {//if they want to play next round
			System.out.println("Great!");
			gameStart();
		}else if(next.equals("n")) {//dont want to play anymore
				SimonSays.end(SimonSays.level);
		}else {//did not put y or n
				System.out.println("I'm sorry, that was not an option");
				continueGame(a);
		}	
	}
}