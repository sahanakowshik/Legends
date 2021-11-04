import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IceSpell extends Spell{
//    public static List<String> allLines;

    public static List<String> getAllLines() {
        return allLines;
    }

    public String getType() {
        return "Ice Spell";
    }

    @Override
    public void display(){
        Display.displaySpells(iceSpells);
    }

    //    @Override
    public static List<String> getList() {
        allLines = Parser.parser("IceSpells.txt");
        List<String> list = new ArrayList<>();
        for (int i=1;i<allLines.size();i++) {
            String str = i + "   " + allLines.get(i);
            list.add(str);
        }
        return list;
    }
}
