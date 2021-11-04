public class Market {
    // builder pattern
    // facade pattern
    private MarketItems armory;
    private MarketItems weaponry;
    private MarketItems potion;
    private MarketItems fireSpell;
    private MarketItems iceSpell;
    private MarketItems lightningSpell;


    public void createMarket(){
        MarketItems.createMarketList();
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

}
