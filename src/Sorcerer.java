import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Sorcerer extends Heroes{
    private List<String> allLines;
    private int n;

    public List<String> getAllLines() {
        return allLines;
    }

    public Sorcerer(){
        allLines = Parser.parser("Sorcerer.txt");
        this.n = allLines.size();
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
