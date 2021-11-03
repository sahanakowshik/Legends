import java.util.List;

public abstract class Spell extends MarketItems implements isCastable, isBuyableSellable{
    private int id;
    private String Name;
    private int cost;
    private int req_level;
    private int damage;
    private int mana_cost;
    private String Equip;
    public static List<String> allLines;

//    public static List<String> getList();

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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMana_cost() {
        return mana_cost;
    }

    public void setMana_cost(int mana_cost) {
        this.mana_cost = mana_cost;
    }

    public String getEquip() {
        return Equip;
    }

    public void setEquip(String equip) {
        Equip = equip;
    }
}
