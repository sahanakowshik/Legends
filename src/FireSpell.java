import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FireSpell extends Spell{
    public static List<String> allLines;
    public String getType() {
        return "Fire Spell";
    }

    //    @Override
    public static void displayFireSpells(){
        String[] words = allLines.get(0).split("/");
        String line = String.join("   ", words);
        System.out.println("Id   " + line + "   Equip");
        for(Spell spell: fireSpells){
            System.out.format("%d   %15s   %4d   %2d   %4d   %4d   %3s", spell.getId(), spell.getName(), spell.getCost(), spell.getReq_level(), spell.getDamage(), spell.getMana_cost(), spell.getEquip());
            System.out.println();
        }
    }

    //    @Override
    public static List<String> getList() {
        try {
            allLines = Files.readAllLines(Paths.get("/home/sahana/Documents/611/Legends/src/Legends_Monsters_and_Heroes/FireSpells.txt"));
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
