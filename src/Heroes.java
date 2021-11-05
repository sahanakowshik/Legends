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
    private int defense;
    private Weaponry curWeapon;
    private Armory curArmory;
    private List<Weaponry> weapons;
    private List<Armory> armories;
    private List<Potions> potions;
    private List<Spell> spells;
    private boolean isEquipped;

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Weaponry getCurWeapon() {
        return curWeapon;
    }

    public void setCurWeapon(Weaponry curWeapon) {
        this.curWeapon = curWeapon;
    }

    public Armory getCurArmory() {
        return curArmory;
    }

    public void setCurArmory(Armory curArmory) {
        this.curArmory = curArmory;
    }

    public boolean getIsEquipped() {
        return isEquipped;
    }

    public void setIsEquipped(boolean isEquipped) {
        this.isEquipped = isEquipped;
    }

    public Heroes(){
        weapons = new ArrayList<>();
        armories = new ArrayList<>();
        potions = new ArrayList<>();
        spells = new ArrayList<>();
        isEquipped = false;
    }

    public void usePotion(String[] words, int att_inc){
        for(String word: words){
            if(word.toLowerCase().equals("mana"))
                this.setMana(this.getMana() + att_inc);
            else if(word.toLowerCase().equals("health"))
                this.setHp(this.getHp() + att_inc);
            else if(word.toLowerCase().equals("strength"))
                this.setStrength(this.getStrength() + att_inc);
            else if(word.toLowerCase().equals("agility"))
                this.setAgility(this.getAgility() + att_inc);
            else if(word.toLowerCase().equals("dexterity"))
                this.setDexterity(this.getDexterity() + att_inc);
            else if(word.toLowerCase().equals("defense"))
                this.setDefense(this.getDefense() + att_inc);
        }
    }

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
        System.out.format("%d   %20s    %8d     %4d    %4d    %4d     %4d     %4d     %4d    %2d  %3d%n", i+1, this.getName(), this.getLevel(), this.getHp(), this.getMana(), this.getStrength(), this.getAgility(), this.getDexterity(), this.getStarting_money(), this.getStarting_exp(), this.getDefense());
    }

    public void setStarting_exp(int starting_exp) {
        this.starting_exp = starting_exp;
    }

    public void showInventory(){
        this.showArmories();
        System.out.println();
        this.showWeapons();
        System.out.println();
        this.showPotions();
        System.out.println();
        this.showSpells();
    }

    public void showArmories(){
        System.out.println("\u001B[33m List of armories: \u001b[0m");
        Display.displayArmory(armories);
    }

    public void showWeapons(){
        System.out.println("\u001B[33m List of weapons: \u001b[0m");
        Display.displayWeaponry(weapons);
    }

    public void showPotions(){
        System.out.println("\u001B[33m List of potions: \u001b[0m");
        Display.displayPotions(potions);
    }

    public void showSpells(){
        System.out.println("\u001B[33m List of spells \u001b[0m");
        Display.displaySpells(spells);
    }

    public abstract int getN();

    public abstract String getType();

    public abstract void displayList();

    public abstract List<String> getAllLines();
}
