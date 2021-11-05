public class Market {
    // builder pattern
    // facade pattern
    private MarketItems armory;
    private MarketItems weaponry;
    private MarketItems potion;
    private MarketItems fireSpell;
    private MarketItems iceSpell;
    private MarketItems lightningSpell;

    public Market(){
        armory = new Armory();
        weaponry = new Weaponry();
        potion = new Potions();
        fireSpell = new FireSpell();
        iceSpell = new IceSpell();
        lightningSpell = new LightningSpell();
    }

    public MarketItems getArmory() {
        return armory;
    }

    public MarketItems getWeaponry() {
        return weaponry;
    }

    public MarketItems getPotion() {
        return potion;
    }

    public MarketItems getFireSpell() {
        return fireSpell;
    }

    public MarketItems getIceSpell() {
        return iceSpell;
    }

    public MarketItems getLightningSpell() {
        return lightningSpell;
    }

    public void createArmory(){
        armory.createList();
    }

    public void createWeapons(){
        weaponry.createList();
    }

    public void createPotions(){
        potion.createList();
    }

    public void createFireSpells(){
        fireSpell.createList();
    }

    public void createIceSpells(){
        iceSpell.createList();
    }

    public void createLightningSpells(){
        lightningSpell.createList();
    }

    public void displayArmory(){
        armory.display();
    }

    public void displayWeaponry(){
        weaponry.display();
    }

    public void displayPotions(){
        potion.display();
    }

    public void displayFireSpells(){
        fireSpell.display();
    }

    public void displayIceSpells(){
        iceSpell.display();
    }

    public void displayLightningSpells(){
        lightningSpell.display();
    }

    public void createSpells(){
        this.createFireSpells();
        this.createIceSpells();
        this.createLightningSpells();
    }

    public void createMarketList(){
        this.createArmory();
        this.createWeapons();
        this.createPotions();
        this.createSpells();
    }

}
