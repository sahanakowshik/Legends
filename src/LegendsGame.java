import java.util.*;

public class LegendsGame extends RpgGame{
    public Map<Integer,ArrayList<Monsters>> monsters=new HashMap<Integer,ArrayList<Monsters>>();
    private List<Monsters> curMonsters;
    private LegendsPlayer player;
    private Market market;
//    private isEquip

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
    }

    public void buySell(){
        System.out.println("\u001B[44m You have entered the market \u001B[0m");
        for(Heroes hero: player.getHeroes()){
            int heroChoice = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), hero.getName() + " would you like to enter the store\n1. Yes\n2. No\n", 1, 2);
            if(heroChoice == 2)
                continue;
            else {
                do {
                    int val = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "What would you like to do?\n1. Buy\n2. Sell\n3. Exit\n", 1, 3);
                    if (val == 1) {
                        int mchoice = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "What would you like to buy?\n0. Exit\n1. Armory\n2. Weapon\n3. Potion\n4. Spell\n", 0, 4);
                        if (mchoice == 1) {
                            do {
                                market.displayArmory();
                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the Id of the item you want to buy\n0. Exit\n", 0, market.getArmory().armories.size());
                                if (id != 0) {
                                    id = id-1;
                                    if (market.getArmory().armories.get(id).getReq_level() > hero.getLevel()) {
                                        System.out.println("You cannot buy this item. it needs level " + market.getArmory().armories.get(id).getReq_level());
                                    } else {
                                        if (hero.getStarting_money() < market.getArmory().armories.get(id).getCost()) {
                                            System.out.println("You don't have the balance to buy this item");
                                        }
                                        else if(hero.getArmories().contains(market.getArmory().armories.get(id))){
                                            System.out.println("You already own this item");
                                        }
                                        else {
                                            hero.setStarting_money(hero.getStarting_money() - market.getArmory().armories.get(id).getCost());
                                            if(GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Would you like to equip this item?\n1. Yes\n2. No\n", 1, 2) == 1){
                                                for(int i=0;i<hero.getArmories().size();i++){
                                                    hero.getArmories().get(i).setEquip("No");
                                                }
                                                Armory item = market.getArmory().armories.get(id);
                                                item.setEquip("Yes");
                                                hero.getArmories().add(item);
                                                hero.setIsEquipped(true);
                                            }
                                            else{
                                                hero.getArmories().add(market.getArmory().armories.get(id));
                                            }
                                            break;
                                        }
                                    }
                                }
                                else
                                    break;
                            }while (true);
                            for(int i=0;i<hero.getArmories().size();i++){
                                hero.getArmories().get(i).setId(i+1);
                            }
                        } else if (mchoice == 2) {
                            do {
                                market.displayWeaponry();
                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the Id of the item you want to buy\n0. Exit\n", 0, market.getWeaponry().weapons.size());
                                if (id != 0) {
                                    id = id-1;
                                    if (market.getWeaponry().weapons.get(id).getLevel() > hero.getLevel()) {
                                        System.out.println("You cannot buy this item. it needs level " + market.getWeaponry().weapons.get(id).getLevel());
                                    } else {
                                        if (hero.getStarting_money() < market.getWeaponry().weapons.get(id).getCost()) {
                                            System.out.println("You don't have the balance to buy this item");
                                        }
                                        else if(hero.getWeapons().contains(market.getWeaponry().weapons.get(id))){
                                            System.out.println("You already own this item");
                                        }
                                        else {
                                            hero.setStarting_money(hero.getStarting_money() - market.getWeaponry().weapons.get(id).getCost());
                                            if(GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Would you like to equip this item?\n1. Yes\n2. No\n", 1, 2) == 1){
                                                for(Weaponry item: hero.getWeapons()){
                                                    item.setEquip("No");
                                                }
                                                Weaponry item = market.getWeaponry().weapons.get(id);
                                                item.setEquip("Yes");
                                                hero.getWeapons().add(item);
                                                hero.setIsEquipped(true);
                                            }
                                            else{
                                                hero.getWeapons().add(market.getWeaponry().weapons.get(id));
                                            }
                                            break;
                                        }
                                    }
                                }
                                else
                                    break;
                            }while (true);
                            for(int i=0;i<hero.getWeapons().size();i++){
                                hero.getWeapons().get(i).setId(i+1);
                            }
                        } else if (mchoice == 3) {
                            do {
                                market.displayPotions();
                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the Id of the item you want to buy\n0. Exit\n", 0, market.getPotion().potions.size());
                                if (id != 0) {
                                    id = id-1;
                                    if (market.getPotion().potions.get(id).getReq_level() > hero.getLevel()) {
                                        System.out.println("You cannot buy this item. it needs level " + market.getPotion().potions.get(id).getReq_level());
                                    } else {
                                        if (hero.getStarting_money() < market.getPotion().potions.get(id).getCost()) {
                                            System.out.println("You don't have the balance to buy this item");
                                        }
                                        else if(hero.getPotions().contains(market.getPotion().potions.get(id))){
                                            System.out.println("You already own this item");
                                        }
                                        else {
                                            hero.getPotions().add(market.getPotion().potions.get(id));
                                            hero.setStarting_money(hero.getStarting_money() - market.getPotion().potions.get(id).getCost());
                                            break;
                                        }
                                    }
                                }
                                else
                                    break;
                            }while (true);
                            for(int i=0;i<hero.getPotions().size();i++){
                                hero.getPotions().get(i).setId(i+1);
                            }
                        } else if (mchoice == 4) {
                            int sp = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Which spell would you like to buy?\n0. Exit\n1. Fire Spell\n2. Ice Spell\n3. Lightning Spell\n", 0, 3);
                            if (sp == 1) {
                                do {
                                    market.displayFireSpells();
                                    int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the Id of the item you want to buy\n0. Exit\n", 0, market.getFireSpell().fireSpells.size());
                                    if (id != 0) {
                                        id = id-1;
                                        if (market.getFireSpell().fireSpells.get(id).getReq_level() > hero.getLevel()) {
                                            System.out.println("You cannot buy this item. it needs level " + market.getFireSpell().fireSpells.get(id).getReq_level());
                                        } else {
                                            if (hero.getStarting_money() < market.getFireSpell().fireSpells.get(id).getCost()) {
                                                System.out.println("You don't have the balance to buy this item");
                                            } else {
                                                hero.getSpells().add(market.getFireSpell().fireSpells.get(id));
                                                hero.setStarting_money(hero.getStarting_money() - market.getFireSpell().fireSpells.get(id).getCost());

                                                break;
                                            }
                                        }
                                    }
                                    else
                                        break;
                                }while (true);
                            } else if (sp == 2) {
                                do {
                                    market.displayIceSpells();
                                    int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the Id of the item you want to buy\n0. Exit\n", 0, market.getIceSpell().iceSpells.size());
                                    if (id != 0) {
                                        id = id-1;
                                        if (market.getIceSpell().iceSpells.get(id).getReq_level() > hero.getLevel()) {
                                            System.out.println("You cannot buy this item. it needs level " + market.getIceSpell().iceSpells.get(id).getReq_level());
                                        } else {
                                            if (hero.getStarting_money() < market.getIceSpell().iceSpells.get(id).getCost()) {
                                                System.out.println("You don't have the balance to buy this item");
                                            } else {
                                                hero.getSpells().add(market.getIceSpell().iceSpells.get(id));
                                                hero.setStarting_money(hero.getStarting_money() - market.getIceSpell().iceSpells.get(id).getCost());
                                                break;
                                            }
                                        }
                                    }
                                    else
                                        break;
                                }while (true);
                            } else if (sp == 3) {
                                do {
                                    market.displayLightningSpells();
                                    int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the Id of the item you want to buy\n0. Exit\n", 0, market.getLightningSpell().lightningSpells.size());
                                    if (id != 0) {
                                        id = id-1;
                                        if (market.getLightningSpell().lightningSpells.get(id).getReq_level() > hero.getLevel()) {
                                            System.out.println("You cannot buy this item. it needs level " + market.getLightningSpell().lightningSpells.get(id).getReq_level());
                                        } else {
                                            if (hero.getStarting_money() < market.getLightningSpell().lightningSpells.get(id).getCost()) {
                                                System.out.println("You don't have the balance to buy this item");
                                            } else {
                                                hero.getSpells().add(market.getLightningSpell().lightningSpells.get(id));
                                                hero.setStarting_money(hero.getStarting_money() - market.getLightningSpell().lightningSpells.get(id).getCost());
                                                break;
                                            }
                                        }
                                    }
                                    else
                                        break;
                                }while (true);
                            }
                            for(int i=0;i<hero.getSpells().size();i++){
                                hero.getSpells().get(i).setId(i+1);
                            }
                        }
                        System.out.println("\u001B[36m " + hero.getName() + " Inventory \u001b[0m");
                        hero.showInventory();
                        System.out.println(hero.getName() + "Info");
                        Display.displayHeroes(player.getHeroes());

                    } else if (val == 2) {
                        hero.showInventory();
                        int mchoice = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "What would you like to sell?\n0. Exit\n1. Armory\n2. Weapon\n3. Potion\n4. Spell\n", 0, 4);
                        if(mchoice == 1){
                            if(hero.getArmories().size() == 0){
                                System.out.println("You don't own any armories to sell");
                            }
                            else {
                                hero.showArmories();
                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of item you want to sell\n", 1, hero.getArmories().size());
                                id = id - 1;
                                hero.setStarting_money(hero.getStarting_money() + (hero.getArmories().get(id).getCost() / 2));
                                hero.getArmories().remove(id);
                            }
                        }
                        else if(mchoice == 2){
                            if(hero.getWeapons().size() == 0){
                                System.out.println("You don't own any weapons to sell");
                            }
                            else {
                                hero.showWeapons();
                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of item you want to sell\n", 1, hero.getWeapons().size());
                                id = id - 1;
                                hero.setStarting_money(hero.getStarting_money() + (hero.getWeapons().get(id).getCost() / 2));
                                hero.getWeapons().remove(id);
                            }
                        }
                        else if(mchoice == 3){
                            if(hero.getPotions().size() == 0){
                                System.out.println("You don't own any potions to sell");
                            }
                            else {
                                hero.showPotions();
                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of item you want to sell\n", 1, hero.getPotions().size());
                                id = id - 1;
                                hero.setStarting_money(hero.getStarting_money() + (hero.getPotions().get(id).getCost() / 2));
                                hero.getPotions().remove(id);
                            }
                        }
                        System.out.println("\u001B[36m " + hero.getName() + " Inventory \u001b[0m");
                        hero.showInventory();
                        System.out.println(hero.getName() + "Info");
                        Display.displayHeroes(player.getHeroes());
                    }
                    if(GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Would you like to buy or sell any other item?\n1. Yes\n2. No\n", 1, 2) == 2){
                        System.out.println(hero.getName() + " You have left the market");
                        break;
                    }
                } while (true);
            }
        }
    }

    @Override
    public void startGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the game of Legends: Monsters and Heroes!!");
        player = new LegendsPlayer();
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
        market = new Market();
        market.createMarketList();
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
                                System.out.println("\u001B[42m You have moved \u001b[0m");
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
                                System.out.println("\u001B[42m You have moved \u001b[0m");
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
                                System.out.println("\u001B[42m You have moved \u001b[0m");
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
                                System.out.println("\u001B[42m You have moved \u001b[0m");
                                break label;
                            }
                            break;
                        case "e":
                            for (int i = 0; i < player.getnHero(); i++) {
                                System.out.println("\u001B[36m " + player.getHeroes().get(i).getName() + " Inventory \u001b[0m");
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
                        case "q":
                            System.out.println("Thanks for playing");
                            return;
                    }
                }
            }while (true);

            if(board.grid[board.getI()][board.getJ()].getSymbol().contains("M")){
                this.buySell();
            }
            else if(!board.grid[board.getI()][board.getJ()].getSymbol().contains("I") && GameFunctions.getRandomBoolean((float)0.17)){
                System.out.println("\u001B[41m You have encountered the monsters!! \u001b[0m");
                this.getMonsters(player);
                for(int i=0;i<player.getnHero();i++){
                    Fight fight1 = new Fight();
                }
                for(Monsters mon: this.getCurMonsters()){
                    System.out.println(mon.getName());
                }
                System.out.println(this.getCurMonsters());
            }

//            break;
        }
    }
}
