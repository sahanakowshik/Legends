import java.util.*;

public class LegendsGame extends BoardGame{
    @Override
    public String getName() {
        return "Legends: Monsters and Heroes";
    }

    @Override
    public void summary() {

    }

    public void addPlayer(LegendsPlayer player){
        do{

        } while(true);
    }


    @Override
    public void startGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the game of Legends: Monsters and Heroes!!");
        LegendsPlayer player = new LegendsPlayer();
        player.setName(GameFunctions.safeScanString(new Scanner(System.in), "Please enter your name:\n"));
        player.setnHero(GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the number of heroes (1-3):\n", 1, 3));
        player.setSymbol(GameFunctions.safeScanString(new Scanner(System.in), "Please enter your symbol:\n"));
        player.setHeroes();
        Board board = new LegendsBoard();
        board.createBoard();
        System.out.println("Lets build the team");
        player.addHeroes();
        System.out.println("Your team:");
        Display.displayHeroes(player.getHeroes());
        player.createMonsters();
        player.getMonsters(player.getnHero(), player.getHeroes().get(0).getLevel());
//        for(Monsters mon: player.getCurMonsters()){
//            System.out.println(mon.getLevel());
//        }
//        System.out.println(player.getCurMonsters());

        Market market = new Market();
        market.createMarket();

        while(true){
            Display.displayBoard(board);
            Display.displayLegend();
            String[] data = {"w", "a", "s", "d", "i", "e", "q"};
            String choice;
            do {
                choice = GameFunctions.safeScanString(new Scanner(System.in), "It is your turn to move:\nMove(W/A/S/D)\nCheck player Info(I)\nCheck weapons Inventory (E)\nShow map (M)\nQuit (Q)");
                //              choice = choice.toLowerCase();
                if(!Arrays.asList(data).contains(choice)) {
                    System.out.println("Please enter a valid choice....");
                }else {
                    break;
                }
            }while (true);
            switch (choice){
//                case "w": Board.move("Up");
//                        break;
//                case "s": Board.move("Down");
//                        break;
//                case "a": Board.move("Left");
//                        break;
//                case "d": Board.move("Right");
//                        break;
          }
        }
    }

    @Override
    public Player[] getPlayers() {
        return new Player[0];
    }
}
