import java.util.*;

public class LegendsGame extends RpgGame{
    public Map<Integer,ArrayList<Monsters>> monsters=new HashMap<Integer,ArrayList<Monsters>>();
    private List<Monsters> curMonsters; // Stores monsters in each fight
    private LegendsPlayer player;
    private Market market;
    ASCIIArtGenerator artGen = new ASCIIArtGenerator();

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
        // Creates monsters array and stores it grouped by their level
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
        // Maps all monsters with their level and creates a list
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
        // Returns random monsters of same level as the hero from the list of monsters
        Random rand = new Random();
        curMonsters = new ArrayList<>();
        for(Heroes hero: player.getHeroes()){
            while (true) { // Avoiding repetition of monsters
                Monsters monster = monsters.get(hero.getLevel()).get(rand.nextInt(monsters.get(hero.getLevel()).size()));
                if (curMonsters.contains(monster)) {
                    continue;
                }
                else {
                    curMonsters.add(monster);
                    break;
                }
            }
        }
    }

    @Override
    public void startGame() throws Exception {
        // The game starts
        artGen.printTextArt("Welcome", ASCIIArtGenerator.ART_SIZE_MEDIUM);
        System.out.println("Welcome to the game of Legends: Monsters and Heroes!!");
        player = new LegendsPlayer();
        player.setName(GameFunctions.safeScanString(new Scanner(System.in), "Please enter your name:\n"));
        player.setnHero(GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the number of heroes (1-3):\n", 1, 3));
        player.setSymbol(GameFunctions.safeScanString(new Scanner(System.in), "Please enter your symbol:\n"));
        player.setHeroes();
        LegendsBoard board = new LegendsBoard();
        board.createBoard(); // Creates a map
        board.addPlayer(player);
        System.out.println("Lets build the team");
        player.addHeroes(); // Heroes are added to players
        System.out.println("Your team:");
        Display.displayHeroes(player.getHeroes());
        this.createMonsters(); // Creates monsters
        market = new Market();
        market.createMarketList(); // A market is created
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
                int level = 1;
                System.out.println(this.getCurMonsters().size());
                Display.displayHeroes(player.getHeroes());
                Display.displayMonsters(this.getCurMonsters());
                int heroFlag = 0;
                int monsterFlag = 0;
                int n = 0;
                while(this.getCurMonsters().size() > 0 && n < player.getHeroes().size()) {
                    int monIndex = 0;
                    for (int i = 0; i < player.getnHero(); i++) {
                        Heroes curHero = player.getHeroes().get(i);
                        Monsters curMonster = this.getCurMonsters().get(monIndex);
                        System.out.println(curHero.getName() + " vs " + curMonster.getName());
                        Fight fight = new Fight();
                        int fchoice = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "What do you want to do?\n0. Quit\n1. Attack\n2. Cast a spell\n3. Use Potion\n4. Equip/Unequip an item\n", 1, 4);
                        if (fchoice == 0) {
                            System.out.println("Thanks for playing");
                            return;
                        } else if (fchoice == 1) {
                            if (GameFunctions.getRandomBoolean((float) (curMonster.getDodge_chance() * 0.01))) {
                                System.out.println("The monster has dodged the attack");
                            } else {
                                int dmg;
                                if (curHero.getWeapons().size() > 0) {
                                    dmg = (int) ((curHero.getStrength() + curHero.getCurWeapon().getDamage()) * 0.05);
                                } else {
                                    dmg = (int) (curHero.getStrength() * 0.05);
                                }
                                curMonster.setHp(Math.max((curMonster.getHp() - dmg), 0));
                                System.out.println(curHero.getName() + " has dealt " + dmg + " damage");
//                                Display.displayMonsters(this.getCurMonsters());
                                if (curMonster.getHp() <= 0) {
                                    Display.displayMonsters(this.getCurMonsters());
                                    System.out.println(curHero.getName() + " Won!");
                                    level = Math.max(level, curMonster.getLevel());
                                    heroFlag = 1;
//                                    curHero.setStarting_money(curHero.getStarting_money() + curMonster.getLevel() * 100);
//                                    curHero.setStarting_exp(curHero.getStarting_exp() + 2);
//                                    curHero.setExp(curHero.getExp() + 2);
                                    curMonster.setHp(curMonster.getLevel() * 100);
                                    this.getCurMonsters().remove(curMonster);
//                                    monIndex--;
                                    if(this.getCurMonsters().size() == 0)
                                        break;
                                    monIndex = (monIndex) % this.getCurMonsters().size();
                                    continue;
                                }
                            }
                            monIndex = (monIndex+1) % this.getCurMonsters().size();
                        } else if (fchoice == 2) {
                            if (curHero.getSpells().size() == 0) {
                                System.out.println("You don't have any spells to cast");
                                i--;
                                continue;
                            } else {
                                curHero.showSpells();
                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of the spell you want to cast\n 0. Quit\n", 0, curHero.getSpells().size());
                                if (id == 0) {
                                    System.out.println("Thanks for playing");
                                    return;
                                } else if (curHero.getSpells().get(id - 1).getMana_cost() > curHero.getMana()) {
                                    System.out.println("You don't have the required mana to cast this spell");
                                    i--;
                                    continue;
                                } else {
//                                    int dmg = (int) (curHero.getSpells().get(id - 1).getDamage() * (1 + (curHero.getDexterity() / 10000)));
//                                    curMonster.setHp(Math.max((curMonster.getHp() - dmg), 0));
//                                    curHero.setMana(curHero.getMana() - curHero.getSpells().get(id-1).getMana_cost());
//                                    System.out.println(curHero.getName() + " has dealt " + dmg + " damage!");
//                                    if(market.getFireSpell().fireSpells.contains(curHero.getSpells().get(id-1))){
//                                        curMonster.setDefense((int)(curMonster.getDefense() * (1 - 0.1)));
//                                    }
//                                    else if(market.getIceSpell().iceSpells.contains(curHero.getSpells().get(id-1))){
//                                        curMonster.setDamage((int)(curMonster.getDamage() * (1 - 0.1)));
//                                    }
//                                    else
//                                        curMonster.setDodge_chance((int)(curMonster.getDodge_chance() * (1 - 0.1)));
                                    if (Objects.equals(curHero.getSpells().get(id - 1).getType(), "Fire Spell"))
                                        market.getFireSpell().use(curMonster, curHero, i, id, market);
                                    else if (Objects.equals(curHero.getSpells().get(id - 1).getType(), "Ice Spell"))
                                        market.getIceSpell().use(curMonster, curHero, i, id, market);
                                    else
                                        market.getLightningSpell().use(curMonster, curHero, i, id, market);
//                                    Display.displayMonsters(this.getCurMonsters());
                                    if (curMonster.getHp() <= 0) {
                                        Display.displayMonsters(this.getCurMonsters());
                                        System.out.println(curHero.getName() + " Won!");
                                        level = Math.max(level, curMonster.getLevel());
                                        heroFlag = 1;
//                                        curHero.setStarting_money(curHero.getStarting_money() + curMonster.getLevel() * 100);
//                                        curHero.setStarting_exp(curHero.getStarting_exp() + 2);
//                                        curHero.setExp(curHero.getExp() + 2);
                                        curMonster.setHp(curMonster.getLevel() * 100);
                                        this.getCurMonsters().remove(curMonster);
//                                        monIndex--;
                                        if(this.getCurMonsters().size() == 0)
                                            break;
                                        monIndex = (monIndex) % this.getCurMonsters().size();
                                        continue;
                                    }
                                }
                            }
                            monIndex = (monIndex+1) % this.getCurMonsters().size();
                        } else if (fchoice == 3) {
                            if (curHero.getPotions().size() == 0) {
                                System.out.println("You don't have any potions");
                                i--;
                                continue;
                            } else {
                                curHero.showPotions();
                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of the potion you want to use\n 0. Quit\n", 0, curHero.getPotions().size());
                                if (id == 0) {
                                    System.out.println("Thanks for playing");
                                    return;
                                } else {
//                                    String[] words = curHero.getPotions().get(id-1).getAtt_affected().split("/");
//                                    curHero.usePotion(words, curHero.getPotions().get(id-1).getAtt_increase());
//                                    curHero.getPotions().remove(id-1);
                                    market.getPotion().use(player, i, id);
                                    monIndex = (monIndex+1) % this.getCurMonsters().size();
                                }
                            }
                        } else {
                            if (GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Would you like to equip/unequip a weapon?\n1. Yes\n2. No\n", 1, 2) == 1) {
                                if (curHero.getWeapons().size() == 0) {
                                    System.out.println("You don't own any weapon");
                                    i--;
                                    continue;
                                }
                                curHero.showWeapons();
                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Enter the id of the weapon you want to equip\n0. Quit\n", 0, curHero.getWeapons().size());
                                if (id == 0) {
                                    i--;
                                    continue;
                                }
                                for (Weaponry item : curHero.getWeapons()) {
                                    item.setEquip("No");
                                }
                                Weaponry item = curHero.getWeapons().get(id - 1);
                                item.setEquip("Yes");
                                curHero.getWeapons().add(item);
                                curHero.setIsEquipped(true);
                                curHero.setCurWeapon(item);
                                i--;
                            }
                            if (GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Would you like to equip/unequip an armory?\n1. Yes\n2. No\n", 1, 2) == 1) {
                                if (curHero.getArmories().size() == 0) {
                                    System.out.println("You don't own any armory");
                                    i--;
                                    continue;
                                }
                                curHero.showArmories();
                                int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Enter the id of the armory you want to equip\n0. Quit\n", 0, curHero.getArmories().size());
                                if (id == 0){
                                    i--;
                                    continue;
                                }
                                for (Armory item : curHero.getArmories()) {
                                    item.setEquip("No");
                                }
                                Armory item = curHero.getArmories().get(id - 1);
                                item.setEquip("Yes");
                                curHero.getArmories().add(item);
                                curHero.setIsEquipped(true);
                                curHero.setCurArmory(item);
                                i--;
                            }
                        }
                        curHero.setHp((int) (curHero.getHp() * (1.1)));
                        curHero.setMana((int) (curHero.getMana() * (1.1)));
                        Display.displayHeroes(player.getHeroes());
                        Display.displayMonsters(this.getCurMonsters());

                        int monDmg = (int) (curMonster.getDamage() * 0.05);
                        if (GameFunctions.getRandomBoolean((float) (curHero.getAgility() * 0.002))) {
                            System.out.println("You have dodged the attack!");
                            continue;
                        } else {
                            if(curHero.getArmories().size() == 0)
                                curHero.setHp(Math.max((curHero.getHp() - monDmg),0));
                            else
                                curHero.setHp(Math.max(Math.min((curHero.getHp() + curHero.getCurArmory().getDamage_reduction() - monDmg), curHero.getHp()),0));
                            System.out.println(curMonster.getName() + " has dealt " + monDmg + "damage!");
                            if (curHero.getHp() <= 0) {
                                System.out.println("Monster won!!");
                                monsterFlag = 1;
                                n++;
                            }
                        }
                    }
                }
                if(heroFlag == 0 && monsterFlag == 1){ // Monsters win the fight
                    System.out.println("Monsters won the fight");
                    for(Heroes hero : player.getHeroes()){
                        hero.setHp((hero.getLevel() * 100) / 2);
                    }
                }
                else if(heroFlag == 1) { // Heroes win the fight
                    System.out.println("Heroes won the fight");
                    for (Heroes hero : player.getHeroes()) {
                        if (hero.getHp() != 0) {
                            hero.setStarting_money(hero.getStarting_money() + level * 100);
                            hero.setStarting_exp(hero.getStarting_exp() + 2);
                            hero.setExp(hero.getExp() + 2);
                        }
                        else{
                            hero.setHp((hero.getLevel() * 100) / 2);
                        }
                        if (hero.getExp() >= (hero.getLevel() * 10)) {
                            hero.levelUp();
                            Display.displayHeroes(player.getHeroes());
                        }
                    }
                }
            }
        }
    }
}
