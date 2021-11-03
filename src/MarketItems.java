import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class MarketItems {
    public static List<Armory> armories;
    public static List<Weaponry> weapons;
    public static List<Potions> potions;
    public static List<Spell> fireSpells;
    public static List<Spell> iceSpells;
    public static List<Spell> lightningSpells;

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



    public static void createFireSpells(){
        List<String> list = FireSpell.getList();
        fireSpells = new ArrayList<>();
        for(String str: list){
            String[] words = str.split("\\s+");
            Spell spell = new FireSpell();
            spell.setId(Integer.parseInt(words[0]));
            spell.setName(words[1]);
            spell.setCost(Integer.parseInt(words[2]));
            spell.setReq_level(Integer.parseInt(words[3]));
            spell.setDamage(Integer.parseInt(words[4]));
            spell.setMana_cost(Integer.parseInt(words[5]));
            spell.setEquip("No");
            fireSpells.add(spell);
        }
    }

    public static void createIceSpells(){
        List<String> list = IceSpell.getList();
        iceSpells = new ArrayList<>();
        for(String str: list){
            String[] words = str.split("\\s+");
            Spell spell = new FireSpell();
            spell.setId(Integer.parseInt(words[0]));
            spell.setName(words[1]);
            spell.setCost(Integer.parseInt(words[2]));
            spell.setReq_level(Integer.parseInt(words[3]));
            spell.setDamage(Integer.parseInt(words[4]));
            spell.setMana_cost(Integer.parseInt(words[5]));
            spell.setEquip("No");
            iceSpells.add(spell);
        }
    }

    public static void createLightningSpells(){
        List<String> list = LightningSpell.getList();
        lightningSpells = new ArrayList<>();
        for(String str: list){
            String[] words = str.split("\\s+");
            Spell spell = new FireSpell();
            spell.setId(Integer.parseInt(words[0]));
            spell.setName(words[1]);
            spell.setCost(Integer.parseInt(words[2]));
            spell.setReq_level(Integer.parseInt(words[3]));
            spell.setDamage(Integer.parseInt(words[4]));
            spell.setMana_cost(Integer.parseInt(words[5]));
            spell.setEquip("No");
            lightningSpells.add(spell);
        }
    }

    public static void createSpells(){
        createFireSpells();
        createIceSpells();
        createLightningSpells();
    }

    public static void createMarketList(){
        createArmory();
        createWeapons();
        createPotions();
        createSpells();
    }
}
