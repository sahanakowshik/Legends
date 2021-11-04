public class Market {
    // builder pattern
    public void createMarket(){
        MarketItems.createMarketList();
        Armory.displayArmory();
        Weaponry.displayWeaponry();
        Potions.displayPotions();
        FireSpell.displayFireSpells();
        IceSpell.displayIceSpells();
        LightningSpell.displayLightningSpells();
    }
}
