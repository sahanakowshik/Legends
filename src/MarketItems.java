import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MarketItems {
    public static List<String> allLines;
    public static List<Armory> armories;
    public static List<Weaponry> weapons;
    public static List<Potions> potions;

//    public abstract void displayList();

    public static void createArmory(){
        List<String> list = Armory.getList();
        armories = new ArrayList<>();
        for(String str: list){
            String[] words = str.split("\\s+");
            Armory armory = new Armory();
            armory.setId(Integer.parseInt(words[0]));
            armory.setName(words[1]);
            armory.setCost(Integer.parseInt(words[2]));
            armory.setReq_level(Integer.parseInt(words[3]));
            armory.setDamage_reduction(Integer.parseInt(words[4]));
            armory.setEquip("No");
            armories.add(armory);
        }
    }

    public static void createWeapons(){
        List<String> list = Weaponry.getList();
        weapons = new ArrayList<>();
        for(String str: list){
            String[] words = str.split("\\s+");
            Weaponry weapon = new Weaponry();
            weapon.setId(Integer.parseInt(words[0]));
            weapon.setName(words[1]);
            weapon.setCost(Integer.parseInt(words[2]));
            weapon.setLevel(Integer.parseInt(words[3]));
            weapon.setDamage(Integer.parseInt(words[4]));
            weapon.setReq_hands(Integer.parseInt(words[5]));
            weapon.setEquip("No");
            weapons.add(weapon);
        }
    }

    public static void createPotions(){
        List<String> list = Potions.getList();
        potions = new ArrayList<>();
        for(String str: list){
            String[] words = str.split("\\s+");
            Potions potion = new Potions();
            potion.setId(Integer.parseInt(words[0]));
            potion.setName(words[1]);
            potion.setCost(Integer.parseInt(words[2]));
            potion.setReq_level(Integer.parseInt(words[3]));
            potion.setAtt_increase(Integer.parseInt(words[4]));
            potion.setAtt_affected(words[5]);
            potion.setEquip("No");
            potions.add(potion);
        }
    }

    public static void createMarketList(){
        createArmory();
        createWeapons();
        createPotions();
    }

    public static void displayArmory(){
        try {
            allLines = Files.readAllLines(Paths.get("/home/sahana/Documents/611/Legends/src/Legends_Monsters_and_Heroes/Armory.txt"));
//            lineCount = allLines.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = allLines.get(0).split("/");
        String line = String.join("   ", words);
        System.out.println("Id   " + line + "   Equip");
        for(Armory armory: armories){
            System.out.format("%d   %15s   %4d   %2d   %4d   %3s", armory.getId(), armory.getName(), armory.getCost(), armory.getReq_level(), armory.getDamage_reduction(), armory.getEquip());
            System.out.println();
        }
    }

    public static void displayWeaponry(){
        try {
            allLines = Files.readAllLines(Paths.get("/home/sahana/Documents/611/Legends/src/Legends_Monsters_and_Heroes/Weaponry.txt"));
//            lineCount = allLines.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = allLines.get(0).split("/");
        String line = String.join("   ", words);
        System.out.println("Id   " + line + "   Equip");
        for(Weaponry weapon: weapons){
            System.out.format("%d   %7s   %4d   %2d   %4d   %2d   %3s", weapon.getId(), weapon.getName(), weapon.getCost(), weapon.getLevel(), weapon.getDamage(), weapon.getReq_hands(), weapon.getEquip());
            System.out.println();
        }
    }

    public static void displayPotions(){
        try {
            allLines = Files.readAllLines(Paths.get("/home/sahana/Documents/611/Legends/src/Legends_Monsters_and_Heroes/Potions.txt"));
//            lineCount = allLines.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = allLines.get(0).split("/");
        String line = String.join("   ", words);
        System.out.println("Id   " + line + "   Equip");
        for(Potions potion: potions){
            System.out.format("%d   %15s   %4d   %2d   %3d   %30s   %3s", potion.getId(), potion.getName(), potion.getCost(), potion.getReq_level(), potion.getAtt_increase(), potion.getAtt_affected(), potion.getEquip());
            System.out.println();
        }
    }
}
