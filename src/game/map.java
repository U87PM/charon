package game;

public class map {
	
	public int currentLevel = 0;
	
	// map has to be a square or it doesn't like it
	public int[][] level0 = {
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
	};

	public void printMap() {
		int[][] level = returnLevel();
		// Making a map border to make it look nice
		System.out.print("|");
		for (int i = 0; i < level.length * 2; i++) {
			System.out.print("=");
		}
		
		// Actually printing out the world content
		for (int y = 0; y < level.length; y++) {
			System.out.println("|");
			for (int x = 0; x < level.length; x++) {
				if (x == 0) {
					System.out.print("|");
				}
				switch(level[y][x]) {
				case 0:
					System.out.print(" ");
				}
				System.out.print(" ");
				
			}
		}
		// Making a map border to make it look nice
		System.out.print("|");
		System.out.println();
		System.out.print("|");
		for (int i = 0; i < level.length * 2; i++) {
			System.out.print("=");
		}
		System.out.print("|");
	}
	
	// Returns what the map level is
	private int[][] returnLevel() {
		switch(currentLevel) {
		case 0:
			return level0;
		default:
			return null;
		}
	}

}
