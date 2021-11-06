public interface isCastable {
//    void Cast(Heroes hero, Monsters monster);
    default void use(Monsters monster, LegendsPlayer player, int i, int id, Market market){
        int dmg = (int) (player.getHeroes().get(i).getSpells().get(id - 1).getDamage() * (1 + (player.getHeroes().get(i).getDexterity() / 10000)));
        monster.setHp(Math.max((monster.getHp() - dmg), 0));
        player.getHeroes().get(i).setMana(player.getHeroes().get(i).getMana() - player.getHeroes().get(i).getSpells().get(id-1).getMana_cost());
        System.out.println(player.getHeroes().get(i).getName() + " has dealt " + dmg + " damage!");
        if(market.getFireSpell().fireSpells.contains(player.getHeroes().get(i).getSpells().get(id-1))){
            monster.setDefense((int)(monster.getDefense() * (1 - 0.1)));
        }
        else if(market.getIceSpell().iceSpells.contains(player.getHeroes().get(i).getSpells().get(id-1))){
            monster.setDamage((int)(monster.getDamage() * (1 - 0.1)));
        }
        else
            monster.setDodge_chance((int)(monster.getDodge_chance() * (1 - 0.1)));

    }
}
