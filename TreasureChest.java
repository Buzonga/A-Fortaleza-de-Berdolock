public class TreasureChest {

    public String FindItem(int roll) {

        String item = "";

        switch (roll) {

            case 1:
                item = "Magic Sword";
                break;
            case 2:
                item = "Health Potion";
                break;
            case 3:
                item = "Ring of Trap Detection";
                break;
            case 4:
                item = "Magic Armour";
                break;
            case 5:
                item = "Gold Coins";
                break;
            case 6:
                item = "Cursed Item";
        }

        return item;
    }

}
