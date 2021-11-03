import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Potions extends MarketItems{
    private int id;
    private String Name;
    private int cost;
    private int req_level;
    private int att_increase;
    private String att_affected;
    private String equip;

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

    public int getAtt_increase() {
        return att_increase;
    }

    public void setAtt_increase(int att_increase) {
        this.att_increase = att_increase;
    }

    public String getAtt_affected() {
        return att_affected;
    }

    public void setAtt_affected(String att_affected) {
        this.att_affected = att_affected;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

//    @Override
    public String getType() {
        return "Potions";
    }

//    @Override
//    public void displayList() {
//        String[] words = allLines.get(0).split("/");
//        String line = String.join("   ", words);
//        System.out.println("Id   " + line);
//        for(Potions potion: potions){
//            System.out.format("%d %20s %d %d %d %s %s", potion.getId(), potion.getName(), potion.getCost(), potion.getReq_level(), potion.getAtt_increase(), potion.getAtt_affected());
//            System.out.println();
//        }
////        for (int i=1;i<allLines.size();i++) {
////            System.out.print(i + "   ");
////            System.out.println(allLines.get(i));
////        }
//    }

    public static List<String> getList() {
        List<String> list = new ArrayList<>();
        try {
            allLines = Files.readAllLines(Paths.get("/home/sahana/Documents/611/Legends/src/Legends_Monsters_and_Heroes/Potions.txt"));
//            lineCount = allLines.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=1;i<allLines.size();i++) {
            String str = i + "   " + allLines.get(i);
            list.add(str);
        }
        return list;
    }
}
