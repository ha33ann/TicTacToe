import java.util.*;
import java.util.Random;
public class TTT {
	    
	    static String[] tile;
	    static String turn;

	  //Klassen restartGame där logiken finns för att starta om spelet.
	    public static void restartGame(String randomString, int length) {
	    	Random random = new Random();
	    	StringBuilder sb = new StringBuilder();
	    	tile = new String[9];
	    	for (int a = 0; a < 9; a++) {
	            tile[a] = String.valueOf(a + 1);
	        }
	    	for(int i = 0; i < length; i++) {
		          int index = random.nextInt(randomString.length());
		          char randomChar = randomString.charAt(index);
		          sb.append(randomChar);
		        }
	    	turn = sb.toString();
	    }
	    
	    //checkWinner metoden kommer att kolla på kombinationen av
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
	         // Metod för att ange X eller O p� exakta tile.
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

	    	// Skapar en string av X och O
	        String randomString = "XO";

	        // Skapar en String builder
	        StringBuilder sb = new StringBuilder();

	        // Skapar en object av random klass
	        Random random = new Random();

	        // Anger längden på bokstäver
	        int length = 1;

	        for(int i = 0; i < length; i++) {

	          // Genererar random index nummer
	          int index = random.nextInt(randomString.length());

	          // Få fram bokstaven med hjälp av indexen på string
	          char randomChar = randomString.charAt(index);

	          // Appendar bokstaven till string builder
	          sb.append(randomChar);
	        }

	        String finalString = sb.toString();

	        Scanner in = new Scanner(System.in);
	        tile = new String[9];
	        turn = finalString;
	        String winner = null;
	        
	        
	  
	        for (int a = 0; a < 9; a++) {
	            tile[a] = String.valueOf(a + 1);
	        }
	  
	        System.out.println("Welcome to Tic Tac Toe game. :)");
	        BoardLayout();
	  
	        System.out.println(
	            finalString + "'s turn first. Enter a tile number to place X in:");
	  
	        while (winner == null) {
	            int numInput;
	            
	            //Exeption handling.
	            //numInput kommer att ta input från spelaren, 1-9.
	            //om det inte är 1-9 s� kommer man att få en error.
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
	        
	        //Om ingen vinner eller förlorar så blir det ett "draw" samt option för att restarta spelet.
	        if (winner != null && winner.equalsIgnoreCase("draw")) {
	            System.out.println(
	                "It's a draw! Thanks for playing. :)");
	            System.out.println("Enter restart to start a new game or quit to exit the game.");
	            Scanner s = new Scanner(System.in);
	            String choice = s.next();
	            if(choice.equals("restart")) {
	            	restartGame(randomString, length);
	            	winner = null;
	            	checkWinner();
	            	BoardLayout();
	            }
	        }

	        //Annars så visas vinnaren + winner meddelande same option att starta om spelet.
	        else if (winner != null ){
	            System.out.println(
	                "Congratulations! " + winner
	                + " have won! Thanks for playing. :)");
	            System.out.println("Enter restart to start a new game or quit to exit the game.");
	            Scanner s = new Scanner(System.in);
	            String choice = s.next();
	            if(choice.equals("restart")) {
	            	restartGame(randomString, length);
	            	winner = null;
	            	checkWinner();
	            	BoardLayout();
	            }
	        }
	        
	            
	    }
	    }
}