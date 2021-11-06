import java.util.*;

public class LegendsGame extends RpgGame{
    public Map<Integer,ArrayList<Monsters>> monsters=new HashMap<Integer,ArrayList<Monsters>>();
    private List<Monsters> curMonsters;
    private LegendsPlayer player;
    private Market market;

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

    public void createMonster(List<String> list, String type){
        Monsters monster;
        for(String str: list){
            String[] words = str.split("\\s+");
            if(Objects.equals(type, "Dragon"))
                monster = new Dragon();
            else if(Objects.equals(type, "Exoskeleton"))
                monster = new Exoskeleton();
            else
                monster = new Spirit();
            monster.setPlayerId(Integer.parseInt(words[0]));
            monster.setName(words[1]);
            monster.setLevel(Integer.parseInt(words[2]));
            monster.setHp(monster.getLevel() * 100);
            monster.setDamage(Integer.parseInt(words[3]));
            monster.setDefense(Integer.parseInt(words[4]));
            monster.setDodge_chance(Integer.parseInt(words[5]));
            monsters.get(Integer.parseInt(words[2])).add(monster);
        }
    }

    public void createMonsters(){
        for(int i=1;i<=10;i++){
            monsters.put(i, new ArrayList<Monsters>());
        }
        List<String> ld = Dragon.getList();
        createMonster(ld, "Dragon");
        List<String> le = Exoskeleton.getList();
        createMonster(le, "Exoskeleton");
        List<String> ls = Spirit.getList();
        createMonster(ls, "Spirit");
    }

    public void getMonsters(LegendsPlayer player){
        curMonsters = new ArrayList<>();
        for(Heroes hero: player.getHeroes()){
            curMonsters.add(monsters.get(hero.getLevel()).get(rand.nextInt(monsters.get(hero.getLevel()).size())));
        }
    }

//    public void buySell(){
//        System.out.println("\u001B[44m You have entered the market \u001B[0m");
//        for(Heroes hero: player.getHeroes()){
//            int heroChoice = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), hero.getName() + " would you like to enter the store\n1. Yes\n2. No\n", 1, 2);
//            if(heroChoice == 2)
//                continue;
//            else {
//                do {
//                    int val = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "What would you like to do?\n1. Buy\n2. Sell\n3. Exit\n", 1, 3);
//                    if (val == 1) {
//                        int mchoice = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "What would you like to buy?\n0. Exit\n1. Armory\n2. Weapon\n3. Potion\n4. Spell\n", 0, 4);
//                        if (mchoice == 1) {
//                            do {
//                                market.displayArmory();
//                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the Id of the item you want to buy\n0. Exit\n", 0, market.getArmory().armories.size());
//                                if (id != 0) {
//                                    id = id-1;
//                                    if (market.getArmory().armories.get(id).getReq_level() > hero.getLevel()) {
//                                        System.out.println("You cannot buy this item. it needs level " + market.getArmory().armories.get(id).getReq_level());
//                                    } else {
//                                        if (hero.getStarting_money() < market.getArmory().armories.get(id).getCost()) {
//                                            System.out.println("You don't have the balance to buy this item");
//                                        }
//                                        else if(hero.getArmories().contains(market.getArmory().armories.get(id))){
//                                            System.out.println("You already own this item");
//                                        }
//                                        else {
//                                            hero.setStarting_money(hero.getStarting_money() - market.getArmory().armories.get(id).getCost());
//                                            if(GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Would you like to equip this item?\n1. Yes\n2. No\n", 1, 2) == 1){
//                                                for(int i=0;i<hero.getArmories().size();i++){
//                                                    hero.getArmories().get(i).setEquip("No");
//                                                }
//                                                Armory item = market.getArmory().armories.get(id);
//                                                item.setEquip("Yes");
//                                                hero.getArmories().add(item);
//                                                hero.setIsEquipped(true);
//                                                hero.setCurArmory(item);
//                                            }
//                                            else{
//                                                hero.getArmories().add(market.getArmory().armories.get(id));
//                                            }
//                                            break;
//                                        }
//                                    }
//                                }
//                                else
//                                    break;
//                            }while (true);
//                            for(int i=0;i<hero.getArmories().size();i++){
//                                hero.getArmories().get(i).setId(i+1);
//                            }
//                        } else if (mchoice == 2) {
//                            do {
//                                market.displayWeaponry();
//                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the Id of the item you want to buy\n0. Exit\n", 0, market.getWeaponry().weapons.size());
//                                if (id != 0) {
//                                    id = id-1;
//                                    if (market.getWeaponry().weapons.get(id).getLevel() > hero.getLevel()) {
//                                        System.out.println("You cannot buy this item. it needs level " + market.getWeaponry().weapons.get(id).getLevel());
//                                    } else {
//                                        if (hero.getStarting_money() < market.getWeaponry().weapons.get(id).getCost()) {
//                                            System.out.println("You don't have the balance to buy this item");
//                                        }
//                                        else if(hero.getWeapons().contains(market.getWeaponry().weapons.get(id))){
//                                            System.out.println("You already own this item");
//                                        }
//                                        else {
//                                            hero.setStarting_money(hero.getStarting_money() - market.getWeaponry().weapons.get(id).getCost());
//                                            if(GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Would you like to equip this item?\n1. Yes\n2. No\n", 1, 2) == 1){
//                                                for(Weaponry item: hero.getWeapons()){
//                                                    item.setEquip("No");
//                                                }
//                                                Weaponry item = market.getWeaponry().weapons.get(id);
//                                                item.setEquip("Yes");
//                                                hero.getWeapons().add(item);
//                                                hero.setIsEquipped(true);
//                                                hero.setCurWeapon(item);
//                                            }
//                                            else{
//                                                hero.getWeapons().add(market.getWeaponry().weapons.get(id));
//                                            }
//                                            break;
//                                        }
//                                    }
//                                }
//                                else
//                                    break;
//                            }while (true);
//                            for(int i=0;i<hero.getWeapons().size();i++){
//                                hero.getWeapons().get(i).setId(i+1);
//                            }
//                        } else if (mchoice == 3) {
//                            do {
//                                market.displayPotions();
//                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the Id of the item you want to buy\n0. Exit\n", 0, market.getPotion().potions.size());
//                                if (id != 0) {
//                                    id = id-1;
//                                    if (market.getPotion().potions.get(id).getReq_level() > hero.getLevel()) {
//                                        System.out.println("You cannot buy this item. it needs level " + market.getPotion().potions.get(id).getReq_level());
//                                    } else {
//                                        if (hero.getStarting_money() < market.getPotion().potions.get(id).getCost()) {
//                                            System.out.println("You don't have the balance to buy this item");
//                                        }
//                                        else if(hero.getPotions().contains(market.getPotion().potions.get(id))){
//                                            System.out.println("You already own this item");
//                                        }
//                                        else {
//                                            hero.getPotions().add(market.getPotion().potions.get(id));
//                                            hero.setStarting_money(hero.getStarting_money() - market.getPotion().potions.get(id).getCost());
//                                            break;
//                                        }
//                                    }
//                                }
//                                else
//                                    break;
//                            }while (true);
//                            for(int i=0;i<hero.getPotions().size();i++){
//                                hero.getPotions().get(i).setId(i+1);
//                            }
//                        } else if (mchoice == 4) {
//                            int sp = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Which spell would you like to buy?\n0. Exit\n1. Fire Spell\n2. Ice Spell\n3. Lightning Spell\n", 0, 3);
//                            if (sp == 1) {
//                                do {
//                                    market.displayFireSpells();
//                                    int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the Id of the item you want to buy\n0. Exit\n", 0, market.getFireSpell().fireSpells.size());
//                                    if (id != 0) {
//                                        id = id-1;
//                                        if (market.getFireSpell().fireSpells.get(id).getReq_level() > hero.getLevel()) {
//                                            System.out.println("You cannot buy this item. it needs level " + market.getFireSpell().fireSpells.get(id).getReq_level());
//                                        } else {
//                                            if (hero.getStarting_money() < market.getFireSpell().fireSpells.get(id).getCost()) {
//                                                System.out.println("You don't have the balance to buy this item");
//                                            }
//                                            else if(hero.getSpells().contains(market.getFireSpell().fireSpells.get(id))){
//                                                System.out.println("You already own this item");
//                                            }
//                                            else {
//                                                hero.getSpells().add(market.getFireSpell().fireSpells.get(id));
//                                                hero.setStarting_money(hero.getStarting_money() - market.getFireSpell().fireSpells.get(id).getCost());
//                                                break;
//                                            }
//                                        }
//                                    }
//                                    else
//                                        break;
//                                }while (true);
//                            } else if (sp == 2) {
//                                do {
//                                    market.displayIceSpells();
//                                    int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the Id of the item you want to buy\n0. Exit\n", 0, market.getIceSpell().iceSpells.size());
//                                    if (id != 0) {
//                                        id = id-1;
//                                        if (market.getIceSpell().iceSpells.get(id).getReq_level() > hero.getLevel()) {
//                                            System.out.println("You cannot buy this item. it needs level " + market.getIceSpell().iceSpells.get(id).getReq_level());
//                                        } else {
//                                            if (hero.getStarting_money() < market.getIceSpell().iceSpells.get(id).getCost()) {
//                                                System.out.println("You don't have the balance to buy this item");
//                                            }
//                                            else if(hero.getSpells().contains(market.getIceSpell().iceSpells.get(id))){
//                                                System.out.println("You already own this item");
//                                            }
//                                            else {
//                                                hero.getSpells().add(market.getIceSpell().iceSpells.get(id));
//                                                hero.setStarting_money(hero.getStarting_money() - market.getIceSpell().iceSpells.get(id).getCost());
//                                                break;
//                                            }
//                                        }
//                                    }
//                                    else
//                                        break;
//                                }while (true);
//                            } else if (sp == 3) {
//                                do {
//                                    market.displayLightningSpells();
//                                    int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the Id of the item you want to buy\n0. Exit\n", 0, market.getLightningSpell().lightningSpells.size());
//                                    if (id != 0) {
//                                        id = id-1;
//                                        if (market.getLightningSpell().lightningSpells.get(id).getReq_level() > hero.getLevel()) {
//                                            System.out.println("You cannot buy this item. it needs level " + market.getLightningSpell().lightningSpells.get(id).getReq_level());
//                                        } else {
//                                            if (hero.getStarting_money() < market.getLightningSpell().lightningSpells.get(id).getCost()) {
//                                                System.out.println("You don't have the balance to buy this item");
//                                            }
//                                            else if(hero.getSpells().contains(market.getLightningSpell().lightningSpells.get(id))){
//                                                System.out.println("You already own this item");
//                                            }
//                                            else {
//                                                hero.getSpells().add(market.getLightningSpell().lightningSpells.get(id));
//                                                hero.setStarting_money(hero.getStarting_money() - market.getLightningSpell().lightningSpells.get(id).getCost());
//                                                break;
//                                            }
//                                        }
//                                    }
//                                    else
//                                        break;
//                                }while (true);
//                            }
//                            for(int i=0;i<hero.getSpells().size();i++){
//                                hero.getSpells().get(i).setId(i+1);
//                            }
//                        }
//                        System.out.println("\u001B[36m " + hero.getName() + " Inventory \u001b[0m");
//                        hero.showInventory();
//                        System.out.println(hero.getName() + "Info");
//                        Display.displayHeroes(player.getHeroes());
//
//                    } else if (val == 2) {
//                        hero.showInventory();
//                        int mchoice = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "What would you like to sell?\n0. Exit\n1. Armory\n2. Weapon\n3. Potion\n4. Spell\n", 0, 4);
//                        if(mchoice == 1){
//                            if(hero.getArmories().size() == 0){
//                                System.out.println("You don't own any armories to sell");
//                            }
//                            else {
//                                hero.showArmories();
//                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of item you want to sell\n0. Exit\n", 0, hero.getArmories().size());
//                                if(id != 0) {
//                                    id = id - 1;
//                                    hero.setStarting_money(hero.getStarting_money() + (hero.getArmories().get(id).getCost() / 2));
//                                    hero.getArmories().remove(id);
//                                }
//                            }
//                        }
//                        else if(mchoice == 2){
//                            if(hero.getWeapons().size() == 0){
//                                System.out.println("You don't own any weapons to sell");
//                            }
//                            else {
//                                hero.showWeapons();
//                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of item you want to sell\n0. Exit\n", 0, hero.getWeapons().size());
//                                if(id != 0) {
//                                    id = id - 1;
//                                    hero.setStarting_money(hero.getStarting_money() + (hero.getWeapons().get(id).getCost() / 2));
//                                    hero.getWeapons().remove(id);
//                                }
//                            }
//                        }
//                        else if(mchoice == 3){
//                            if(hero.getPotions().size() == 0){
//                                System.out.println("You don't own any potions to sell");
//                            }
//                            else {
//                                hero.showPotions();
//                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of item you want to sell\n0. Exit\n", 0, hero.getPotions().size());
//                                if(id != 0) {
//                                    id = id - 1;
//                                    hero.setStarting_money(hero.getStarting_money() + (hero.getPotions().get(id).getCost() / 2));
//                                    hero.getPotions().remove(id);
//                                }
//                            }
//                        }
//                        else if(mchoice == 4){
//                            if(hero.getSpells().size() == 0){
//                                System.out.println("You don't own any spells to sell");
//                            }
//                            else {
//                                hero.showSpells();
//                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of item you want to sell\n0. Exit\n", 0, hero.getSpells().size());
//                                if(id != 0) {
//                                    id = id - 1;
//                                    hero.setStarting_money(hero.getStarting_money() + (hero.getSpells().get(id).getCost() / 2));
//                                    hero.getSpells().remove(id);
//                                }
//                            }
//                        }
//                        System.out.println("\u001B[36m " + hero.getName() + " Inventory \u001b[0m");
//                        hero.showInventory();
//                        System.out.println(hero.getName() + "Info");
//                        Display.displayHeroes(player.getHeroes());
//                    }
//                    if(GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Would you like to buy or sell any other item?\n1. Yes\n2. No\n", 1, 2) == 2){
//                        System.out.println(hero.getName() + " You have left the market");
//                        break;
//                    }
//                } while (true);
//            }
//        }
//    }


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
                market.buySell(player);
            }
            else if(!board.grid[board.getI()][board.getJ()].getSymbol().contains("I") && GameFunctions.getRandomBoolean((float)0.17)){
                System.out.println("\u001B[41m You have encountered the monsters!! \u001b[0m");
                this.getMonsters(player);
                System.out.println(this.getCurMonsters().size());
                Display.displayHeroes(player.getHeroes());
                Display.displayMonsters(this.getCurMonsters());
                while(true) {
                    int monIndex = 0;
                    for (int i = 0; i < player.getnHero(); i++) {
                        System.out.println(player.getHeroes().get(i).getName() + " vs " + this.getCurMonsters().get(monIndex).getName());
                        Fight fight = new Fight();
                        while (true) {
                            int fchoice = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "What do you want to do?\n0. Quit\n1. Attack\n2. Cast a spell\n3. Use Potion\n4. Equip/Unequip an item\n", 1, 4);
                            if (fchoice == 0) {
                                System.out.println("Thanks for playing");
                                return;
                            } else if (fchoice == 1) {
                                if (GameFunctions.getRandomBoolean((float) (this.getCurMonsters().get(i).getDodge_chance() * 0.01))) {
                                    System.out.println("The monster has dodged the attack");
                                } else {
                                    int dmg;
                                    if (player.getHeroes().get(i).getWeapons().size() > 0) {
                                        dmg = (int) ((player.getHeroes().get(i).getStrength() + player.getHeroes().get(i).getCurWeapon().getDamage()) * 0.05);
                                    } else {
                                        dmg = (int) (player.getHeroes().get(i).getStrength() * 0.05);
                                    }
                                    this.getCurMonsters().get(i).setHp(Math.max((this.getCurMonsters().get(i).getHp() - dmg), 0));
                                    System.out.println(player.getHeroes().get(i).getName() + " has dealt " + dmg + " damage");
                                    Display.displayMonsters(this.getCurMonsters());
                                    if (this.getCurMonsters().get(i).getHp() <= 0) {
                                        System.out.println(player.getHeroes().get(i).getName() + " Won!");
                                        player.getHeroes().get(i).setStarting_money(player.getHeroes().get(i).getStarting_money() + this.getCurMonsters().get(i).getLevel() * 100);
                                        player.getHeroes().get(i).setStarting_exp(player.getHeroes().get(i).getStarting_exp() + 2);
                                        player.getHeroes().get(i).setExp(player.getHeroes().get(i).getExp() + 2);
//                                    this.getCurMonsters().remove(this.getCurMonsters().get(i));
                                        break;
                                    }
                                }
                            } else if (fchoice == 2) {
                                if (player.getHeroes().get(i).getSpells().size() == 0) {
                                    System.out.println("You don't have any spells to cast");
                                    continue;
                                } else {
                                    player.getHeroes().get(i).showSpells();
                                    int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of the spell you want to cast\n 0. Quit\n", 0, player.getHeroes().get(i).getSpells().size());
                                    if (id == 0) {
                                        System.out.println("Thanks for playing");
                                        return;
                                    } else if (player.getHeroes().get(i).getSpells().get(id - 1).getMana_cost() > player.getHeroes().get(i).getMana()) {
                                        System.out.println("You don't have the required mana to cast this spell");
                                        continue;
                                    } else {
//                                    int dmg = (int) (player.getHeroes().get(i).getSpells().get(id - 1).getDamage() * (1 + (player.getHeroes().get(i).getDexterity() / 10000)));
//                                    this.getCurMonsters().get(i).setHp(Math.max((this.getCurMonsters().get(i).getHp() - dmg), 0));
//                                    player.getHeroes().get(i).setMana(player.getHeroes().get(i).getMana() - player.getHeroes().get(i).getSpells().get(id-1).getMana_cost());
//                                    System.out.println(player.getHeroes().get(i).getName() + " has dealt " + dmg + " damage!");
//                                    if(market.getFireSpell().fireSpells.contains(player.getHeroes().get(i).getSpells().get(id-1))){
//                                        this.getCurMonsters().get(i).setDefense((int)(this.getCurMonsters().get(i).getDefense() * (1 - 0.1)));
//                                    }
//                                    else if(market.getIceSpell().iceSpells.contains(player.getHeroes().get(i).getSpells().get(id-1))){
//                                        this.getCurMonsters().get(i).setDamage((int)(this.getCurMonsters().get(i).getDamage() * (1 - 0.1)));
//                                    }
//                                    else
//                                        this.getCurMonsters().get(i).setDodge_chance((int)(this.getCurMonsters().get(i).getDodge_chance() * (1 - 0.1)));
                                        if (Objects.equals(player.getHeroes().get(i).getSpells().get(id - 1).getType(), "Fire Spell"))
                                            market.getFireSpell().use(this.getCurMonsters().get(i), player, i, id, market);
                                        else if (Objects.equals(player.getHeroes().get(i).getSpells().get(id - 1).getType(), "Ice Spell"))
                                            market.getIceSpell().use(this.getCurMonsters().get(i), player, i, id, market);
                                        else
                                            market.getLightningSpell().use(this.getCurMonsters().get(i), player, i, id, market);
//                                    Display.displayMonsters(this.getCurMonsters());
                                        if (this.getCurMonsters().get(i).getHp() <= 0) {
                                            System.out.println(player.getHeroes().get(i).getName() + " Won!");
                                            player.getHeroes().get(i).setStarting_money(player.getHeroes().get(i).getStarting_money() + this.getCurMonsters().get(i).getLevel() * 100);
                                            player.getHeroes().get(i).setStarting_exp(player.getHeroes().get(i).getStarting_exp() + 2);
                                            player.getHeroes().get(i).setExp(player.getHeroes().get(i).getExp() + 2);
                                            break;
                                        }
                                    }
                                }
                            } else if (fchoice == 3) {
                                if (player.getHeroes().get(i).getPotions().size() == 0) {
                                    System.out.println("You don't have any potions");
                                    continue;
                                } else {
                                    player.getHeroes().get(i).showPotions();
                                    int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of the potion you want to use\n 0. Quit\n", 0, player.getHeroes().get(i).getPotions().size());
                                    if (id == 0) {
                                        System.out.println("Thanks for playing");
                                        return;
                                    } else {
//                                    String[] words = player.getHeroes().get(i).getPotions().get(id-1).getAtt_affected().split("/");
//                                    player.getHeroes().get(i).usePotion(words, player.getHeroes().get(i).getPotions().get(id-1).getAtt_increase());
//                                    player.getHeroes().get(i).getPotions().remove(id-1);
                                        market.getPotion().use(player, i, id);
                                    }
                                }
                            } else {
                                if (GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Would you like to equip/unequip a weapon?\n1. Yes\n2. No\n", 1, 2) == 1) {
                                    if (player.getHeroes().get(i).getWeapons().size() == 0) {
                                        System.out.println("You don't own any weapon");
                                        continue;
                                    }
                                    player.getHeroes().get(i).showWeapons();
                                    int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Enter the id of the weapon you want to equip\n0. Quit\n", 0, player.getHeroes().get(i).getWeapons().size());
                                    if (id == 0)
                                        continue;
                                    for (Weaponry item : player.getHeroes().get(i).getWeapons()) {
                                        item.setEquip("No");
                                    }
                                    Weaponry item = player.getHeroes().get(i).getWeapons().get(id - 1);
                                    item.setEquip("Yes");
                                    player.getHeroes().get(i).getWeapons().add(item);
                                    player.getHeroes().get(i).setIsEquipped(true);
                                    player.getHeroes().get(i).setCurWeapon(item);
                                }
                                if (GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Would you like to equip/unequip an armory?\n1. Yes\n2. No\n", 1, 2) == 1) {
                                    if (player.getHeroes().get(i).getArmories().size() == 0) {
                                        System.out.println("You don't own any armory");
                                        continue;
                                    }
                                    player.getHeroes().get(i).showArmories();
                                    int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Enter the id of the armory you want to equip\n0. Quit\n", 0, player.getHeroes().get(i).getArmories().size());
                                    if (id == 0)
                                        continue;
                                    for (Armory item : player.getHeroes().get(i).getArmories()) {
                                        item.setEquip("No");
                                    }
                                    Armory item = player.getHeroes().get(i).getArmories().get(id - 1);
                                    item.setEquip("Yes");
                                    player.getHeroes().get(i).getArmories().add(item);
                                    player.getHeroes().get(i).setIsEquipped(true);
                                    player.getHeroes().get(i).setCurArmory(item);
                                }
                            }
                            player.getHeroes().get(i).setHp((int) (player.getHeroes().get(i).getHp() * (1.1)));
                            player.getHeroes().get(i).setMana((int) (player.getHeroes().get(i).getMana() * (1.1)));
                            Display.displayHeroes(player.getHeroes());
                            Display.displayMonsters(this.getCurMonsters());

                            int monDmg = (int) (this.getCurMonsters().get(i).getDamage() * 0.05);
                            if (GameFunctions.getRandomBoolean((float) (player.getHeroes().get(i).getAgility() * 0.002))) {
                                System.out.println("You have dodged the attack!!");
                                continue;
                            } else {
                                player.getHeroes().get(i).setHp(player.getHeroes().get(i).getHp() - monDmg);
                                System.out.println(this.getCurMonsters().get(i).getName() + " has dealt " + monDmg + "damage!");
                                if (player.getHeroes().get(i).getHp() <= 0) {
                                    System.out.println("Monster won!!");
                                }
                            }
                        }
                        if (player.getHeroes().get(i).getExp() >= (player.getHeroes().get(i).getLevel() * 10)) {
                            System.out.println(player.getHeroes().get(i).getName() + " Leveled up!");
                            player.getHeroes().get(i).setLevel(player.getHeroes().get(i).getLevel() + 1);
                            player.getHeroes().get(i).setMana((int) (player.getHeroes().get(i).getMana() * 1.1));
                            if (Objects.equals(player.getHeroes().get(i).getType(), "Warrior")) {
                                player.getHeroes().get(i).setStrength((int) (player.getHeroes().get(i).getStrength() * 1.1));
                                player.getHeroes().get(i).setAgility((int) (player.getHeroes().get(i).getAgility() * 1.1));
                                player.getHeroes().get(i).setDexterity((int) (player.getHeroes().get(i).getDexterity() * 1.05));
                            } else if (Objects.equals(player.getHeroes().get(i).getType(), "Sorcerer")) {
                                player.getHeroes().get(i).setStrength((int) (player.getHeroes().get(i).getStrength() * 1.05));
                                player.getHeroes().get(i).setAgility((int) (player.getHeroes().get(i).getAgility() * 1.1));
                                player.getHeroes().get(i).setDexterity((int) (player.getHeroes().get(i).getDexterity() * 1.1));
                            } else {
                                player.getHeroes().get(i).setStrength((int) (player.getHeroes().get(i).getStrength() * 1.1));
                                player.getHeroes().get(i).setAgility((int) (player.getHeroes().get(i).getAgility() * 1.05));
                                player.getHeroes().get(i).setDexterity((int) (player.getHeroes().get(i).getDexterity() * 1.1));
                            }
                            Display.displayHeroes(player.getHeroes());
                        }
                    }
//                for(Monsters mon: this.getCurMonsters()){
//                    System.out.println(mon.getName());
//                }
//                System.out.println(this.getCurMonsters());
                }
            }
        }
    }
}
