import java.util.Objects;

class Item {
	
	private String name;
	private String rarity;
	public int upgradeCountEpic;
	
	public static String[] rarities = {"Common", "Great", "Rare", "Epic", "Legendary"};
	public static String[] names = {"Sentinel Shield", "Devout Amulet", "Elven Chainmail", "Flame dagger", "Moonbow", "Billowing Cloak"};
	
	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return (this.name == item.name) && (this.rarity == item.rarity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rarity);
    }
	
	Item (String name, String rarity){
		this.name = name;
		this.rarity = rarity;
		this.upgradeCountEpic = 0;
	}
	
	Item (String name, String rarity, int upgradeCountEpic){
		this(name, rarity);
		this.upgradeCountEpic = upgradeCountEpic;
		if (rarity == "Epic" && upgradeCountEpic > 0) {
			this.rarity	= rarity + " " + upgradeCountEpic;
		}
	}
	
	public String getName() {
		return this.name;
	}
	public String getRarity() {
		return this.rarity;
	}
	public void displayItem() {
		System.out.println(this.getRarity() + " " + this.getName());
	}
}