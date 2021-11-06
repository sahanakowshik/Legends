public interface isDrinkable {
    default void use(LegendsPlayer player, int i, int id){
        String[] words = player.getHeroes().get(i).getPotions().get(id-1).getAtt_affected().split("/");
        player.getHeroes().get(i).usePotion(words, player.getHeroes().get(i).getPotions().get(id-1).getAtt_increase());
        player.getHeroes().get(i).getPotions().remove(id-1);
    }
}
