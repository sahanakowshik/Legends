import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Monsters extends LegendsPlayer{
    private String name;
    private int level;
    private int damage;
    private int defense;
    private int dodge_chance;

//    public Map<Integer,List<String>> monsters=new HashMap<Integer,List<String>>();
    // Combine monsters level wise and make list
    // add method to get n monsters at random

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDodge_chance() {
        return dodge_chance;
    }

    public void setDodge_chance(int dodge_chance) {
        this.dodge_chance = dodge_chance;
    }

//    public void createMonsters(){
//        for(int i=0;i<10;i++){
//            monsters.put(i, new ArrayList<String>());
//        }
//        List<String> ld = Dragon.getList();
//        for(String str: ld){
//            String[] words = str.split("\\s+");
//            monsters.get(Integer.parseInt(words[2])).add(str);
//        }
//        List<String> le = Exoskeleton.getList();
//        for(String str: le){
//            String[] words = str.split("\\s+");
//            monsters.get(Integer.parseInt(words[2])).add(str);
//        }
//        List<String> ls = Spirit.getList();
//        for(String str: ls){
//            String[] words = str.split("\\s+");
//            monsters.get(Integer.parseInt(words[2])).add(str);
//        }
//        System.out.println(monsters);
//    }

//    public void displayMonster(int i){
//        System.out.format("%d   %20s    %10d     %d     %d%n", i+1, this.getName(), this.getLevel(), this.getDamage(), this.getDefense(), this.getDodge_chance());
//    }
    public abstract int getN();

    public abstract String getType();

}
