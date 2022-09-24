package game;
import java.util.Scanner;

public class Gamemain {
	// TODO Finish off story

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		player player = new player();
		map map = new map();
		story story = new story();
		
		System.out.println("Hello Adventurer what is your name? ");
		player.name = scanner.nextLine().trim();
		System.out.println("Welcome " + player.name + " to the land of QASMT.");
		// Init the locations and story
		story.init();
		// Game loop
		while (player.alive || !(player.gameFinished)) {
			story.readStory(map.currentLevel, player.playerLocation[0], player.playerLocation[1]);
			//map.printMap();
			player.action();
			player.map = map.returnLevel();
			System.out.println("Player at " + String.valueOf(player.playerLocation[0]) + " " + String.valueOf(player.playerLocation[1]));
			
		}
		scanner.close();
	}

}
