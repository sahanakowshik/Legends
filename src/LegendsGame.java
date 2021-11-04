import java.util.*;

public class LegendsGame extends BoardGame{
    Random rand = new Random();
    public Map<Integer,ArrayList<Monsters>> monsters=new HashMap<Integer,ArrayList<Monsters>>();
    private List<Monsters> curMonsters;

    public List<Monsters> getCurMonsters() {
        return curMonsters;
    }

    @Override
    public String getName() {
        return "Legends: Monsters and Heroes";
    }

    @Override
    public void summary() {

    }

    public void createMonsters(){
        for(int i=1;i<=10;i++){
            monsters.put(i, new ArrayList<Monsters>());
        }
        List<String> ld = Dragon.getList();
        for(String str: ld){
            String[] words = str.split("\\s+");
            Monsters monster = new Dragon();
            monster.setPlayerId(Integer.parseInt(words[0]));
            monster.setName(words[1]);
            monster.setLevel(Integer.parseInt(words[2]));
            monster.setDamage(Integer.parseInt(words[3]));
            monster.setDefense(Integer.parseInt(words[4]));
            monster.setDodge_chance(Integer.parseInt(words[5]));
            monsters.get(Integer.parseInt(words[2])).add(monster);
        }
        List<String> le = Exoskeleton.getList();
        for(String str: le){
            String[] words = str.split("\\s+");
            Monsters monster = new Exoskeleton();
            monster.setPlayerId(Integer.parseInt(words[0]));
            monster.setName(words[1]);
            monster.setLevel(Integer.parseInt(words[2]));
            monster.setDamage(Integer.parseInt(words[3]));
            monster.setDefense(Integer.parseInt(words[4]));
            monster.setDodge_chance(Integer.parseInt(words[5]));
            monsters.get(Integer.parseInt(words[2])).add(monster);
        }
        List<String> ls = Spirit.getList();
        for(String str: ls){
            String[] words = str.split("\\s+");
            Monsters monster = new Spirit();
            monster.setPlayerId(Integer.parseInt(words[0]));
            monster.setName(words[1]);
            monster.setLevel(Integer.parseInt(words[2]));
            monster.setDamage(Integer.parseInt(words[3]));
            monster.setDefense(Integer.parseInt(words[4]));
            monster.setDodge_chance(Integer.parseInt(words[5]));
            monsters.get(monster.getLevel()).add(monster);
        }
    }

    public void getMonsters(LegendsPlayer player){
        curMonsters = new ArrayList<>();
        for(Heroes hero: player.getHeroes()){
            curMonsters.add(monsters.get(hero.getLevel()).get(rand.nextInt(monsters.get(hero.getLevel()).size())));
        }
//        ArrayList<Monsters> list = monsters.get(level);
//        Collections.shuffle(list);
//        curMonsters = list.subList(0, count);
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
        LegendsBoard board = new LegendsBoard();
        board.createBoard();
        board.addPlayer(player);
        System.out.println("Lets build the team");
        player.addHeroes();
        System.out.println("Your team:");
        Display.displayHeroes(player.getHeroes());
        this.createMonsters();
        Market market = new Market();
        market.createMarket();
        Display.displayBoard(board);
        Display.displayLegend();

        while(true){
            String[] data = {"w", "a", "s", "d", "i", "e", "m", "q"};
            String choice;
            label:
            do {
                choice = GameFunctions.safeScanString(new Scanner(System.in), "It is your turn to move:\nMove(W/A/S/D)\nCheck player Info(I)\nCheck weapons Inventory (E)\nShow map (M)\nQuit (Q)\n");
                choice = choice.toLowerCase();
                if(!Arrays.asList(data).contains(choice)) {
                    System.out.println("Please enter a valid choice....");
                }else {
                    switch (choice) {
                        case "w":
                            if (!board.canMove(board.getI() - 1, board.getJ())) {
                                System.out.println("Inaccessible! Please enter a valid choice....");
                            } else {
                                board.move(board.getI() - 1, board.getJ(), player);
                                Display.displayBoard(board);
                                Display.displayLegend();
                                break label;
                            }
                            break;
                        case "s":
                            if (!board.canMove(board.getI() + 1, board.getJ())) {
                                System.out.println("Inaccessible! Please enter a valid choice....");
                            } else {
                                board.move(board.getI() + 1, board.getJ(), player);
                                Display.displayBoard(board);
                                Display.displayLegend();
                                break label;
                            }
                            break;
                        case "a":
                            if (!board.canMove(board.getI(), board.getJ() - 1)) {
                                System.out.println("Inaccessible! Please enter a valid choice....");
                            } else {
                                board.move(board.getI(), board.getJ() - 1, player);
                                Display.displayBoard(board);
                                Display.displayLegend();
                                break label;
                            }
                            break;
                        case "d":
                            if (!board.canMove(board.getI(), board.getJ() + 1)) {
                                System.out.println("Inaccessible! Please enter a valid choice....");
                            } else {
                                board.move(board.getI(), board.getJ() + 1, player);
                                Display.displayBoard(board);
                                Display.displayLegend();
                                break label;
                            }
                            break;
                        case "e":
                            for (int i = 0; i < player.getnHero(); i++) {
                                System.out.println(player.getHeroes().get(i).getName() + " Inventory");
                                player.getHeroes().get(i).showInventory();
                                System.out.println();
                            }
                            break;
//                            break label;
                        case "i":
                            Display.displayHeroes(player.getHeroes());
                            break;
//                            break label;
                        case "m":
                            Display.displayBoard(board);
                            Display.displayLegend();
                            break;
                        default:
                            System.out.println("Thanks for playing");
                            return;
                    }
                }
            }while (true);

            if(board.grid[board.getI()][board.getJ()].getSymbol().contains("M")){
                System.out.println("Market");
            }
            else if(!board.grid[board.getI()][board.getJ()].getSymbol().contains("I") && GameFunctions.getRandomBoolean((float)0.17)){
                this.getMonsters(player);
                for(Monsters mon: this.getCurMonsters()){
                    System.out.println(mon.getName());
                }
                System.out.println(this.getCurMonsters());
            }

//            break;
        }
    }

    @Override
    public Player[] getPlayers() {
        return new Player[0];
    }
}
