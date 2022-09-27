package game;
import java.util.Scanner;

import resources.TextAnimation;
	/*TODO
	 - Finish story
	 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		player player = new player();
		map map = new map();
		story story = new story();
		
		//Introduction
		System.out.print(TextAnimation.Logo());														//Show ascii QASMT logo
		TextAnimation.LoadingBar(5000);																//Show loading bar
		System.out.println("\n\nHello Adventurer what is your name? ");						
		player.name = scanner.nextLine().trim();													//Set player name
		System.out.println("Welcome " + player.name + " to the land of QASMT.");			
		// Initialize the locations and story
		story.init();
		// Game loop
		while (player.alive || !(player.gameFinished)) {											//game runs while player alive or game finished
			story.readStory(map.currentLevel, player.playerLocation[0], player.playerLocation[1]);	//display story message
			//map.printMap();
			player.action();
			player.map = map.returnLevel();
			System.out.println("Player at " + String.valueOf(player.playerLocation[0]) + " " + String.valueOf(player.playerLocation[1]));
		}
		scanner.close();
	}

}
