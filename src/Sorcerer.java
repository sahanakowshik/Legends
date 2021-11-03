import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Sorcerer extends Heroes{
    private int n;

    public Sorcerer(){
        int lineCount = 0;
        try {
            allLines = Files.readAllLines(Paths.get("/home/sahana/Documents/611/Legends/src/Legends_Monsters_and_Heroes/Sorcerers.txt"));
            lineCount = allLines.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.n = lineCount;
    }

    public int getN() {
        return this.n;
    }

    @Override
    public String getType() {
        return "Sorcerer";
    }

    @Override
    public void displayList() {
        String[] words = allLines.get(0).split("/");
        String line = String.join("   ", words);
        System.out.println("Id   " + line);
        for (int i=1;i<allLines.size();i++) {
            System.out.print(i + "   ");
            System.out.println(allLines.get(i));
        }
    }
}
