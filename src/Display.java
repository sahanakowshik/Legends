import java.util.List;

public class Display {
    public static void displayBoard(Board board){
        for(int i=0;i<GameConstants.boardSize;i++){
            for(int j=0;j<GameConstants.boardSize;j++){
                System.out.print("=======");
            }
            System.out.println("==");
            for(int j=0;j<GameConstants.boardSize;j++) {
                System.out.print("||" + board.grid[i][j].getSymbol());
            }
            System.out.println("||");
        }
        for(int j=0;j<GameConstants.boardSize;j++){
            System.out.print("=======");
        }
        System.out.println("==");
    }

    public static void displayHeroes(List<Heroes> heroes){
        System.out.println("Id      Name                      Level   HP   mana strength agility dexterity starting money starting experience");
        for(int i=0;i<heroes.size();i++){
            heroes.get(i).displayHero(i);
        }
    }

    public static void displayInfo(){

    }

    public static void displayLegend(){
        System.out.println("---------Legend---------");
        System.out.println("M       = Market");
        System.out.println("I       = Blocked space");
        System.out.println("<Blank> = Common space");
        System.out.println("P       = Current player");
    }
}
