package game;

public class map {
	
	public int currentLevel = 0;
	// L block
	public char[][] level0 = {
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
	};

	public void printMap() {
		char[][] level = returnLevel();
		// Making a map border to make it look nice
		System.out.print("|");
		for (int i = 0; i < level[0].length * 2; i++) {
			System.out.print("=");
		}
		
		// Actually printing out the world content
		for (int y = 0; y < level.length; y++) {
			System.out.println("|");
			for (int x = 0; x < level[0].length; x++) {
				if (x == 0) {
					System.out.print("|");
				}
				System.out.print(level[y][x]);					
				// Spaces between the locations
				System.out.print(" ");
				
			}
		}
		// Making a map border to make it look nice
		System.out.print("|");
		System.out.println();
		System.out.print("|");
		for (int i = 0; i < level[0].length * 2; i++) {
			System.out.print("=");
		}
		System.out.print("|");
	}
	
	// Returns what the map level is
	private char[][] returnLevel() {
		switch(currentLevel) {
		case 0:
			return level0;
		default:
			return null;
		}
	}

}
