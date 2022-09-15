package game;
import java.util.Arrays;
import java.util.Scanner;

public class player {
	// Variables
	public String name;
	
	public int playerLevel = 0;
	public int[] playerLocation = {0,0};
	
	public String[] inventory = new String[25];
	
	public boolean alive = true;
	public boolean gameFinished = false;
	
	public void checkInventory() {
		System.out.println(Arrays.toString(inventory));
	}
	
	public void action() {
		//Getting user input
		Scanner scanner = new Scanner(System.in);
		// Point to pass something into it
		System.out.println();
		String input = scanner.nextLine().trim();
		// Split commands by space
		String[] commands = input.split("\\s+");
		//Check for the action
		if (commands.length > 1) {
			if (commands[1] != null) {
				switch(commands[0]) {
				// Movement
				case "go":
				case "run":
				case "walk":
				case "travel":
					// Need to fix so player can't go out of bounds
					if(commands[1].toLowerCase().equals("east")) { 
						movement(1, 0);
						}
					else if (commands[1].toLowerCase().equals("east")) {
						movement(-1, 0);
						}
					break;
				// Interaction
				case "grab":
					// Check items around it function
					// Need to make a function to return items around
					String[] environment = {"knife", "glock"};
					if (Arrays.stream(environment).anyMatch(commands[1]::equals)) {
						System.out.println("nice");
					}else {
						System.out.println("You can't grab " + commands[1]+ " out of thin air.");
					}
					break;
				case "use":
					// Check if the item exists in the player inventory
					// Fix if player has nothing error
					if (inventory.length > 0) {
						if (Arrays.stream(inventory).anyMatch(commands[1]::equals)) {
							System.out.println("You used" + commands[1]);
						}else {
							System.out.println("You can't use " + commands[1]+ ". You don't have it.");
						}
					}
					
					break;
				case "help":
					System.out.println("Avalible commands:\n\t Go\n\tGrab\n\nUse");
					break;
				default:
					System.out.println("You can't do " + commands[0]);
					break;
				}
			}
		}else {
			if (commands[0].equals("inventory")) {
				System.out.println(returnInventory());
			}else {
				System.out.println("I don't know what " + commands[0]+ " means.");
			}
		}
		
		//scanner.close();
	}
	// Moving the location of the player
	private void movement(int x, int y) {
		System.out.println("Called");
		if (x != 0) {
			playerLocation[0] += x;
		}
		if (y != 0) {
			playerLocation[1] += y;
		}
	} 
	
	public String returnInventory() {
		String temp = "";
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				temp.concat(inventory[i]);
			}
			
		}
		return temp;
		
	}
}
