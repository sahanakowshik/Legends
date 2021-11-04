import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Armory extends MarketItems implements isUsable, isBuyableSellable{
    public static List<String> allLines;
    private int id;
    private String Name;
    private int cost;
    private int req_level;
    private int damage_reduction;
    private String equip;

    public static List<String> getAllLines() {
        return allLines;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getReq_level() {
        return req_level;
    }

    public void setReq_level(int req_level) {
        this.req_level = req_level;
    }

    public int getDamage_reduction() {
        return damage_reduction;
    }

    public void setDamage_reduction(int damage_reduction) {
        this.damage_reduction = damage_reduction;
    }

    public String getType() {
        return "Armory";
    }

    @Override
    public void display(){
        Display.displayArmory(armories);
    }

    @Override
    public void createList() {
        List<String> list = this.getList();
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

    //    @Override
    public List<String> getList() {
        allLines = Parser.parser("Armory.txt");
        List<String> list = new ArrayList<>();
        for (int i=1;i<allLines.size();i++) {
            String str = i + "   " + allLines.get(i);
            list.add(str);
        }
        return list;
    }

}
