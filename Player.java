package tictactoe;

public class Player {

    private int score;
	private char letter;
    private String name;
    private static boolean l = true;
    private static int players_count = 0;

    private Player(String name) {
        this.name = name;
        score = 0;
        if (l) {
            letter = 'X';
            l = false;
        }
        else {
            letter = 'O';
            l = true;
        }
    }

    public static Player getObject(String name) {
        if (players_count < 2) {
            Player player = new Player(name);
            players_count++;
            return player;
        } else {
            System.out.println("No Player object was created, null assigned.");
            return null;
        }
    }

	public void addScore() {
		score++;
	}

    public String getName() {
        return name;
    }
	
	public int play(Board board, int slot) {
		return board.setSlot(slot, letter);
	}

    @Override
	public String toString() {
		return this.name + ": " + score;
	}
    
}
