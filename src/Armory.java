import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Armory extends MarketItems{
    private int id;
    private String Name;
    private int cost;
    private int req_level;
    private int damage_reduction;
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

//    @Override
//    public void displayList() {
//        String[] words = allLines.get(0).split("/");
//        String line = String.join("   ", words);
//        System.out.println("Id   " + line);
//        for(Armory armory: armories){
//            System.out.format("%d  %20s %d  %d %d %s", armory.getId(), armory.getName(), armory.getCost(), armory.getReq_level(), armory.getDamage_reduction(), armory.getEquip());
//            System.out.println();
//        }
////        for (int i=1;i<allLines.size();i++) {
////            System.out.print(i + "   ");
////            System.out.println(allLines.get(i));
////        }
//    }

    public static List<String> getList() {
        try {
            allLines = Files.readAllLines(Paths.get("/home/sahana/Documents/611/Legends/src/Legends_Monsters_and_Heroes/Armory.txt"));
//            lineCount = allLines.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        for (int i=1;i<allLines.size();i++) {
            String str = i + "   " + allLines.get(i);
            list.add(str);
        }
        return list;
    }

}
