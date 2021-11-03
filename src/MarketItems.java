import java.util.ArrayList;
import java.util.List;

public abstract class MarketItems {
    public static List<String> allLines;
    public List<Armory> armories;
    public List<Weaponry> weapons;
    public abstract String getType();

    public abstract void displayList();

    public void createArmory(){
        List<String> list = Armory.getList();
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

    public void createWeapons(){
        List<String> list = Weaponry.getList();
        for(String str: list){
            String[] words = str.split("\\s+");
            Weaponry weapon = new Weaponry();
            weapon.setId(Integer.parseInt(words[0]));
            weapon.setName(words[1]);
            weapon.setCost(Integer.parseInt(words[2]));
            weapon.setLevel(Integer.parseInt(words[3]));
            weapon.setDamage(Integer.parseInt(words[4]));
            weapon.setReq_hands(Integer.parseInt(words[4]));
            weapon.setEquip("No");
            weapons.add(weapon);
        }
    }

    public void createMarketList(){

    }
}
