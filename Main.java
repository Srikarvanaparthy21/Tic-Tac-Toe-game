import java.util.*;

public class Main
{


    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	public static void main(String[] args) {
	    char gameBoard[][] = {
	    {' ','|',' ','|',' '},
	    {'-','+','-','+','-'},
	    {' ','|',' ', '|',' '},
	    {'-','+','-','+','-'},
	    {' ','|',' ', '|',' '}};
	    while(true){
	        Scanner sc= new Scanner(System.in);
	        System.out.println("Enter Your Placement (1-9):");
	        int playerpos =sc.nextInt();
	        while(playerPositions.contains(playerpos) || cpuPositions.contains(playerpos)){
	            System.out.println( "Positons taken ! Enter a correct Position");
	            playerpos = sc.nextInt();
	        }
	        placePiece(gameBoard,playerpos,"player");

	        String result = checkWinner();
	        if(result.length()> 0){
	            System.out.println(result);
	            break;
	        }
	        Random rand = new Random();
	        int cpuPos= rand.nextInt(9) + 1;
	        while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){

	            cpuPos= rand.nextInt(9) + 1;
	        }
	        placePiece(gameBoard,cpuPos,"cpu");
	        printGameboard(gameBoard);
	        result = checkWinner();
	        if(result.length()> 0){
	            System.out.println(result);
	            break;
	        }
	    }

	}


	public static void printGameboard(char [][] gameBoard){
	    for (char [] row : gameBoard){
	        for(char c:row){
	            System.out.print(c);
	        }
	        System.out.println();
	    }
	}
	public static void placePiece(char gameBoard[][],int pos,String user){
	    char symbol = ' ';
	    if(user.equals("player")){
	        symbol='X';
	        playerPositions.add(pos);
	    }
	    else if (user.equals("cpu")){
	        symbol='O';
	        cpuPositions.add(pos);
	    }
	    switch(pos){
	        case 1:
	            gameBoard[0][0] = symbol;
	            break;
	       case 2:
	            gameBoard[0][2] = symbol;
	            break;
	       case 3:
	            gameBoard[0][4] = symbol;
	            break;

	       case 4:
	            gameBoard[2][0] = symbol;
	            break;
	       case 5:
	            gameBoard[2][2] = symbol;
	            break;

	       case 6:
	            gameBoard[2][4] = symbol;
	            break;
	       case 7:
	            gameBoard[4][0] = symbol;
	            break;
	       case 8:
	            gameBoard[4][2] = symbol;
	            break;
	       case 9:
	            gameBoard[4][4] = symbol;
	            break;
	       default:
	            break;

	    }
	}



	public static String checkWinner(){

	    List topRow = Arrays.asList(1,2,3);
	    List midRow = Arrays.asList(4,5,6);
	    List botRow = Arrays.asList(7,8,9);
	    List leftcol = Arrays.asList(1,4,7);
	    List midcol = Arrays.asList(2,5,8);
	    List rightcol = Arrays.asList(3,6,9);
	    List cross1= Arrays.asList(1,5,9);
	    List cross2 = Arrays.asList(7,5,3);

	    List<List> win= new ArrayList<List>();
	    win.add(topRow);
	    win.add(midRow);
	    win.add(botRow);
	    win.add(leftcol);
	    win.add(midcol);
	    win.add(rightcol);
	    win.add(cross1);
	    win.add(cross1);
	    for( List l : win){
	        if(playerPositions.containsAll(l)){
	            return "Congratulations you won";
	        }
	        else if (cpuPositions.contains(l)){
	            return " CPU Wins! Sorry";
	        }
	        else if (playerPositions.size()+ cpuPositions.size()==9){
	            return " CAT!";

	        }
	    }
	    return "";
	}
}
