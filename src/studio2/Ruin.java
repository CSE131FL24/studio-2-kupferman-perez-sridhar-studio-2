package studio2;
import java.util.Scanner;
public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("How much money are you starting with?");
		int startAmount = in.nextInt();
		int ogStartAmount = startAmount;

		System.out.println("What are the chances of winning?");
		double winChance = in.nextDouble();

		System.out.println("What is the win limit?");
		int winLimit = in.nextInt();

		System.out.println("How many days will you be gambling?");
		int totalSimulations = in.nextInt();
		
		String output = "";
		int lossCounter = 0;
		double a = (1.0 - winChance)/winChance;
		
		int plays = 0;

		for (int i = 1; i <= totalSimulations; i++) {
			plays = 0;
			startAmount = ogStartAmount;
			while(startAmount > 0 && startAmount < winLimit) {
				if(winChance > Math.random()) {
					startAmount++;
				}
				else {
					startAmount--;
				}
				
				plays++;
				
				if(startAmount ==  winLimit) {
					break;
				}
			}
			
			if(startAmount > 0) {
				output = "WIN";
			}
			else {
				output = "LOSE";
				lossCounter++;
			}
			System.out.println("Simulation " + i + ": " + plays + " " + output); 
			}
		System.out.println("Losses: " + lossCounter + " Simulations: " + totalSimulations);
		if(winChance != 0.5) {
			System.out.print("Ruin Rate from Simulation: " + Math.pow(a, startAmount));
		}
		else {
			System.out.print("Expected Ruin Rate: " + (1-(startAmount/winLimit)));
		}
	}

		
	}


