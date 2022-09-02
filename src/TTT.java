import java.util.*;
public class TTT {
	    
	    static String[] tile;
	    static String turn;

	    //checkWInner metoden kommer att kolla på kombinationen av
	    //tre svar given här nere och bestämma vinnaren.
	    static String checkWinner()
	    {
	        for (int a = 0; a < 8; a++) {
	            String line = null;
	  
	            switch (a) {
	            case 0:
	                line = tile[0] + tile[1] + tile[2];
	                break;
	            case 1:
	                line = tile[3] + tile[4] + tile[5];
	                break;
	            case 2:
	                line = tile[6] + tile[7] + tile[8];
	                break;
	            case 3:
	                line = tile[0] + tile[3] + tile[6];
	                break;
	            case 4:
	                line = tile[1] + tile[4] + tile[7];
	                break;
	            case 5:
	                line = tile[2] + tile[5] + tile[8];
	                break;
	            case 6:
	                line = tile[0] + tile[4] + tile[8];
	                break;
	            case 7:
	                line = tile[2] + tile[4] + tile[6];
	                break;
	            }
	            //Om X vinner
	            if (line.equals("XXX")) {
	                return "X";
	            }
	              //Om O vinner
	            else if (line.equals("OOO")) {
	                return "O";
	            }
	        }
	          
	        for (int a = 0; a < 9; a++) {
	            if (Arrays.asList(tile).contains(
	                    String.valueOf(a + 1))) {
	                break;
	            }
	            else if (a == 8) {
	                return "draw";
	            }
	        }
	         // Metod för att ange X eller O på exakta tile.
	        System.out.println(
	            turn + "'s turn; enter a tile number to place "
	            + turn + " in:");
	        return null;
	    }
	    //Printar ut spelbrädan
	    static void BoardLayout()
	    {
	        System.out.println("-----------");
	        System.out.println(" " + tile[0] + " | "
	                           + tile[1] + " | " + tile[2]
	                           + " ");
	        System.out.println("-----------");
	        System.out.println(" " + tile[3] + " | "
	                           + tile[4] + " | " + tile[5]
	                           + " ");
	        System.out.println("-----------");
	        System.out.println(" " + tile[6] + " | "
	                           + tile[7] + " | " + tile[8]
	                           + " ");
	        System.out.println("-----------");
	    }
	  
	    public static void main(String[] args)
	    {
	        Scanner in = new Scanner(System.in);
	        tile = new String[9];
	        turn = "X";
	        String winner = null;
	  
	        for (int a = 0; a < 9; a++) {
	            tile[a] = String.valueOf(a + 1);
	        }
	  
	        System.out.println("Welcome to Tic Tac Toe game. :)");
	        BoardLayout();
	  
	        System.out.println(
	            "X's turn first. Enter a tile number to place X in:");
	  
	        while (winner == null) {
	            int numInput;
	            
	            //Exeption handling.
	            //numInput kommer att ta input från spelaren, 1-9.
	            //om det inte är 1-9 så kommer man att få en error.
	            try {
	                numInput = in.nextInt();
	                if (!(numInput > 0 && numInput <= 9)) {
	                    System.out.println(
	                        "Invalid input; please enter tile number:");
	                    continue;
	                }
	            }
	            catch (InputMismatchException e) {
	                System.out.println(
	                    "Invalid input; please enter tile number:");
	                continue;
	            }

	            //Här är logiken som bestämmer vems tur det är.
	            if (tile[numInput - 1].equals(
	                    String.valueOf(numInput))) {
	                tile[numInput - 1] = turn;
	  
	                if (turn.equals("X")) {
	                    turn = "O";
	                }
	                else {
	                    turn = "X";
	                }
	  
	                BoardLayout();
	                winner = checkWinner();
	            }
	            else {
	                System.out.println(
	                    "Tile already taken; please enter tile number:");
	            }
	        }
	        
	        //Om ingen vinner eller förlorar så blir det ett "draw".
	        if (winner.equalsIgnoreCase("draw")) {
	            System.out.println(
	                "It's a draw! Thanks for playing. :)");
	        }

	        //Annars så visas vinnaren + winner meddelande.
	        else {
	            System.out.println(
	                "Congratulations! " + winner
	                + " have won! Thanks for playing. :)");
	        }
	    }
	}