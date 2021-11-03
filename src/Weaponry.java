import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Weaponry extends MarketItems{
    private int id;
    private String Name;
    private int cost;
    private int level;
    private int damage;
    private String equip;

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

    public int getReq_hands() {
        return req_hands;
    }

    public void setReq_hands(int req_hands) {
        this.req_hands = req_hands;
    }

    private int req_hands;

    @Override
    public String getType() {
        return "Weaponry";
    }

    @Override
    public void displayList() {
        List<String> list = new ArrayList<>();
        try {
            allLines = Files.readAllLines(Paths.get("/home/sahana/Documents/611/Legends/src/Legends_Monsters_and_Heroes/Weaponry.txt"));
//            lineCount = allLines.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = allLines.get(0).split("/");
        String line = String.join("   ", words);
        System.out.println("Id   " + line);
        for (int i=1;i<allLines.size();i++) {
            System.out.print(i + "   ");
            System.out.println(allLines.get(i));
        }
    }

    public static List<String> getList() {
        List<String> list = new ArrayList<>();
        for (int i=1;i<allLines.size();i++) {
            String str = i + "   " + allLines.get(i);
            list.add(str);
        }
        return list;
    }
}
