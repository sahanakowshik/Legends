import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class LegendsGame extends BoardGame{
    @Override
    public String getName() {
        return "Legends: Monsters and Heroes";
    }

    @Override
    public void summary() {

    }

//    public void addHeroes(LegendsPlayer player){
//        Scanner sc = new Scanner(System.in);
//        for(int i=0;i<player.getnHero();i++){
//            int choice = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the hero class:\n1. Warrior\n2. Sorceror\n3. Paladin\n", 1, 3);
//            if(choice == 1) {
//                heroes.add(new Warrior());
//            }
//            else if(choice == 2) {
//                heroes.add(new Sorcerer());
//            }
//            else {
//                heroes.add(new Paladin());
//            }
//            System.out.println(heroes.get(i).getType() + " List:\n");
//            heroes.get(i).displayList();
//            int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of the hero\n", 1, heroes.get(i).getN());
//            String[] str = heroes.get(i).allLines.get(id).split("\\s+");
//            heroes.get(i).setPlayerId(id);
//            heroes.get(i).setName(str[0]);
//            heroes.get(i).setMana(Integer.parseInt(str[1]));
//            heroes.get(i).setStrength(Integer.parseInt(str[2]));
//            heroes.get(i).setAgility(Integer.parseInt(str[3]));
//            heroes.get(i).setDexterity(Integer.parseInt(str[4]));
//            heroes.get(i).setStarting_money(Integer.parseInt(str[5]));
//            heroes.get(i).setStarting_exp(Integer.parseInt(str[6]));
//        }
//
//    }

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
//        player.setLevel(1);
//        player.setHp(1000);
        System.out.println(player.getName());
        player.setHeroes();
        Board board = new LegendsBoard();
        board.createBoard();
        System.out.println("Lets build the team");
        player.addHeroes();
        System.out.println("Your team:");
        Display.displayHeroes(player.getHeroes());
        player.createMonsters();
        player.getMonsters(player.getnHero(), player.getHeroes().get(0).getLevel());
        for(Monsters mon: player.getCurMonsters()){
            System.out.println(mon.getLevel());
        }
//        System.out.println(player.getCurMonsters());
        Display.displayBoard(board);
        Display.displayLegend();
    }

    @Override
    public Player[] getPlayers() {
        return new Player[0];
    }
}
