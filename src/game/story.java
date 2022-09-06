package game;
import java.util.HashMap;

public class story {
	
	private static HashMap<String, String> storyLocations = new HashMap<String, String>();
	
	
	public void init() {
		// Create the hash map and add the things to it
				// Format: [Level#] [x] [y]
				storyLocations.put("0 0 0", "Start of the game intro placeholder");
				storyLocations.put("Germany", "Berlin");
				storyLocations.put("Norway", "Oslo");
				storyLocations.put("USA", "Washington DC");
	}
	public void readStory(int level, int x, int y){
		System.out.println(storyLocations.get(level +" " + x + " " + y));
	}
}
