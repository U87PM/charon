package game;
import java.util.Arrays;
import java.util.Scanner;

public class player {
	// Variables
	public String name;
	
	public int playerLevel = 0;
	public int[] playerLocation = {0,0};
	
	public char[][] map;
	
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
					else if (commands[1].toLowerCase().equals("west")) {
						movement(-1, 0);
						}
					else if (commands[1].toLowerCase().equals("north")) {
						movement(0, 1);
						}
					else if (commands[1].toLowerCase().equals("south")) {
						movement(0, -1);
						}
					else {
						System.out.println("You can't go " + commands[1]);
					}
					
					break;
				// Interaction
				case "grab":
					// Check items around it function
					// Need to make a function to return items around
					String[] environment = {"knife", "glock"};
					if (Arrays.stream(environment).anyMatch(commands[1]::equals)) {
						System.out.println("You grab " + commands[1] + " from the ground and put it in your inventory.");
						int temp = 0;
						for (int i = 0; i < inventory.length - 1; i++) {
							if (inventory[i] == null) {
								temp = i;
								break;
							};
						}
						inventory[temp] = commands[1];
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
					// Finish of this area with all the commands
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
		if (x != 0 && x < map[0].length && x > 0) {
			playerLocation[0] += x;
		}else {
			System.out.println("You can't walk off the out of the school you have a assignment to hand in.");
		}
		if (y != 0 && y < map.length && y > 0) {
			playerLocation[1] += y;
		}else {
			System.out.println("You can't walk off the out of the school you have a assignment to hand in.");
		}
	} 
	
	public String returnInventory() {
		String temp = "";
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				temp = temp.concat(inventory[i]);
			}
			
		}
		if (temp.equals("")) {
			temp = "Seems like you are traveling light.";
		}
		return temp;
		
	}
}
