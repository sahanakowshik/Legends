import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Parser {
    // Class to parse the configuration files
    private static List<String> allLines;

    public static List<String> parser(String name){
        try {
            allLines = Files.readAllLines(Paths.get("src/Legends_Monsters_and_Heroes/" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allLines;
    }

}
