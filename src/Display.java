import java.util.List;

public class Display {
    public static void displayBoard(Board board){
        for(int i=0;i<GameConstants.boardSize;i++){
            for(int j=0;j<GameConstants.boardSize;j++){
                System.out.print("=======");
            }
            System.out.println("==");
            for(int j=0;j<GameConstants.boardSize;j++) {
                System.out.print("||" + board.grid[i][j].getSymbol());
            }
            System.out.println("||");
        }
        for(int j=0;j<GameConstants.boardSize;j++){
            System.out.print("=======");
        }
        System.out.println("==");
    }

    public static void displayHeroes(List<Heroes> heroes){
        System.out.println("Id      Name                      Level   HP   mana strength agility dexterity starting money starting experience");
        for(int i=0;i<heroes.size();i++){
            heroes.get(i).displayHero(i);
        }
    }

    public static void displayInfo(){

    }

    public static void displayLegend(){
        System.out.println("---------Legend---------");
        System.out.println("M       = Market");
        System.out.println("I       = Blocked space");
        System.out.println("<Blank> = Common space");
        System.out.println("P       = Current player");
    }

    public static void displayArmory(List<Armory> armories){
        String[] words = Armory.allLines.get(0).split("/");
        String line = String.join("   ", words);
        System.out.println("Id   " + line + "   Equip");
        for(Armory armory: armories){
            System.out.format("%d   %15s   %4d   %2d   %4d   %3s", armory.getId(), armory.getName(), armory.getCost(), armory.getReq_level(), armory.getDamage_reduction(), armory.getEquip());
            System.out.println();
        }
    }

    public static void displayWeaponry(List<Weaponry> weapons){
        String[] words = Weaponry.allLines.get(0).split("/");
        String line = String.join("   ", words);
        System.out.println("Id   " + line + "   Equip");
        for(Weaponry weapon: weapons){
            System.out.format("%d   %7s   %4d   %2d   %4d   %2d   %3s", weapon.getId(), weapon.getName(), weapon.getCost(), weapon.getLevel(), weapon.getDamage(), weapon.getReq_hands(), weapon.getEquip());
            System.out.println();
        }
    }

    public static void displayPotions(List<Potions> potions){
        String[] words = Potions.allLines.get(0).split("/");
        String line = String.join("   ", words);
        System.out.println("Id   " + line + "   Equip");
        for(Potions potion: potions){
            System.out.format("%d   %15s   %4d   %2d   %3d   %30s   %3s", potion.getId(), potion.getName(), potion.getCost(), potion.getReq_level(), potion.getAtt_increase(), potion.getAtt_affected(), potion.getEquip());
            System.out.println();
        }
    }

    public static void displaySpells(List<Spell> spells){
        String[] words = Spell.allLines.get(0).split("/");
        String line = String.join("   ", words);
        System.out.println("Id   " + line + "   Equip");
        for(Spell spell: spells){
            System.out.format("%d   %16s   %4d   %2d   %4d   %4d   %3s", spell.getId(), spell.getName(), spell.getCost(), spell.getReq_level(), spell.getDamage(), spell.getMana_cost(), spell.getEquip());
            System.out.println();
        }
    }
}
