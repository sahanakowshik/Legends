import java.util.ArrayList;
import java.util.List;

public abstract class Heroes extends LegendsPlayer{
    private String name;
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int starting_money;
    private int starting_exp;
    private int level;
    private int hp;
    private List<Weaponry> weapons = new ArrayList<>();
    private List<Armory> armories = new ArrayList<>();
    private List<Potions> potions = new ArrayList<>();
    private List<Spell> spells = new ArrayList<>();

    public List<Weaponry> getWeapons() {
        return weapons;
    }

    public void addWeapon(Weaponry weapon) {
        this.weapons.add(weapon);
    }

    public List<Armory> getArmories() {
        return armories;
    }

    public void addArmory(Armory armory) {
        this.armories.add(armory);
    }

    public List<Potions> getPotions() {
        return potions;
    }

    public void addPotion(Potions potion) {
        this.potions.add(potion);
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void addSpell(Spell spell) {
        this.spells.add(spell);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStarting_money() {
        return starting_money;
    }

    public void setStarting_money(int starting_money) {
        this.starting_money = starting_money;
    }

    public int getStarting_exp() {
        return starting_exp;
    }

    public void displayHero(int i){
        System.out.format("%d   %20s    %8d     %4d    %4d    %4d     %4d     %4d     %4d    %2d%n", i+1, this.getName(), this.getLevel(), this.getHp(), this.getMana(), this.getStrength(), this.getAgility(), this.getDexterity(), this.getStarting_money(), this.getStarting_exp());
    }

    public void setStarting_exp(int starting_exp) {
        this.starting_exp = starting_exp;
    }

    public void showInventory(){
        System.out.println("List of armories:");
        Display.displayArmory(armories);
        System.out.println();
        System.out.println("List of weapons:");
        Display.displayWeaponry(weapons);
        System.out.println();
        System.out.println("List of potions:");
        Display.displayPotions(potions);
        System.out.println();
        System.out.println("List of spells");
        Display.displaySpells(spells);
    }

    public abstract int getN();

    public abstract String getType();

    public abstract void displayList();

    public abstract List<String> getAllLines();
}
