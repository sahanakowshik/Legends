import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Spirit extends Monsters{
    private int n;

//    public Spirit(){
//        int lineCount = 0;
//        try {
//            allLines = Files.readAllLines(Paths.get("/home/sahana/Documents/611/Legends/src/Legends_Monsters_and_Heroes/Spirits.txt"));
//            lineCount = allLines.size();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        this.n = lineCount;
//    }

    public static List<String> getList() {
        List<String> list = new ArrayList<>();
        try {
            allLines = Files.readAllLines(Paths.get("/home/sahana/Documents/611/Legends/src/Legends_Monsters_and_Heroes/Spirits.txt"));
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

    public int getN() {
        return this.n;
    }

    @Override
    public String getType() {
        return "Spirit";
    }

//    @Override
//    public void displayList() {
//        String[] words = allLines.get(0).split("/");
//        String line = String.join("   ", words);
//        System.out.println("Id   " + line);
//        for (int i=1;i<allLines.size();i++) {
//            System.out.print(i + "   ");
//            System.out.println(allLines.get(i));
//        }
//    }
}
