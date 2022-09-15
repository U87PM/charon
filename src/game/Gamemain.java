package game;
import java.io.PrintWriter;
import java.util.Scanner;

public class Gamemain {

	public static void main(String[] args) {
		// TODO Fix player movement cuz its very scuffed
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
			printSpecial();
			System.out.println(String.valueOf(player.playerLocation[0]) + String.valueOf(player.playerLocation[1]));
			
		}
		scanner.close();
	}
	
	public static void printSpecial() {
		PrintWriter printWriter = new PrintWriter(System.out,true);
		printWriter.println("aa = 💣");

	}

}
