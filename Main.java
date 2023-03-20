package tictactoe;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        System.out.println("TIC TAC TOE");
        System.out.print("Enter player1 name: ");
        Player player1 = Player.getObject(scanner.nextLine());
        System.out.print("Enter player2 name: ");
        Player player2 = Player.getObject(scanner.nextLine());

        Player[] players = new Player[] {player1, player2};
        int turn = 0;
        boolean view_board = true;
        boolean let_O_begin_nextgame = true;
        
        while (true) {
            turn = turn%2;
            if (view_board){
                System.out.println(board); 
            }
            int n;
            String in;
            while (true) {
                try{
                    System.out.print("Enter the number of a slot (0-8): ");
                    in = scanner.next();
                    n = Integer.parseInt(in);
                    break;
                } catch (Exception e) {
                    System.out.println("You can only enter an integer value, please try again.");
                }
            }
            if (n > 8 || n < 0) {
                System.out.println("The number must be between 0 and 8, please try again.");
                view_board = false;
                continue;
            }

            int condition = players[turn].play(board, n);
            if (condition == 0) {
                view_board = false;
                System.out.println("This slot is taken, please enter the number of an empty slot.");
                continue;
            }

            view_board = true;

            String state = board.check(players[turn]);
            if (state.equals("Tie") || state.equals(players[turn].getName()+" Won!")) {
                System.out.println(board.toString());
                System.out.println(state);
                System.out.println(player1.toString()+"\t"+player2.toString());
                System.out.print("Start a new game? (yes or no): ");
                String response = scanner.next();
                if (response.equals("yes")) {
                    board.startNewGame();
                    if (let_O_begin_nextgame) {
                        turn = 0;
                        let_O_begin_nextgame = false;
                    } else {
                        turn = 1;
                        let_O_begin_nextgame = true;
                    }
                }else break;
            } 
            turn++;
        }
        System.out.print("Did you enjoy the game (yes or no): ");
        String feedback = scanner.next();
        String fullmark = (feedback.equals("yes"))? "Then please give me a star. :)": "Thanks for playing. -_-";
        System.out.println(fullmark);
        scanner.close();
    }

}
