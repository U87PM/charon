package game;
import java.util.Scanner;

public class Gamemain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		player player = new player();
		map map = new map();
		story story = new story();
		
		System.out.println("Hello Adventurer what is your name? ");
		player.name = scanner.nextLine().trim();
		System.out.println("Welcome " + player.name + " to the land of QASMT.");
		// Init the locations
		story.init();
		// Game loop
		while (player.alive || !(player.gameFinished)) {
			//map.printMap();
			player.action();
			story.readStory(map.currentLevel, player.playerLocation[0], player.playerLocation[1]);
		}
		scanner.close();
	}

}
