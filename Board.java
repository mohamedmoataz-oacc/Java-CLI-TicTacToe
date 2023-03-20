package tictactoe;

public class Board {

    private char[] slots;

    Board(){
        this.slots = new char[] {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    }

    public int setSlot(int slot, char letter) {
        if (slots[slot] == ' ') {
            slots[slot] = letter;
            return 1;
        } else return 0;
    }

    @Override
    public String toString() {
        String row1 = String.format(" %c | %c | %c \n", slots[0], slots[1], slots[2]);
        String row2 = String.format(" %c | %c | %c \n", slots[3], slots[4], slots[5]);
        String row3 = String.format(" %c | %c | %c \n", slots[6], slots[7], slots[8]);
        String separator = "---+---+---\n";

        return row1+separator+row2+separator+row3;
    }

    public void startNewGame() {
        for (int i = 0; i < 9; i++) {
            slots[i] = ' ';
        }
    }

    public String check(Player p) {
        for (int i = 0; i < 3; i++) {
            if ((slots[0 + (3 * i)] == slots[1 + (3 * i)] && slots[0 + (3 * i)] == slots[2 + (3 * i)] && slots[0 + (3 * i)] != ' ') ||
                (slots[0+i] == slots[3+i] && slots[0+i] == slots[6+i] && slots[0+i] != ' ') ||
                (i%2 == 0 && slots[0+i] == slots[4] && slots[0+i] == slots[8-i] && slots[0+i] != ' ')) {
                p.addScore();
                return p.getName()+" Won!";
            }
        }
        for (int i = 0; i < 9; i++) {
            if (slots[i] == ' ') break;
            else if (i == 8 && slots[i] != ' ') return "Tie"; 
        }
        return "0";
    }

}
