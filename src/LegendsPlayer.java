import java.util.*;

public class LegendsPlayer extends Player{
    private int nHero;
    private String symbol;
    private List<Heroes> heroes;

    public List<Monsters> getCurMonsters() {
        return curMonsters;
    }

    private List<Monsters> curMonsters;
    public Map<Integer,ArrayList<Monsters>> monsters=new HashMap<Integer,ArrayList<Monsters>>();

    public List<Heroes> getHeroes() {
        return heroes;
    }

    public void setHeroes() {
        this.heroes = new ArrayList<>();
    }


    public String getSymbol() {
        return symbol;
    }

    public void addHeroes(){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<this.getnHero();i++){
            int choice = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the hero class:\n1. Warrior\n2. Sorceror\n3. Paladin\n", 1, 3);
            if(choice == 1) {
                heroes.add(new Warrior());
            }
            else if(choice == 2) {
                heroes.add(new Sorcerer());
            }
            else {
                heroes.add(new Paladin());
            }
            System.out.println(heroes.get(i).getType() + " List:\n");
            heroes.get(i).displayList();
            int id = GameFunctions.safeScanIntWithLimit(new Scanner(System.in), "Please enter the id of the hero\n", 1, heroes.get(i).getN());
            String[] str = heroes.get(i).allLines.get(id).split("\\s+");
            heroes.get(i).setPlayerId(id);
            heroes.get(i).setName(str[0]);
            heroes.get(i).setMana(Integer.parseInt(str[1]));
            heroes.get(i).setStrength(Integer.parseInt(str[2]));
            heroes.get(i).setAgility(Integer.parseInt(str[3]));
            heroes.get(i).setDexterity(Integer.parseInt(str[4]));
            heroes.get(i).setStarting_money(Integer.parseInt(str[5]));
            heroes.get(i).setStarting_exp(Integer.parseInt(str[6]));
            heroes.get(i).setHp(100);
            heroes.get(i).setLevel(1);
        }

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
//        for(int i=1;i<=10;i++){
//            System.out.println(monsters.get(i).size());
//        }
    }

    public void getMonsters(int count, int level){
        ArrayList<Monsters> list = monsters.get(level);
        Collections.shuffle(list);
        curMonsters = list.subList(0, count);
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getnHero() {
        return nHero;
    }

    public void setnHero(int nHero) {
        this.nHero = nHero;
    }


//    public int getLevel() {
//        return level;
//    }
//
//    public void setLevel(int level) {
//        this.level = level;
//    }
//
//    public int getHp() {
//        return hp;
//    }
//
//    public void setHp(int hp) {
//        this.hp = hp;
//    }
}
